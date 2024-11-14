package com.baesystems.environmentinfrastructure.loader.aixm.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.geom.GeometryFactory;

import net.opengis.gml._3.AbstractCurveSegmentType;
import net.opengis.gml._3.AbstractCurveType;
import net.opengis.gml._3.AbstractRingPropertyType;
import net.opengis.gml._3.AbstractSurfacePatchType;
import net.opengis.gml._3.ArcByCenterPointType;
import net.opengis.gml._3.CircleByCenterPointType;
import net.opengis.gml._3.CurvePropertyType;
import net.opengis.gml._3.CurveSegmentArrayPropertyType;
import net.opengis.gml._3.CurveType;
import net.opengis.gml._3.DirectPositionListType;
import net.opengis.gml._3.DirectPositionType;
import net.opengis.gml._3.GeodesicStringType;
import net.opengis.gml._3.LineStringSegmentType;
import net.opengis.gml._3.LinearRingType;
import net.opengis.gml._3.PolygonPatchType;
import net.opengis.gml._3.RingType;
import net.opengis.gml._3.SurfacePatchArrayPropertyType;
import aero.aixm.schema._5.AbstractAIXMFeatureType;
import aero.aixm.schema._5.CircleSectorPropertyType;
import aero.aixm.schema._5.CircleSectorType;
import aero.aixm.schema._5.CodeArcDirectionType;
import aero.aixm.schema._5.CodeGeoBorderType;
import aero.aixm.schema._5.CodeSideType;
import aero.aixm.schema._5.ElevatedCurvePropertyType;
import aero.aixm.schema._5.ElevatedCurveType;
import aero.aixm.schema._5.ElevatedPointPropertyType;
import aero.aixm.schema._5.ElevatedPointType;
import aero.aixm.schema._5.ElevatedSurfacePropertyType;
import aero.aixm.schema._5.ElevatedSurfaceType;
import aero.aixm.schema._5.GeoBorderTimeSlicePropertyType;
import aero.aixm.schema._5.GeoBorderTimeSliceType;
import aero.aixm.schema._5.GeoBorderType;
import aero.aixm.schema._5.PointPropertyType;
import aero.aixm.schema._5.SurfacePropertyType;
import aero.aixm.schema._5.SurfaceType;
import aero.aixm.schema._5.TextNameType;
import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;
import com.baesystems.environmentinfrastructure.basictypes.angle.AngleUnit;
import com.baesystems.environmentinfrastructure.basictypes.angle.ArcDirection;
import com.baesystems.environmentinfrastructure.basictypes.angle.BearingType;
import com.baesystems.environmentinfrastructure.basictypes.distance.AltitudeReference;
import com.baesystems.environmentinfrastructure.basictypes.distance.Distance;
import com.baesystems.environmentinfrastructure.basictypes.distance.DistanceUnit;
import com.baesystems.environmentinfrastructure.basictypes.distance.Height;
import com.baesystems.environmentinfrastructure.basictypes.position.GeoPoint2D;
import com.baesystems.environmentinfrastructure.basictypes.position.GeoPoint3D;
import com.baesystems.environmentinfrastructure.geospatial.Ellipsoid;
import com.baesystems.environmentinfrastructure.geospatial.GeodeticCalculator;

import com.baesystems.environmentinfrastructure.application.Logger;
import com.baesystems.environmentinfrastructure.geospatial.Sector;
import com.baesystems.environmentinfrastructure.loader.aixm.datasource.AIXMDataSource;
import com.baesystems.environmentinfrastructure.types.SideCode;

public class ParseGeo {
	
	private static final Angle arcIncrement = Angle.fromDegrees(5); 
	private static final GeodeticCalculator gc = new GeodeticCalculator();
	private static final GeometryFactory gf = new GeometryFactory(new PrecisionModel(), 4326);
	
