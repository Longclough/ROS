package com.baesystems.environmentinfrastructure.types;

public class FlightDestinationCode {
	// A coded list of values that designate the intentions of a flight in relation with a location, such as arrival, departure or over-flight.
	public static final FlightDestinationCode ARR = new FlightDestinationCode("ARR"); // Arrival flights.
	public static final FlightDestinationCode DEP = new FlightDestinationCode("DEP"); // Departing flights.
	public static final FlightDestinationCode OVERFLY = new FlightDestinationCode("OVERFLY"); // Overflying flights.
	public static final FlightDestinationCode ALL = new FlightDestinationCode("ALL"); // All types (arrival, departure and overflying).
	
	private String value;
	
	public FlightDestinationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FlightDestinationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
