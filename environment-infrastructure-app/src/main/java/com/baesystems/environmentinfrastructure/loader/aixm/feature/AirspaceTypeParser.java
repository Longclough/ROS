package com.baesystems.environmentinfrastructure.loader.aixm.feature;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

import aero.aixm.schema._5.AbstractAIXMFeatureType;
import aero.aixm.schema._5.AirspaceActivationPropertyType;
import aero.aixm.schema._5.AirspaceActivationType;
import aero.aixm.schema._5.AirspaceGeometryComponentPropertyType;
import aero.aixm.schema._5.AirspaceTimeSlicePropertyType;
import aero.aixm.schema._5.AirspaceTimeSliceType;
import aero.aixm.schema._5.AirspaceType;
import aero.aixm.schema._5.AirspaceVolumeDependencyPropertyType;
import aero.aixm.schema._5.AirspaceVolumeDependencyType;
import aero.aixm.schema._5.AirspaceVolumeType;
import aero.aixm.schema._5.CodeAirspaceActivityType;
import aero.aixm.schema._5.CodeAirspaceClassificationType;
import aero.aixm.schema._5.CodeAirspaceDependencyType;
import aero.aixm.schema._5.CodeAirspaceDesignatorType;
import aero.aixm.schema._5.CodeAirspaceType;
import aero.aixm.schema._5.CodeMilitaryOperationsType;
import aero.aixm.schema._5.CodeStatusAirspaceType;
import aero.aixm.schema._5.CodeYesNoType;
import aero.aixm.schema._5.NotePropertyType;
import aero.aixm.schema._5.TextNameType;
import aero.aixm.schema._5.ValFLType;
import com.baesystems.environmentinfrastructure.basictypes.distance.Distance;
import com.baesystems.environmentinfrastructure.basictypes.distance.Height;

import com.baesystems.environmentinfrastructure.airspace.OperationsType;
import com.baesystems.environmentinfrastructure.application.Logger;
import com.baesystems.environmentinfrastructure.airspace.Airspace;
import com.baesystems.environmentinfrastructure.airspace.AirspaceActivation;
import com.baesystems.environmentinfrastructure.airspace.AirspaceClassification;
import com.baesystems.environmentinfrastructure.airspace.AirspaceTimeSlice;
import com.baesystems.environmentinfrastructure.airspace.AirspaceVolume;
import com.baesystems.environmentinfrastructure.airspace.AirspaceVolumeDependency;
import com.baesystems.environmentinfrastructure.basictypes.time.TimeData;
import com.baesystems.environmentinfrastructure.basictypes.time.Timesheet;
import com.baesystems.environmentinfrastructure.db.AirspaceDao;
import com.baesystems.environmentinfrastructure.loader.aixm.AIXMBulkParser;
import com.baesystems.environmentinfrastructure.loader.aixm.AIXMParseException;
import com.baesystems.environmentinfrastructure.loader.aixm.datasource.AIXMDataSource;
import com.baesystems.environmentinfrastructure.loader.aixm.parse.ParseGeneral;
import com.baesystems.environmentinfrastructure.loader.aixm.parse.ParseBoolean;
import com.baesystems.environmentinfrastructure.loader.aixm.parse.ParseDistance;
import com.baesystems.environmentinfrastructure.loader.aixm.parse.ParseGeo;
import com.baesystems.environmentinfrastructure.loader.aixm.parse.ParseHeight;
import com.baesystems.environmentinfrastructure.loader.aixm.parse.ParseTime;
import com.baesystems.environmentinfrastructure.loader.aixm.parse.XLink;
import com.baesystems.environmentinfrastructure.types.AirspaceCode;
import com.baesystems.environmentinfrastructure.types.StatusAirspaceCode;

public class AirspaceTypeParser extends AIXMBulkParser {

	private List<List<AbstractAIXMFeatureType>> failedAirspaces;
	private int repeats;
	private AirspaceDao database;

	public AirspaceTypeParser(AIXMDataSource ds) {
		super(AirspaceType.class, ds);
		while (repeats < 10) {
			failedAirspaces.add(new ArrayList<>());
			for (AbstractAIXMFeatureType feature : failedAirspaces.get(repeats)) {
				processFeature(feature);
			}
			repeats++;
		}
	}

	@Override
	protected void beforeStartProcessing() {
		database = new AirspaceDao();
		failedAirspaces = new ArrayList<>();
		failedAirspaces.add(new ArrayList<>());
		repeats = 0;
	}