	private static LineString curveSegmentArrayToPositions(CurveSegmentArrayPropertyType curveSegmentArrayProperty, String srsName) {
		
		List<Coordinate> positions = new ArrayList<>();
		
		for(JAXBElement<? extends AbstractCurveSegmentType> curveSegment : curveSegmentArrayProperty.getAbstractCurveSegment()) {
			if(curveSegment.getValue() instanceof GeodesicStringType) {
				DirectPositionListType posList = ((GeodesicStringType)curveSegment.getValue()).getPosList();
				List<Object> geometricPositionGroup = ((GeodesicStringType)curveSegment.getValue()).getGeometricPositionGroup();
				if(posList != null) {
					List<Coordinate> positionList = posListToPositions(posList, srsName);
//					Logger.log("PosList: " + positionList);
					positions.addAll(positionList);
				} else if(geometricPositionGroup != null) {
//					Logger.log("GeometricPositionGroup:");
					for(Object object : geometricPositionGroup) {
						if(object instanceof DirectPositionType) {
							Coordinate position = directPositionTypeToPosition((DirectPositionType) object, srsName);
//							Logger.log(position);
							positions.add(position);
						}
						else if(object instanceof net.opengis.gml._3.PointPropertyType) {
							Coordinate position = pointToPosition(((net.opengis.gml._3.PointPropertyType) object).getPoint().getValue());
//							Logger.log(position);
							positions.add(position);
						}
					}
				}
			} else if (curveSegment.getValue() instanceof CircleByCenterPointType) {
				CircleByCenterPointType circleByCenterPoint = (CircleByCenterPointType) curveSegment.getValue();
				Coordinate arcCentre = getArcCentre(circleByCenterPoint, srsName);
				Distance radius = ParseDistance.lengthTypeToDistance(circleByCenterPoint.getRadius());
				positions.addAll(makeArc(arcCentre, radius, Angle.Angle0, Angle.fromDegrees(360), TurnDirection.RIGHT));
			} else if (curveSegment.getValue() instanceof ArcByCenterPointType) {
				String out = "Arc:" + srsName;
				
				ArcByCenterPointType arcByCenterPoint = (ArcByCenterPointType) curveSegment.getValue();
				
				Angle startAngle = ParseAngle.angleTypeToAngle(arcByCenterPoint.getStartAngle());
				Angle endAngle = ParseAngle.angleTypeToAngle(arcByCenterPoint.getEndAngle());
		
				if(srsName.contains("CRS84")) {
					startAngle = convertAngleFromCRS84(startAngle);
					endAngle = convertAngleFromCRS84(endAngle);
				}
				
				out = out + " start " + startAngle;
				out = out + " end " + endAngle;
				
				TurnDirection turnDirection;
				Angle deltaAngle;
				
				if(startAngle.inDegrees() < endAngle.inDegrees()) {
					turnDirection = TurnDirection.RIGHT;
					deltaAngle = endAngle.subtract(startAngle).make0To360();
				} else {
					turnDirection = TurnDirection.LEFT;
					deltaAngle = startAngle.subtract(endAngle).make0To360();
				}
				out = out + " direction " + turnDirection + " delta " + deltaAngle;
				
				Coordinate arcCentre = getArcCentre(arcByCenterPoint, srsName);
				out = out + " centre " + arcCentre;
				
				Distance radius = ParseDistance.lengthTypeToDistance(arcByCenterPoint.getRadius());
				out = out + " radius " + radius;
				
				positions.addAll(makeArc(arcCentre, radius, startAngle, deltaAngle, turnDirection));
				
//				Logger.log(out);
			} else if(curveSegment.getValue() instanceof LineStringSegmentType) {
				LineStringSegmentType lineStringSegment = (LineStringSegmentType) curveSegment.getValue();
				if(lineStringSegment.getPosList() != null) {
				positions.addAll(posListToPositions(lineStringSegment.getPosList(), srsName));
				} else if (lineStringSegment.getPosOrPointPropertyOrPointRep() != null) {
					for(JAXBElement<?> p : lineStringSegment.getPosOrPointPropertyOrPointRep()) {
						if(p.getValue() instanceof DirectPositionType) {
						positions.add(directPositionTypeToPosition((DirectPositionType) p.getValue(), srsName));
						} else if(p.getValue() instanceof PointPropertyType) { 
							System.out.println("hi");
							//positions.add(pointToPosition(((PointPropertyType) p.getValue()).getPoint(), srsName));
						}
					}
				}
			}
		}
		Coordinate[] positionsArray = new Coordinate[positions.size()];
		return gf.createLineString(positions.toArray(positionsArray));
	}
	
	private static Angle convertAngleFromCRS84(Angle angle) {
		return Angle.fromDegrees(-1 * (angle.inDegrees() - 90)).make0To360();
	}

