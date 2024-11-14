package com.baesystems.environmentinfrastructure.types;

public class AircraftCode {
	// A code indicating the type of an aircraft
	public static final AircraftCode LANDPLANE = new AircraftCode("LANDPLANE"); // Landplane
	public static final AircraftCode SEAPLANE = new AircraftCode("SEAPLANE"); // Seaplane
	public static final AircraftCode AMPHIBIAN = new AircraftCode("AMPHIBIAN"); // Amphibian
	public static final AircraftCode HELICOPTER = new AircraftCode("HELICOPTER"); // Helicopter
	public static final AircraftCode GYROCOPTER = new AircraftCode("GYROCOPTER"); // Gyrocopter
	public static final AircraftCode TILT_WING = new AircraftCode("TILT_WING"); // Tilt-wing aircraft
	public static final AircraftCode STOL = new AircraftCode("STOL"); // Short Take-Off and Landing (STOL)
	public static final AircraftCode GLIDER = new AircraftCode("GLIDER"); // Glider
	public static final AircraftCode HANGGLIDER = new AircraftCode("HANGGLIDER"); // Hang-glider
	public static final AircraftCode PARAGLIDER = new AircraftCode("PARAGLIDER"); // Para-glider
	public static final AircraftCode ULTRA_LIGHT = new AircraftCode("ULTRA_LIGHT"); // Ultra light
	public static final AircraftCode BALLOON = new AircraftCode("BALLOON"); // Balloon
	public static final AircraftCode UAV = new AircraftCode("UAV"); // Unmanned Aerial Vehicle (UAV) drone
	public static final AircraftCode ALL = new AircraftCode("ALL"); // All aircraft types.
	
	private String value;
	
	public AircraftCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AircraftCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
