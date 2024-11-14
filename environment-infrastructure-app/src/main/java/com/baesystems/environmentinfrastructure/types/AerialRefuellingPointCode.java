package com.baesystems.environmentinfrastructure.types;

public class AerialRefuellingPointCode {
	// Defines the usage type of an aerial refuelling point.
	public static final AerialRefuellingPointCode INITIAL = new AerialRefuellingPointCode("INITIAL"); // Aerial Refuelling Initial Point
	public static final AerialRefuellingPointCode CONTROL = new AerialRefuellingPointCode("CONTROL"); // Aerial Refuelling Control Point
	public static final AerialRefuellingPointCode CHECK = new AerialRefuellingPointCode("CHECK"); // Navigation check point
	public static final AerialRefuellingPointCode EXIT = new AerialRefuellingPointCode("EXIT"); // Aerial Refuelling Exit Point
	public static final AerialRefuellingPointCode ENTRY = new AerialRefuellingPointCode("ENTRY"); // Aerial Refuelling Entry Point (Anchors Only)
	public static final AerialRefuellingPointCode ANCHOR = new AerialRefuellingPointCode("ANCHOR"); // Aerial Refuelling Anchor Point (Anchors Only)
	public static final AerialRefuellingPointCode PATTERN = new AerialRefuellingPointCode("PATTERN"); // Aerial Refuelling Anchor Pattern point (Anchors Only).
	
	private String value;
	
	public AerialRefuellingPointCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AerialRefuellingPointCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
