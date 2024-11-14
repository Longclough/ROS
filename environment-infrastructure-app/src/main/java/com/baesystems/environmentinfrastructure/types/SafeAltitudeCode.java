package com.baesystems.environmentinfrastructure.types;

public class SafeAltitudeCode {
	// A code indicating the type of altitude used, MSA or ESA.
	public static final SafeAltitudeCode MSA = new SafeAltitudeCode("MSA"); // Minimum Sector/Safe Altitude
	public static final SafeAltitudeCode ESA = new SafeAltitudeCode("ESA"); // Emergency Safe/Sector Altitude
	
	private String value;
	
	public SafeAltitudeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SafeAltitudeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
