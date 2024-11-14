package com.baesystems.environmentinfrastructure.types;

public class ApproachLightingICAOCode {
	// Classification of the approach lighting system using as criteria the ICAO Annex 14 standards and recommended practices.
	public static final ApproachLightingICAOCode SIMPLE = new ApproachLightingICAOCode("SIMPLE"); // Simple approach lighting system (ICAO Annex 14, Vol 1, 5.3.4.2) 
	public static final ApproachLightingICAOCode CAT1 = new ApproachLightingICAOCode("CAT1"); // Precision approach category I lighting system (ICAO Annex 14, Vol 1, 5.3.4.10) 
	public static final ApproachLightingICAOCode CAT23 = new ApproachLightingICAOCode("CAT23"); // Precision approach category II and III lighting system (ICAO Annex 14, Vol 1, 5.3.4.22) 
	public static final ApproachLightingICAOCode CIRCLING = new ApproachLightingICAOCode("CIRCLING"); // Circling guidance lighting system (ICAO Annex 14, Vol 1, 5.3.6) 
	public static final ApproachLightingICAOCode LEADIN = new ApproachLightingICAOCode("LEADIN"); // Runway lead-in lighting system (ICAO Annex 14, Vol 1, 5.3.7) 
	public static final ApproachLightingICAOCode NONE = new ApproachLightingICAOCode("NONE"); //  Does not classify as an ICAO type
	
	private String value;
	
	public ApproachLightingICAOCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ApproachLightingICAOCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