	@Override
	protected void processFeature(AbstractAIXMFeatureType feature) {

		if (feature instanceof AirspaceType) {
			AirspaceType airspaceType = (AirspaceType) feature;

			Airspace airspace = new Airspace(ParseGeneral.getUuid(airspaceType));
			boolean linkToContributorFailed = false;

			for (AirspaceTimeSlicePropertyType timesliceProperty : airspaceType.getTimeSlice()) {
				AirspaceTimeSliceType timeslice = timesliceProperty.getAirspaceTimeSlice();

				TimeData timeData = new TimeData(timeslice.getCorrectionNumber(), timeslice.getFeatureLifetime(),
						timeslice.getInterpretation(), timeslice.getTimeSliceMetadata(), timeslice.getSequenceNumber(),
						timeslice.getValidTime());

				AirspaceActivation activation = null;
				List<String> annotation = new ArrayList<>();
				AirspaceClassification classification = null;
				OperationsType controlType = null;
				String designator = null;
				Boolean designatorICAO = null;
				List<AirspaceGeometryComponentPropertyType> geometryComponent = new ArrayList<>();
				String localType = null;
				String name = null;
				AirspaceCode type = null;
				Height upperLowerSeparation = null;

				for (JAXBElement<?> element : timeslice.getRest()) {
					Object value = element.getValue();
					String localName = element.getName().getLocalPart();

					if (localName.equals("activation")) {
						if (value != null) {
							activation = getActivation((AirspaceActivationPropertyType) value);
						}
					} else if (localName.equals("annotation")) {
						if (value != null) {
							annotation = ParseGeneral.getNote((NotePropertyType) value);
						}
					} else if (localName.equals("class")) {
						if (value != null) {
							Logger.log("AirspaceLayerClass not supported");
						}
					} else if (localName.equals("classification")) {
						if (value != null) {
							classification = getClassification((CodeAirspaceClassificationType) value);
						}
					} else if (localName.equals("controlType")) {
						if (value != null) {
							controlType = ParseGeneral.getOperationsType((CodeMilitaryOperationsType) value);
						}
					} else if (localName.equals("designator")) {
						if (value != null) {
							designator = ((CodeAirspaceDesignatorType) value).getValue();
						}
					} else if (localName.equals("designatorICAO")) {
						if (value != null) {
							designatorICAO = ParseBoolean.yesNoToBoolean((CodeYesNoType) value);
						}
					} else if (localName.equals("geometryComponent")) {
						if (value != null) {
							geometryComponent.add((AirspaceGeometryComponentPropertyType) value);
						}
					} else if (localName.equals("localType")) {
						if (value != null) {
							localType = ((TextNameType) value).getValue();
						}
					} else if (localName.equals("name")) {
						if (value != null) {
							name = ((TextNameType) value).getValue();
						}
					} else if (localName.equals("protectedRoute")) {
						if (value != null) {
							Logger.log("protectedRoute not supported");
						}
					} else if (localName.equals("type")) {
						if (value != null) {
							type = getType((CodeAirspaceType) value);
						}
					} else if (localName.equals("upperLowerSeparation")) {
						if (value != null) {
							upperLowerSeparation = ParseHeight.valFLTypeToAltitude((ValFLType) value);
						}
					} else {
						ds.registerUnusedData(this.getClass(), element.getDeclaredType().getName(), localName, value);
					}
				}

				AirspaceTimeSlice timeSlice = new AirspaceTimeSlice(timeData, activation, annotation, classification,
						// classLayer,
						controlType, designator, designatorICAO, localType, name,
						// protectedRoute,
						type, upperLowerSeparation);

				for (AirspaceGeometryComponentPropertyType value : geometryComponent) {
					try {
						AirspaceVolume airspaceVolume = getAirspaceVolume(timeSlice, value);
						if (airspaceVolume != null) {
							timeSlice.addGeometryComponent(airspaceVolume);
						}
					} catch (AIXMParseException e) {
						linkToContributorFailed = true;
						failedAirspaces.get(failedAirspaces.size() - 1).add(airspaceType);
					}
				}

				airspace.addTimeSlice(timeSlice);
			}
			if (!linkToContributorFailed) {
				database.addAirspace(airspace);
			}
		}
	}

