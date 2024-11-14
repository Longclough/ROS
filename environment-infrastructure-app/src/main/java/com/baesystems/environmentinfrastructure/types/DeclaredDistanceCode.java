package com.baesystems.environmentinfrastructure.types;

public class DeclaredDistanceCode {
	// A code indicating the type of conventional declared distance for a runway. For example, TORA, TODA, LDA, etc...
	public static final DeclaredDistanceCode LDA = new DeclaredDistanceCode("LDA"); // Landing distance available
	public static final DeclaredDistanceCode TORA = new DeclaredDistanceCode("TORA"); // Take-off run available
	public static final DeclaredDistanceCode TODA = new DeclaredDistanceCode("TODA"); // Take-off distance available
	public static final DeclaredDistanceCode ASDA = new DeclaredDistanceCode("ASDA"); // Accelerate-stop distance available
	public static final DeclaredDistanceCode DTHR = new DeclaredDistanceCode("DTHR"); // Threshold displacement (from the physical start of the runway direction).
	public static final DeclaredDistanceCode TODAH = new DeclaredDistanceCode("TODAH"); // Take-Off Distance Available for Helicopters
	public static final DeclaredDistanceCode RTODAH = new DeclaredDistanceCode("RTODAH"); // Rejected TODA for Helicopters
	public static final DeclaredDistanceCode LDAH = new DeclaredDistanceCode("LDAH"); // LDA for Helicopters
	
	private String value;
	
	public DeclaredDistanceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DeclaredDistanceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
