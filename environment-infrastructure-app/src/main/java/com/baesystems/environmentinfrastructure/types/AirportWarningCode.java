package com.baesystems.environmentinfrastructure.types;

public class AirportWarningCode {
	// A code indicating a reason for caution in airport operations.  For example, work in progress on a runway.
	public static final AirportWarningCode WIP = new AirportWarningCode("WIP"); // Work in progress.
	public static final AirportWarningCode EQUIP = new AirportWarningCode("EQUIP"); // Men and Equipment.
	public static final AirportWarningCode BIRD = new AirportWarningCode("BIRD"); // Bird hazard
	public static final AirportWarningCode ANIMAL = new AirportWarningCode("ANIMAL"); // Animal hazard.
	public static final AirportWarningCode RUBBER_REMOVAL = new AirportWarningCode("RUBBER_REMOVAL"); // Removal of rubber deposits from runways.
	public static final AirportWarningCode PARKED_ACFT = new AirportWarningCode("PARKED_ACFT"); // Parked or Disabled Aircraft located on the surface.
	public static final AirportWarningCode RESURFACING = new AirportWarningCode("RESURFACING"); // Resurfacing work in progress.
	public static final AirportWarningCode PAVING = new AirportWarningCode("PAVING"); // Surface paving work in progress.
	public static final AirportWarningCode PAINTING = new AirportWarningCode("PAINTING"); // Surface painting work in progress.
	public static final AirportWarningCode INSPECTION = new AirportWarningCode("INSPECTION"); // Presence of people or equipment due to ground facilities inspection work in progress.
	public static final AirportWarningCode GRASS_CUTTING = new AirportWarningCode("GRASS_CUTTING"); // Presence of people or equipment due to grass cutting work in progress.
	public static final AirportWarningCode CALIBRATION = new AirportWarningCode("CALIBRATION"); // Presence of people or equipment due to calibration work for ground facilities.
	
	private String value;
	
	public AirportWarningCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirportWarningCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