	private AirspaceVolume getAirspaceVolume(AirspaceTimeSlice timeSlice,
			AirspaceGeometryComponentPropertyType airspaceGeometryComponentProperty)
			throws AIXMParseException {
		if (airspaceGeometryComponentProperty.getAirspaceGeometryComponent() != null) {
			AirspaceVolumeType airspaceVolume = airspaceGeometryComponentProperty.getAirspaceGeometryComponent()
					.getTheAirspaceVolume().getAirspaceVolume();

			List<String> annotation = ParseGeneral.getNote(airspaceVolume.getAnnotation());
			LineString centreline = ParseGeo.curveToPositionsAixm(airspaceVolume.getCentreline(), ds);
			AirspaceVolumeDependency contributorAirspace = getContributorAirspace(
					airspaceVolume.getContributorAirspace());
			Polygon horizontalProjection = ParseGeo.surfaceToPositions(airspaceVolume.getHorizontalProjection(), ds);
			Height lowerLimit = ParseHeight.valDistanceVerticalTypeToAltitude(airspaceVolume.getLowerLimit(),
					airspaceVolume.getLowerLimitReference());
			Height maximumLimit = ParseHeight.valDistanceVerticalTypeToAltitude(airspaceVolume.getMaximumLimit(),
					airspaceVolume.getMaximumLimitReference());
			Height minimumLimit = ParseHeight.valDistanceVerticalTypeToAltitude(airspaceVolume.getMinimumLimit(),
					airspaceVolume.getMinimumLimitReference());
			Height upperLimit = ParseHeight.valDistanceVerticalTypeToAltitude(airspaceVolume.getUpperLimit(),
					airspaceVolume.getUpperLimitReference());
			Distance width = ParseDistance.valDistanceTypeToDistance(airspaceVolume.getWidth());

			if (lowerLimit == null) {
				lowerLimit = Height.sfc;
			}

			if (upperLimit == null) {
				upperLimit = Height.max;
			}

			return new AirspaceVolume(timeSlice, annotation, centreline, contributorAirspace, horizontalProjection,
					lowerLimit, maximumLimit, minimumLimit, upperLimit, width);
		}
		return null;
	}

	private AirspaceVolumeDependency getContributorAirspace(
			JAXBElement<AirspaceVolumeDependencyPropertyType> contributorAirspace) throws AIXMParseException {
		if (contributorAirspace != null && contributorAirspace.getValue() != null) {
			AirspaceVolumeDependencyType airspaceVolumeDependency = contributorAirspace.getValue()
					.getAirspaceVolumeDependency();
			List<String> annotation = ParseGeneral.getNote(airspaceVolumeDependency.getAnnotation());
			String dependency = getDependency(airspaceVolumeDependency.getDependency());
			Airspace theAirspace = XLink.getAirspace(airspaceVolumeDependency.getTheAirspace());
			return new AirspaceVolumeDependency(annotation, dependency, theAirspace);
		}
		return null;
	}

	private String getDependency(JAXBElement<CodeAirspaceDependencyType> dependency) {
		if (dependency != null && dependency.getValue() != null) {
			return dependency.getValue().getValue();
		}
		return null;
	}

	private AirspaceActivation getActivation(AirspaceActivationPropertyType airspaceActivationProperty) {
		AirspaceActivationType airspaceActivation = airspaceActivationProperty.getAirspaceActivation();
		String activity = getActivity(airspaceActivation.getActivity());
		List<String> annotation = ParseGeneral.getNote(airspaceActivation.getAnnotation());
		StatusAirspaceCode status = getStatus(airspaceActivation.getStatus());
		List<Timesheet> timeInterval = ParseTime.getTimeInterval(airspaceActivation.getTimeInterval());
		return new AirspaceActivation(airspaceActivation, activity, annotation, status, timeInterval);
	}

	private String getActivity(JAXBElement<CodeAirspaceActivityType> activity) {
		if (activity != null && activity.getValue() != null) {
			return activity.getValue().getValue();
		}
		return null;
	}

	private AirspaceClassification getClassification(CodeAirspaceClassificationType value) {
		String classificationString = value.getValue();
		for (AirspaceClassification classificationEnum : AirspaceClassification.values()) {
			if (classificationEnum.toString().equals(classificationString)) {
				return classificationEnum;
			}
		}
		return AirspaceClassification.UNKNOWN;
	}

	private StatusAirspaceCode getStatus(JAXBElement<CodeStatusAirspaceType> status) {
		if (status != null && status.getValue() != null) {
			return new StatusAirspaceCode(status.getValue().getValue());
		}
		return null;
	}

	private AirspaceCode getType(CodeAirspaceType airspace) {
		if (airspace != null && airspace.getValue() != null) {
			return new AirspaceCode(airspace.getValue());
		}
		return null;
	}
}
