package com.baesystems.environmentinfrastructure.types;

public class AircraftGroundServiceCode {
	// A code indicating a type of service provided to aircraft on the ground.
	public static final AircraftGroundServiceCode DEICE = new AircraftGroundServiceCode("DEICE"); // De-icing service.
	public static final AircraftGroundServiceCode HAND = new AircraftGroundServiceCode("HAND"); // Handling service.
	public static final AircraftGroundServiceCode HANGAR = new AircraftGroundServiceCode("HANGAR"); // Hangar service
	public static final AircraftGroundServiceCode REPAIR = new AircraftGroundServiceCode("REPAIR"); // Repairing service.
	public static final AircraftGroundServiceCode REMOVE = new AircraftGroundServiceCode("REMOVE"); // Removal of disabled aircraft.
	
	private String value;
	
	public AircraftGroundServiceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AircraftGroundServiceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
