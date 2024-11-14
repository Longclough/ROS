package com.baesystems.environmentinfrastructure.types;

public class UomSpeedCode {
	// A unit of measurement for speed.
	public static final UomSpeedCode KM_H = new UomSpeedCode("KM_H"); // Kilometres per hour.
	public static final UomSpeedCode KT = new UomSpeedCode("KT"); // Knots.
	public static final UomSpeedCode MACH = new UomSpeedCode("MACH"); // Mach number.
	public static final UomSpeedCode M_MIN = new UomSpeedCode("M_MIN"); // Metres per minute.
	public static final UomSpeedCode FT_MIN = new UomSpeedCode("FT_MIN"); // Feet per minute.
	public static final UomSpeedCode M_SEC = new UomSpeedCode("M_SEC"); // Metres per second.
	public static final UomSpeedCode FT_SEC = new UomSpeedCode("FT_SEC"); // Feet per second.
	public static final UomSpeedCode MPH = new UomSpeedCode("MPH"); // Miles per hour.
	
	private String value;
	
	public UomSpeedCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomSpeedCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
