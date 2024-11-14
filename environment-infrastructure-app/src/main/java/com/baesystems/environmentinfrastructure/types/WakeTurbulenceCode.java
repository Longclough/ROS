package com.baesystems.environmentinfrastructure.types;

public class WakeTurbulenceCode {
	// A coded indication of the wake turbulence category of the aircraft.
	public static final WakeTurbulenceCode LOW = new WakeTurbulenceCode("LOW"); // Low wake turbulence.
	public static final WakeTurbulenceCode MEDIUM = new WakeTurbulenceCode("MEDIUM"); // Medium wake turbulence.
	public static final WakeTurbulenceCode HIGH = new WakeTurbulenceCode("HIGH"); // High wake turbulence.
	
	private String value;
	
	public WakeTurbulenceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof WakeTurbulenceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
