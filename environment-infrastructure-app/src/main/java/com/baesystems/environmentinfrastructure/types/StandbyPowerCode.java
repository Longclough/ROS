package com.baesystems.environmentinfrastructure.types;

public class StandbyPowerCode {
	// Type of power used when the radar is required to operate on standby.
	public static final StandbyPowerCode BATTERY = new StandbyPowerCode("BATTERY"); // null
	public static final StandbyPowerCode COMMERCIAL = new StandbyPowerCode("COMMERCIAL"); // null
	public static final StandbyPowerCode GENERATOR = new StandbyPowerCode("GENERATOR"); // null
	public static final StandbyPowerCode UNKNOWN = new StandbyPowerCode("UNKNOWN"); // null
	public static final StandbyPowerCode NONE = new StandbyPowerCode("NONE"); // null
	
	private String value;
	
	public StandbyPowerCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof StandbyPowerCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
