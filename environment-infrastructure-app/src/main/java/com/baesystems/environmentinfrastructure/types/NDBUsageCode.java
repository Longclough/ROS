package com.baesystems.environmentinfrastructure.types;

public class NDBUsageCode {
	// A code indicating the class of an NDB.
	public static final NDBUsageCode ENR = new NDBUsageCode("ENR"); // Enroute NDB.
	public static final NDBUsageCode L = new NDBUsageCode("L"); // Locator - low powered NDB used as an aid for final approach (also known as a compass locator).
	public static final NDBUsageCode MAR = new NDBUsageCode("MAR"); // Marine beacon.
	
	private String value;
	
	public NDBUsageCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NDBUsageCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
