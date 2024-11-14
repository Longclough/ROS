package com.baesystems.environmentinfrastructure.types;

public class FlightStatusCode {
	// A code indicating status of a flight.
	public static final FlightStatusCode HEAD = new FlightStatusCode("HEAD"); // Head of state.
	public static final FlightStatusCode STATE = new FlightStatusCode("STATE"); // State aircraft. (Other than head of state).
	public static final FlightStatusCode HUM = new FlightStatusCode("HUM"); // Humanitarian flight.
	public static final FlightStatusCode HOSP = new FlightStatusCode("HOSP"); // Hospital flight.
	public static final FlightStatusCode SAR = new FlightStatusCode("SAR"); // Search and rescue.
	public static final FlightStatusCode ALL = new FlightStatusCode("ALL"); // All aircraft types.
	public static final FlightStatusCode EMERGENCY = new FlightStatusCode("EMERGENCY"); // The aircraft has declared an emergency situation.
	
	private String value;
	
	public FlightStatusCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FlightStatusCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
