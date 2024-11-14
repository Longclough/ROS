package com.baesystems.environmentinfrastructure.types;

public class FlightOriginCode {
	// A coded list of values indicating the source of a flight (local, national, international, etc.)
	public static final FlightOriginCode NTL = new FlightOriginCode("NTL"); // National
	public static final FlightOriginCode INTL = new FlightOriginCode("INTL"); // International.
	public static final FlightOriginCode ALL = new FlightOriginCode("ALL"); // Any origin.
	public static final FlightOriginCode HOME_BASED = new FlightOriginCode("HOME_BASED"); // The flight is operated with an aircraft currently stationed at the airport in question.
	
	private String value;
	
	public FlightOriginCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FlightOriginCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
