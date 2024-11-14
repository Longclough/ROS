package com.baesystems.environmentinfrastructure.types;

public class GradeSeparationCode {
	// A list of coded values that indicate the placement of an element at a different height from another element.
	public static final GradeSeparationCode UNDERPASS = new GradeSeparationCode("UNDERPASS"); // The current element is in a tunnel below another element.
	public static final GradeSeparationCode OVERPASS = new GradeSeparationCode("OVERPASS"); // The current element is on a bridge above another element.
	
	private String value;
	
	public GradeSeparationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof GradeSeparationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
