package com.baesystems.environmentinfrastructure.types;

public class AirspaceDependencyCode {
	// A code indicating the extent of dependency relation between an AirspaceVolume and another Airspace.
	public static final AirspaceDependencyCode FULL_GEOMETRY = new AirspaceDependencyCode("FULL_GEOMETRY"); // The overall geometry of the Airspace is used.
	public static final AirspaceDependencyCode HORZ_PROJECTION = new AirspaceDependencyCode("HORZ_PROJECTION"); // The horizontal projection of the Airspace is inherited.
	
	private String value;
	
	public AirspaceDependencyCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirspaceDependencyCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
