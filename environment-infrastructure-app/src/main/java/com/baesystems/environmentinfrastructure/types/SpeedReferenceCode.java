package com.baesystems.environmentinfrastructure.types;

public class SpeedReferenceCode {
	// A code indicating the reference system for a speed value.
	public static final SpeedReferenceCode IAS = new SpeedReferenceCode("IAS"); // Indicated airspeed.
	public static final SpeedReferenceCode TAS = new SpeedReferenceCode("TAS"); // True air speed.
	public static final SpeedReferenceCode GS = new SpeedReferenceCode("GS"); // Ground speed.
	
	private String value;
	
	public SpeedReferenceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SpeedReferenceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
