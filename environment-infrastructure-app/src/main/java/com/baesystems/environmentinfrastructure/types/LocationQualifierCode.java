package com.baesystems.environmentinfrastructure.types;

public class LocationQualifierCode {
	// A code qualifying a location (such as an airspace, aerodrome, point, etc.) in relation with a flight or with its availability.
	public static final LocationQualifierCode DEP = new LocationQualifierCode("DEP"); // Departing from location.
	public static final LocationQualifierCode XNG = new LocationQualifierCode("XNG"); // Crossing location.
	public static final LocationQualifierCode ARR = new LocationQualifierCode("ARR"); // Arriving at location.
	public static final LocationQualifierCode ACT = new LocationQualifierCode("ACT"); // Location is active.
	public static final LocationQualifierCode AVBL = new LocationQualifierCode("AVBL"); // Location is available.
	
	private String value;
	
	public LocationQualifierCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LocationQualifierCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
