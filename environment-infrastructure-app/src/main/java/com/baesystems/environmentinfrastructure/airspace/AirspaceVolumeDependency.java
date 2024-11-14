package com.baesystems.environmentinfrastructure.airspace;

import java.util.List;

public class AirspaceVolumeDependency {

	private List<String> annotation;
	private String dependency;
	private Airspace theAirspace;

	public List<String> getAnnotation() {
		return annotation;
	}

	public String getDependency() {
		return dependency;
	}

	public Airspace getTheAirspace() {
		return theAirspace;
	}

	public AirspaceVolumeDependency(
			List<String> annotation, 
			String dependency,
			Airspace theAirspace) {
		this.annotation = annotation;
		this.dependency = dependency;
		this.theAirspace = theAirspace;
	}

}
