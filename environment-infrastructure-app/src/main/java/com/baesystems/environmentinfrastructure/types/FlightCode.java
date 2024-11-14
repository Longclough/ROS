package com.baesystems.environmentinfrastructure.types;

public class FlightCode {
	// A code indicating the type of a flight.
	public static final FlightCode OAT = new FlightCode("OAT"); // Operational air traffic.
	public static final FlightCode GAT = new FlightCode("GAT"); // General air traffic.
	public static final FlightCode ALL = new FlightCode("ALL"); // Both Operational and General Air Traffic.
	
	private String value;
	
	public FlightCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FlightCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