	public static LineString curveToPositions(CurvePropertyType curveProperty, String srsName, AIXMDataSource ds) {
		
		if(curveProperty.getAbstractCurve() != null) {
			AbstractCurveType curve = curveProperty.getAbstractCurve().getValue();
			if(curve instanceof CurveType) {
				if(srsName == null) {
					srsName = curve.getSrsName();
				}
				LineString positions = curveSegmentArrayToPositions(((CurveType)curve).getSegments(), srsName); 
				return positions;
			} else {
				Logger.log("Curve not recognised");
				return null;
			}
		} else if (curveProperty.getHref() != null) {
			LineString positions = getReferencedCurve(curveProperty.getHref(), ds);
			return positions;
		} else {
			Logger.log("Curve not recognised");
			return null;
		}
	}
	
	public static LineString curveToPositionsAixm(JAXBElement<aero.aixm.schema._5.CurvePropertyType> curveProperty, AIXMDataSource ds) {
		if(curveProperty != null && curveProperty.getValue() != null) {
			return curveToPositionsAixm(curveProperty.getValue(), ds);
		}
		return null;
	}

	public static LineString curveToPositionsAixm(aero.aixm.schema._5.CurvePropertyType curveProperty, AIXMDataSource ds) {
		
		List<Coordinate> positions = new ArrayList<>();
		
		if(curveProperty.getCurve() != null) {
			aero.aixm.schema._5.CurveType curve = curveProperty.getCurve().getValue();
			positions.addAll(Arrays.asList(curveSegmentArrayToPositions(curve.getSegments(), curve.getSrsName()).getCoordinates()));
		}

		Coordinate[] positionsArray = new Coordinate[positions.size()];
		return gf.createLineString(positions.toArray(positionsArray));
	}

	private static Coordinate directPositionListTypeToPosition(DirectPositionListType directPositionList, String srsName) {
		if(srsName == null) {
			srsName = directPositionList.getSrsName();
		}
		boolean latThenLon = getLatThenLon(srsName);
		if(latThenLon) {
			return new GeoPoint3D(directPositionList.getValue().get(0), directPositionList.getValue().get(1), 0, AngleUnit.DEGREES, DistanceUnit.METRES).toCoordinate();
		} else {
			return new GeoPoint3D(directPositionList.getValue().get(1), directPositionList.getValue().get(0), 0, AngleUnit.DEGREES, DistanceUnit.METRES).toCoordinate();
		}
	}
	
	private static Coordinate directPositionTypeToPosition(DirectPositionType directPosition, String srsName) {
		if(srsName == null) {
			srsName = directPosition.getSrsName();
		}
		boolean latThenLon = getLatThenLon(srsName);
		if(latThenLon) {
			return new GeoPoint3D(directPosition.getValue().get(0), directPosition.getValue().get(1), 0, AngleUnit.DEGREES, DistanceUnit.METRES).toCoordinate();
		} else {
			return new GeoPoint3D(directPosition.getValue().get(1), directPosition.getValue().get(0), 0, AngleUnit.DEGREES, DistanceUnit.METRES).toCoordinate();
		}
	}
	
	public static LineString elevatedCurveToPoints(ElevatedCurvePropertyType elevatedCurveProperty, AIXMDataSource ds) {	
		if(elevatedCurveProperty != null && elevatedCurveProperty.getElevatedCurve() != null) {
			List<Coordinate> elevatedPoints = new ArrayList<>();
			ElevatedCurveType curve = elevatedCurveProperty.getElevatedCurve();
			Height elevation = ParseHeight.valDistanceVerticalTypeToAltitude(curve.getElevation(), AltitudeReference.MSL);
			if(elevation == null) {
				elevation = Height.zero;
			}
			LineString horizontalGeom = curveSegmentArrayToPositions(curve.getSegments(), curve.getSrsName());
			for(Coordinate point : horizontalGeom.getCoordinates()) {
				elevatedPoints.add(new Coordinate(point.x, point.y, elevation.inMetres()));
			}
			Coordinate[] elevatedPointsArray = new Coordinate[elevatedPoints.size()];
			return gf.createLineString(elevatedPoints.toArray(elevatedPointsArray));
		}
		return null;
	}
	
	public static LineString elevatedCurveToPoints(JAXBElement<ElevatedCurvePropertyType> elevatedCurveProperty, AIXMDataSource ds) {	
		if(elevatedCurveProperty != null && elevatedCurveProperty.getValue() != null) {
			return elevatedCurveToPoints(elevatedCurveProperty.getValue(), ds);
		}
		return null;
	}
	
