package com.baesystems.environmentinfrastructure.types;

public class FlightPurposeCode {
	// A coded list of values indicating the nature of a flight (scheduled, non-scheduled, private, etc.)
	public static final FlightPurposeCode SCHEDULED = new FlightPurposeCode("SCHEDULED"); // A commercial flight (carrying passenger or cargo for a pay) that takes place in accordance with an airlines published regular timetable, as opposed to a charter flight or special flight.
	public static final FlightPurposeCode NON_SCHEDULED = new FlightPurposeCode("NON_SCHEDULED"); // A commercial charter or special flight executed by an airline, not published in a regular timetable.
	public static final FlightPurposeCode PRIVATE = new FlightPurposeCode("PRIVATE"); // A flight executed for the benefit of the aircraft owner and not for commercial purpose.
	public static final FlightPurposeCode AIR_TRAINING = new FlightPurposeCode("AIR_TRAINING"); // A flight executed in order to develop or test the flying skills of the crew on board the aircraft.
	public static final FlightPurposeCode AIR_WORK = new FlightPurposeCode("AIR_WORK"); // Operations in which an aircraft is used for specialized services.
	public static final FlightPurposeCode ALL = new FlightPurposeCode("ALL"); // All flight purpose.
	public static final FlightPurposeCode PARTICIPANT = new FlightPurposeCode("PARTICIPANT"); // Aircraft participating in a specified activity.
	
	private String value;
	
	public FlightPurposeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FlightPurposeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
