package com.baesystems.environmentinfrastructure.airspace;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

import com.baesystems.environmentinfrastructure.basictypes.distance.Distance;
import com.baesystems.environmentinfrastructure.basictypes.distance.Height;

import com.baesystems.environmentinfrastructure.geospatial.Corridor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class AirspaceVolume  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
		
	@ManyToOne
	private AirspaceTimeSlice airspaceTimeSlice;
	
	private List<String> annotation;
	
	@Column(length = 10000)
	private LineString centreline;
	
	@Transient
	private AirspaceVolumeDependency contributorAirspace;
	
	@Column(length = 10000)
	private Polygon horizontalProjection;
	
	private Double lowerLimit;
	
	private Double maximumLimit; 
	
	private Double minimumLimit; 
	
	private Double upperLimit;
	
	private Double width;
	
	public AirspaceVolume() {
		
	}
	
	public List<String> getAnnotation() {
		return annotation;
	}
	
	public LineString getCentreline() {
		return centreline;
	}
	
	public AirspaceVolumeDependency getContributorAirspace() {
		return contributorAirspace;
	}
	
	public Polygon getHorizontalProjection() {
		return horizontalProjection;
	}
	
	public Height getLowerLimit() {
		return Height.fromMMSL(lowerLimit);
	}
	
	public Height getMaximumLimit() {
		return Height.fromMMSL(maximumLimit);
	}
	
	public Height getMinimumLimit() {
		return Height.fromMMSL(minimumLimit);
	}
	
	public Height getUpperLimit() {
		return Height.fromMMSL(upperLimit);
	}
	
	public Distance getWidth() {
		return Distance.fromMetres(width);
	}	

	public AirspaceVolume(AirspaceTimeSlice airspaceTimeSlice, List<String> annotation, LineString centreline,
			AirspaceVolumeDependency contributorAirspace,
			Polygon horizontalProjection, Height lowerLimit,
			Height maximumLimit, Height minimumLimit, Height upperLimit,
			Distance width) {
		super();
		this.airspaceTimeSlice = airspaceTimeSlice;
		this.annotation = annotation;
		this.centreline = centreline;
		this.contributorAirspace = contributorAirspace;
		this.horizontalProjection = horizontalProjection;
		this.lowerLimit = lowerLimit != null ? lowerLimit.inMetres() : null;
		this.maximumLimit = maximumLimit != null ? maximumLimit.inMetres() : null;
		this.minimumLimit = minimumLimit != null ? minimumLimit.inMetres() : null;
		this.upperLimit = upperLimit != null ? upperLimit.inMetres() : null;
		this.width = width != null ? width.inMetres() : null;
		
		if(centreline != null && width != null) {
			horizontalProjection = Corridor.makeCorridor(centreline, width);	
		}
	}

	public JSONObject toJSON() {
		JSONObject result = new JSONObject();
		result.put("type", "Feature");
		
		JSONObject properties = new JSONObject();
		properties.put("annotation", annotation);
		properties.put("upperLimit", upperLimit);
		properties.put("lowerLimit", lowerLimit);
		properties.put("airspaceTimeSlice", airspaceTimeSlice.toJSON(false));
		result.put("properties", properties);
		
		JSONObject geometry = new JSONObject();
		geometry.put("type", horizontalProjection.getClass().getSimpleName());  
		JSONArray coordinates = new JSONArray();		
		JSONArray ring = new JSONArray();
		for(Coordinate horizontalProjectionCoordinate : horizontalProjection.getCoordinates()) {
			JSONArray coordinate = new JSONArray();
			coordinate.put(horizontalProjectionCoordinate.x);
			coordinate.put(horizontalProjectionCoordinate.y);
			coordinates.put(coordinate);
		}
		ring.put(coordinates);
		geometry.put("coordinates", ring);
		result.put("geometry", geometry);

		return result;
	}
}
