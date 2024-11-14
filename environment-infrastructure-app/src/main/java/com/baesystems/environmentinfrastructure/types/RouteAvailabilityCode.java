package com.baesystems.environmentinfrastructure.types;

public class RouteAvailabilityCode {
	// A code indicating the route segment availability.
	public static final RouteAvailabilityCode OPEN = new RouteAvailabilityCode("OPEN"); // the route segment may be flown according to its timetable.
	public static final RouteAvailabilityCode COND = new RouteAvailabilityCode("COND"); // Special use.note: This value is needed as long as 'special' types of routes exist. Examples:- routes which are closed during some time periods, but still may be used for landings on a specified aerodrome;- flights may be performed below the minimum level of the route in order to arrive at a specified aerodrome.
	public static final RouteAvailabilityCode CLSD = new RouteAvailabilityCode("CLSD"); // Closed.
	
	private String value;
	
	public RouteAvailabilityCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RouteAvailabilityCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
