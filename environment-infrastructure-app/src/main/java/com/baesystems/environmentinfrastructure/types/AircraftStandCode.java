package com.baesystems.environmentinfrastructure.types;

public class AircraftStandCode {
	// A code indicating the type of stand.For example, parking position on the apron, isolated aircraft stand, terminal building gate, etc..
	public static final AircraftStandCode NI = new AircraftStandCode("NI"); // Nose-in parking position.
	public static final AircraftStandCode ANG_NI = new AircraftStandCode("ANG_NI"); // Angled nose-in parking position.
	public static final AircraftStandCode ANG_NO = new AircraftStandCode("ANG_NO"); // Angled nose-out parking position.
	public static final AircraftStandCode PARL = new AircraftStandCode("PARL"); // Parallel (to building) parking position.
	public static final AircraftStandCode RMT = new AircraftStandCode("RMT"); // Remote parking position.
	public static final AircraftStandCode ISOL = new AircraftStandCode("ISOL"); // Isolated parking position.
	
	private String value;
	
	public AircraftStandCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AircraftStandCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