	public static GeoPoint3D elevatedPointToPosition(ElevatedPointPropertyType elevatedPointProperty) {
		if(elevatedPointProperty != null) {
			return elevatedPointToPosition(elevatedPointProperty.getElevatedPoint());
		} else {
			return null;
		}
	}

	private static GeoPoint3D elevatedPointToPosition(ElevatedPointType elevatedPoint) {
		boolean latThenLon = getLatThenLon(elevatedPoint.getSrsName());
		Angle angle1 = Angle.fromDegrees(elevatedPoint.getPos().getValue().get(0));
		Angle angle2 = Angle.fromDegrees(elevatedPoint.getPos().getValue().get(1));
		double ele = 0;
		if(elevatedPoint.getSrsDimension() != null && elevatedPoint.getSrsDimension().intValue() == 3) {
			ele = elevatedPoint.getPos().getValue().get(2);
		} else if (elevatedPoint.getElevation() != null) {
			ele = ParseHeight.valDistanceVerticalTypeToAltitude(elevatedPoint.getElevation(), AltitudeReference.MSL).getMAMSL();
		}
		if(latThenLon) {
			return new GeoPoint3D(angle1, angle2, ele, DistanceUnit.METRES);
		} else {
			return new GeoPoint3D(angle2, angle1, ele, DistanceUnit.METRES);
		}
	}

	public static GeoPoint3D elevatedPointToPosition(JAXBElement<ElevatedPointPropertyType> elevatedPointPropertyElement) {
		if(elevatedPointPropertyElement != null) {
			return elevatedPointToPosition(elevatedPointPropertyElement.getValue());
		} else {
			return null;
		}
	}
	
	public static Polygon elevatedSurfaceToPoints(ElevatedSurfacePropertyType elevatedSurfaceProperty, AIXMDataSource ds) {
		if(elevatedSurfaceProperty != null) {
			List<Coordinate> elevatedPoints = new ArrayList<>();
			ElevatedSurfaceType surface = elevatedSurfaceProperty.getElevatedSurface();
			Height elevation = ParseHeight.valDistanceVerticalTypeToAltitude(surface.getElevation(), AltitudeReference.MSL);
			if(elevation == null) {
				elevation = Height.zero;
			}
			Polygon horizontalGeom = surfaceTypeToPositions(elevatedSurfaceProperty.getElevatedSurface(), surface.getSrsName(), ds);
			for(Coordinate point : horizontalGeom.getCoordinates()) {
				elevatedPoints.add(new Coordinate(point.x, point.y, elevation.inMetres()));
			}
			Coordinate[] elevatedPointsArray = new Coordinate[elevatedPoints.size()];
			return gf.createPolygon(elevatedPoints.toArray(elevatedPointsArray));
		}
		return null;
	}

	public static Polygon elevatedSurfaceToPoints(JAXBElement<ElevatedSurfacePropertyType> elevatedSurfaceProperty, AIXMDataSource ds) {
		if (elevatedSurfaceProperty != null && elevatedSurfaceProperty.getValue() != null) {
			return elevatedSurfaceToPoints(elevatedSurfaceProperty.getValue(), ds);
		}
		return null;
	}

	private static Coordinate getArcCentre(ArcByCenterPointType arcByCenterPoint, String srsName) {
		if(arcByCenterPoint.getPosList() != null) {
			return directPositionListTypeToPosition(arcByCenterPoint.getPosList(), srsName);
		} else if(arcByCenterPoint.getPos() != null) {
			return directPositionTypeToPosition(arcByCenterPoint.getPos(), srsName);
		} else if(arcByCenterPoint.getPointProperty() != null) {		
			return pointToPosition(arcByCenterPoint.getPointProperty().getPoint().getValue());		
		} else {
			return null;
		}
	}

	public static ArcDirection getArcDirection(JAXBElement<CodeArcDirectionType> value) {
		if(value != null && value.getValue() != null) {
			if(value.getValue().getValue().equals("CCA")) {
				return ArcDirection.ANTICLOCKWISE;
			} else {
				return ArcDirection.CLOCKWISE;
			}
		}
		return null;
	}
	
	private static boolean getLatThenLon(String srsName) {
		if(srsName == null) {
			// Logger.log("No SRS, guessing 4326");
			return true;
		} else if(srsName.contains("4326")) {
			return true;
		} else if(srsName.contains("4269")) {
			return true;
		} else if(srsName.contains("CRS84")) {
			return false;
		} else {
			return false;
		}
	}

