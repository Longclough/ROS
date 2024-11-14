package com.baesystems.environmentinfrastructure.basictypes.distance;

public class FlightLevel extends Height {
	
	private static final long serialVersionUID = 1L;
	private int flightLevel;

	public int getFlightLevel() {
		return flightLevel;
	}

	public FlightLevel(int flightLevel) {
		super(flightLevel * 100, DistanceUnit.FEET, AltitudeReference.STD);
		this.flightLevel = flightLevel;
	}
	
	public String toString() {
		return "FL" + (int)flightLevel;
	}
}
