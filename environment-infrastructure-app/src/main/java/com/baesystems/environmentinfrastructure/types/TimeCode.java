package com.baesystems.environmentinfrastructure.types;

public class TimeCode {
	// A time (hours and minutes) value with a resolution of 1 minute. For example, 12:45, 14:30, 00:00.
	
	private String value;
	
	public TimeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TimeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