	private static LineString getReferencedCurve(String href, AIXMDataSource ds) {
		List<Coordinate> positions = new ArrayList<>();
		AbstractAIXMFeatureType feature = ds.getFeature(href);
		if(feature != null && feature instanceof GeoBorderType) {
			GeoBorderType geoBorder = (GeoBorderType) feature;
			for(GeoBorderTimeSlicePropertyType timesliceProperty : geoBorder.getTimeSlice())
			{
				GeoBorderTimeSliceType timeslice = timesliceProperty.getGeoBorderTimeSlice();
				for(JAXBElement<?> element : timeslice.getRest()) {
					Object value = element.getValue();
					if(value instanceof TextNameType) {
						
					} else if (value instanceof CodeGeoBorderType) {
						
					} else if (value instanceof aero.aixm.schema._5.CurvePropertyType) {
						positions.addAll(Arrays.asList(curveToPositionsAixm((aero.aixm.schema._5.CurvePropertyType) value, ds).getCoordinates()));
					}
				}
			}
		}
		if(positions.size() == 0)
		{
			Logger.log("Referenced curve has no positions: " + href);
		}
		Coordinate[] positionsArray = new Coordinate[positions.size()];
		return gf.createLineString(positions.toArray(positionsArray));
	}

	public static Coordinate pointToPosition(net.opengis.gml._3.PointType point) {
		boolean latThenLon = getLatThenLon(point.getSrsName());
		Angle angle1 = Angle.fromDegrees(point.getPos().getValue().get(0));
		Angle angle2 = Angle.fromDegrees(point.getPos().getValue().get(1));
		double ele = 0;
		if(point.getSrsDimension() != null) {
			if(point.getSrsDimension().intValue() == 3) {
				ele = point.getPos().getValue().get(2);
			}
		}
		if(latThenLon) {
			return new GeoPoint3D(angle1, angle2, ele, DistanceUnit.METRES).toCoordinate();
		} else {
			return new GeoPoint3D(angle2, angle1, ele, DistanceUnit.METRES).toCoordinate();
		}
	}
	
	private static List<Coordinate> posListToPositions(DirectPositionListType posList, String srsName) {
		
		if(srsName == null) {
			srsName = posList.getSrsName();
		}
		boolean latThenLon  = getLatThenLon(srsName);
		List<Coordinate> positions = new ArrayList<>();
		for(int i = 0; i < posList.getValue().size() - 1; i=i+2) {
			GeoPoint2D position;
			if(latThenLon) {
				position = new GeoPoint3D(posList.getValue().get(i), posList.getValue().get(i+1), 0, AngleUnit.DEGREES, DistanceUnit.METRES);
			} else {
				position = new GeoPoint3D(posList.getValue().get(i+1), posList.getValue().get(i), 0, AngleUnit.DEGREES, DistanceUnit.METRES);
			}
			
			positions.add(position.toCoordinate());
		}
		return positions;
	}

	public static Polygon surfaceToPositions(JAXBElement<SurfacePropertyType> surface, AIXMDataSource ds) {
		if(surface != null && surface.getValue() != null) {
			return surfaceToPositions(surface.getValue(), ds);
		}
		return null;
	}
	
	public static Polygon surfaceToPositions(SurfacePropertyType surface, AIXMDataSource ds) {
		if(surface != null) {
			return surfaceTypeToPositions(surface.getSurface().getValue(), surface.getSurface().getValue().getSrsName(), ds);
		}
		return null;
	}
	
	public static Polygon surfaceTypeToPositions(SurfaceType surfaceType, String srsName, AIXMDataSource ds) {
		List<Coordinate> positions = new ArrayList<>();
		SurfacePatchArrayPropertyType patches = surfaceType.getPatches().getValue();
		for(JAXBElement<? extends AbstractSurfacePatchType> patch : patches.getAbstractSurfacePatch()) {
			if(patch.getValue() instanceof PolygonPatchType) {
				PolygonPatchType polygon = (PolygonPatchType)patch.getValue();
				AbstractRingPropertyType abstractRing = polygon.getExterior();
				if(abstractRing.getAbstractRing().getValue() instanceof RingType) {
					RingType ring = (RingType)abstractRing.getAbstractRing().getValue();
					for(CurvePropertyType curveProperty : ring.getCurveMember()) {
						positions.addAll(Arrays.asList(curveToPositions(curveProperty, srsName, ds).getCoordinates()));
					}
				} else if(abstractRing.getAbstractRing().getValue() instanceof LinearRingType) {
					LinearRingType linearRing = (LinearRingType)abstractRing.getAbstractRing().getValue();
					positions.addAll(posListToPositions(linearRing.getPosList(), srsName));
				}			
			}
		}
		positions.add(positions.get(0));
		Coordinate[] positionsArray = new Coordinate[positions.size()];
		return gf.createPolygon(positions.toArray(positionsArray));
	}
	
