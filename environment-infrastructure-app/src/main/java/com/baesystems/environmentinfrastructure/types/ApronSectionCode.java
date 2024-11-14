package com.baesystems.environmentinfrastructure.types;

public class ApronSectionCode {
	// A code indicating a location on the surface of an apron. For example: apron edge.
	public static final ApronSectionCode EDGE = new ApronSectionCode("EDGE"); // Apron edge.
	
	private String value;
	
	public ApronSectionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ApronSectionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
