package com.baesystems.environmentinfrastructure.types;

public class StatusAirportCode {
	// A coded list of values that indicates the availability of an airport/heliport facility for specific flight operations.
	public static final StatusAirportCode NORMAL = new StatusAirportCode("NORMAL"); // The facility operates with nominal parameters.
	public static final StatusAirportCode LIMITED = new StatusAirportCode("LIMITED"); // The facility operates below its nominal parameters, with additional usage restrictions.
	public static final StatusAirportCode CLOSED = new StatusAirportCode("CLOSED"); // The facility is not operational.
	
	private String value;
	
	public StatusAirportCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof StatusAirportCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