	public static List<Coordinate> makeArc(Coordinate centre, Distance radius, Angle startAngle, Angle deltaAngle, TurnDirection turnDirection) {
		List<Coordinate> positions = new ArrayList<>();
		for(int i = 0; i < (int) deltaAngle.inDegrees(); i = i + (int) arcIncrement.inDegrees()) {
			positions.add(getArcPoint(centre, startAngle, Angle.fromDegrees(i), radius, turnDirection));
		}
		positions.add(getArcPoint(centre, startAngle, deltaAngle, radius, turnDirection));
		return positions;
	}
	
	private static Coordinate getArcPoint(Coordinate centre, Angle startAngle, Angle deltaAngle, Distance radius, TurnDirection turnDirection) {
		if(turnDirection == TurnDirection.RIGHT) {
			return gc.CalculateEndingCoordinates(Ellipsoid.WGS84, new GeoPoint3D(centre), startAngle.add(deltaAngle), radius).toCoordinate();
		} else {
			return gc.CalculateEndingCoordinates(Ellipsoid.WGS84, new GeoPoint3D(centre), startAngle.subtract(deltaAngle), radius).toCoordinate();
		}
	}

	public static List<GeoPoint3D> elevatedPointsToPositions(List<ElevatedPointPropertyType> elevatedPointProperties) {
		List<GeoPoint3D> positions = new ArrayList<GeoPoint3D>();
		for(ElevatedPointPropertyType elevatedPointProperty : elevatedPointProperties) {
			positions.add(elevatedPointToPosition(elevatedPointProperty));
		}
		return positions;
	}

	public static List<Polygon> surfaceToPositions(List<SurfacePropertyType> surfaceProperties, AIXMDataSource ds) {
		List<Polygon> surfaces = new ArrayList<>();
		for(SurfacePropertyType surfaceProperty : surfaceProperties) {
			surfaces.add(surfaceToPositions(surfaceProperty, ds));
		}
		return surfaces;
	}
	
	public static List<Sector> getSector(List<CircleSectorPropertyType> circleSectorProperties, GeoPoint2D centre) {
		List<Sector> sectorList = new ArrayList<Sector>();
		if(centre != null) {
			for(CircleSectorPropertyType circleSectorProperty : circleSectorProperties) {
				sectorList.add(getSector(circleSectorProperty, centre));
			}
		}
		return sectorList;
	}

	public static Sector getSector(JAXBElement<CircleSectorPropertyType> circleSector, GeoPoint2D centre) {
		if(circleSector != null && circleSector.getValue() != null) {
			return getSector(circleSector.getValue(), centre);
		} 
		return null;
	}
	
	public static Sector getSector(CircleSectorPropertyType circleSector, GeoPoint2D centre) {
		if(circleSector != null) {
			return getSector(circleSector.getCircleSector(), centre);
		} 
		return null;
	}
	
	private static Sector getSector(CircleSectorType circleSector, GeoPoint2D centre) {
		ArcDirection arcDirection = getArcDirection(circleSector.getArcDirection());
		BearingType angleType = ParseAngle.codeBearingTypeToBearingType(circleSector.getAngleType());
		Angle fromAngle = ParseAngle.valBearingTypeToAngle(circleSector.getFromAngle());
		Angle toAngle = ParseAngle.valBearingTypeToAngle(circleSector.getToAngle());
		Distance innerDistance = ParseDistance.valDistanceTypeToDistance(circleSector.getInnerDistance());
		Distance outerDistance = ParseDistance.valDistanceTypeToDistance(circleSector.getOuterDistance());
		return new Sector(arcDirection, angleType, fromAngle, toAngle, innerDistance, outerDistance, centre);
	}
	
	public static SideCode getSide(JAXBElement<CodeSideType> side) {
		if(side != null && side.getValue() != null) {
			return new SideCode(side.getValue().getValue());
		}
		return null;
	}
}
