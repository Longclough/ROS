package com.baesystems.environmentinfrastructure.types;

public class TimeEventCode {
	// A code indicating an event occurrence during any day.For example, sunrise, sunset.
	public static final TimeEventCode SR = new TimeEventCode("SR"); // Sunrise
	public static final TimeEventCode SS = new TimeEventCode("SS"); // Sunset
	
	private String value;
	
	public TimeEventCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TimeEventCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
