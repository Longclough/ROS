package com.baesystems.environmentinfrastructure.airspace;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baesystems.environmentinfrastructure.basictypes.time.TimeData;
import com.baesystems.environmentinfrastructure.basictypes.time.TimeSlice;
import com.baesystems.environmentinfrastructure.types.AirspaceCode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import com.baesystems.environmentinfrastructure.basictypes.distance.Height;

@Entity
@Table
public class AirspaceTimeSlice extends TimeSlice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@Transient
	private AirspaceActivation activation;

	@ElementCollection
	@Column(length = 1000)
	private List<String> annotation;

	private AirspaceClassification classification;
	
	private OperationsType controlType;

	private String designator;

	private Boolean designatorICAO;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "airspaceTimeSlice")
	private List<AirspaceVolume> geometryComponent = new ArrayList<>();

	private String localType;

	private String type;

	private Double upperLowerSeparation;
	
	public AirspaceTimeSlice() {
		
	}

	public AirspaceActivation getActivation() {
		return activation;
	}

	public List<String> getAnnotation() {
		return annotation;
	}

	public AirspaceClassification getClassification() {
		return classification;
	}

	public OperationsType getControlType() {
		return controlType;
	}

	public String getDesignator() {
		return designator;
	}

	public Boolean getDesignatorICAO() {
		return designatorICAO;
	}

	public List<AirspaceVolume> getGeometryComponent() {
		return geometryComponent;
	}

	public String getLocalType() {
		return localType;
	}

	public AirspaceCode getType() {
		return new AirspaceCode(type);
	}

	public Height getUpperLowerSeparation() {
		return Height.fromMMSL(upperLowerSeparation);
	}

	public AirspaceTimeSlice(TimeData timeData, AirspaceActivation activation, List<String> annotation,
			AirspaceClassification classification, OperationsType controlType, String designator,
			Boolean designatorICAO, String localType, String name,
			AirspaceCode type, Height upperLowerSeparation) {
		super(timeData, name);
		this.activation = activation;
		this.annotation = annotation;
		this.classification = classification;
		this.controlType = controlType;
		this.designator = designator;
		this.designatorICAO = designatorICAO;
		this.localType = localType;
		this.type = type.toString();
		this.upperLowerSeparation = upperLowerSeparation != null ? upperLowerSeparation.getMAMSL() : null;		
	}
	
	public void addGeometryComponent(AirspaceVolume geometryComponent) {
		this.geometryComponent.add(geometryComponent);
	}

	public boolean isProtected() {
		return type.equals(AirspaceCode.PROTECT.toString());
	}

	public boolean isRestricted() {
		return type.equals(AirspaceCode.TRA.toString()) || type.equals(AirspaceCode.R.toString()) || type.equals(AirspaceCode.D.toString());
	}

	public AirspaceTimeSlice copy() {
		AirspaceTimeSlice copy = new AirspaceTimeSlice(timeData, activation, annotation, classification, controlType, designator,
				designatorICAO, localType, name, getType(), getUpperLowerSeparation());
		for(AirspaceVolume airspaceVolume : this.getGeometryComponent()) {
			copy.addGeometryComponent(airspaceVolume);
		}
		return copy;
	}

	public void mergeIn(AirspaceTimeSlice other) {
		if (other.getActivation() != null) {
			activation = other.getActivation();
		}
		if (other.getAnnotation() != null) {
			annotation = other.getAnnotation();
		}
		if (other.getClassification() != null) {
			classification = other.getClassification();
		}
		if (other.getControlType() != null) {
			controlType = other.getControlType();
		}
		if (other.getDesignator() != null) {
			designator = other.getDesignator();
		}
		if (other.getDesignatorICAO() != null) {
			designatorICAO = other.getDesignatorICAO();
		}
		if (other.getGeometryComponent() != null) {
			geometryComponent = other.getGeometryComponent();
		}
		if (other.getLocalType() != null) {
			localType = other.getLocalType();
		}
		if (other.getName() != null) {
			name = other.getName();
		}
		if (other.getType() != null) {
			type = other.getType().toString();
		}
		if (other.getUpperLowerSeparation() != null) {
			upperLowerSeparation = other.getUpperLowerSeparation().getMAMSL();
		}
	}

	public JSONObject toJSON(boolean includeGeometryComponent) {
		JSONObject result = new JSONObject();
		result.put("designator", designator);
		result.put("designatorICAO", designatorICAO);
		if (includeGeometryComponent) {
			JSONArray jsonGeometryComponent = new JSONArray();
			for (AirspaceVolume av : geometryComponent) {
				jsonGeometryComponent.put(av.toJSON());
			}
			result.put("geometryComponent", jsonGeometryComponent);
		}
		result.put("localType", localType);
		result.put("name", name);
		result.put("annotation", annotation);
		result.put("classification", classification);
		result.put("controlType", controlType);
		result.put("type", type);
		result.put("upperLowerSeparation", upperLowerSeparation);
		return result;
	}
}
