package com.baesystems.environmentinfrastructure.types;

public class FreeFlightCode {
	// Code classifying entry and exit points for free flight zones.
	public static final FreeFlightCode PITCH = new FreeFlightCode("PITCH"); // The free flight PITCH point indicating the start of free flight.
	public static final FreeFlightCode CATCH = new FreeFlightCode("CATCH"); // Free flight CATCH point indicating the end of free flight.
	
	private String value;
	
	public FreeFlightCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FreeFlightCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
