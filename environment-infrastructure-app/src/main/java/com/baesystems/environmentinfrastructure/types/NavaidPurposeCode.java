package com.baesystems.environmentinfrastructure.types;

public class NavaidPurposeCode {
	// A coded list of values indicating the intended usage of a navaid (enroute or airport)
	public static final NavaidPurposeCode TERMINAL = new NavaidPurposeCode("TERMINAL"); // Intended for usage in the terminal area, in particular for approach, landing and departure procedures
	public static final NavaidPurposeCode ENROUTE = new NavaidPurposeCode("ENROUTE"); // Intended for en-route usage
	public static final NavaidPurposeCode ALL = new NavaidPurposeCode("ALL"); // Intended for all usages
	
	private String value;
	
	public NavaidPurposeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NavaidPurposeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
