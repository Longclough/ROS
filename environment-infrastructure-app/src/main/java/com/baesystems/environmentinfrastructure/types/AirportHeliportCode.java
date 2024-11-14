package com.baesystems.environmentinfrastructure.types;

public class AirportHeliportCode {
	// A code specifying whether a particular entity occurrence is an Aerodrome or a Heliport.
	public static final AirportHeliportCode AD = new AirportHeliportCode("AD"); // Aerodrome only.
	public static final AirportHeliportCode AH = new AirportHeliportCode("AH"); // Aerodrome with heliport landing area.
	public static final AirportHeliportCode HP = new AirportHeliportCode("HP"); // Heliport only.
	public static final AirportHeliportCode LS = new AirportHeliportCode("LS"); // Landing site.
	
	private String value;
	
	public AirportHeliportCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirportHeliportCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
