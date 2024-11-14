package com.baesystems.environmentinfrastructure.types;

public class OilCode {
	// A code indicating the category of oil available at an aerodrome/heliport.
	public static final OilCode PISTON = new OilCode("PISTON"); // Piston engine oil.
	public static final OilCode TURBO = new OilCode("TURBO"); // Turbo oil.
	public static final OilCode HYDRAULIC = new OilCode("HYDRAULIC"); // Hydraulic oil.
	
	private String value;
	
	public OilCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof OilCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
