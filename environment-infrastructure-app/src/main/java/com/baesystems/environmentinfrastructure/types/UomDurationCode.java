package com.baesystems.environmentinfrastructure.types;

public class UomDurationCode {
	// A unit of measurement for time. For example, seconds, minutes, hours
	public static final UomDurationCode HR = new UomDurationCode("HR"); // Hours.
	public static final UomDurationCode MIN = new UomDurationCode("MIN"); // Minutes.
	public static final UomDurationCode SEC = new UomDurationCode("SEC"); // Seconds.
	
	private String value;
	
	public UomDurationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomDurationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
