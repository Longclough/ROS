package com.baesystems.environmentinfrastructure.types;

public class AircraftICAOCode {
	// A coded aircraft type designator assigned by ICAO to all aircraft heavier than micro-/ultra-light.
	
	private String value;
	
	public AircraftICAOCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AircraftICAOCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
