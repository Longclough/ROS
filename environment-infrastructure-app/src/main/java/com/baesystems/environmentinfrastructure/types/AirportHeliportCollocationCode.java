package com.baesystems.environmentinfrastructure.types;

public class AirportHeliportCollocationCode {
	// A code indicating the extent of collocation between two airports/heliports.
	public static final AirportHeliportCollocationCode FULL = new AirportHeliportCollocationCode("FULL"); // Full collocation, there is only one aerodrome/heliport.
	public static final AirportHeliportCollocationCode RWY = new AirportHeliportCollocationCode("RWY"); // The two aerodromes share all their RWYs and TWYs, but not their aprons.
	public static final AirportHeliportCollocationCode PARTIAL = new AirportHeliportCollocationCode("PARTIAL"); // Partial collocation, the RWYs of the 1st aerodrome are available to the traffic on the 2nd aerodrome..] 
	public static final AirportHeliportCollocationCode UNILATERAL = new AirportHeliportCollocationCode("UNILATERAL"); // Unilateral co-location, the RWYs, the TWYs and the aprons of the 1st aerodrome are available to traffic on the 2nd aerodrome.
	public static final AirportHeliportCollocationCode SEPARATED = new AirportHeliportCollocationCode("SEPARATED"); // Separated. Even if it is physically possible for an aircraft to taxi between the two aerodrome's manoeuvring areas, this is not operationally allowed.
	
	private String value;
	
	public AirportHeliportCollocationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirportHeliportCollocationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
