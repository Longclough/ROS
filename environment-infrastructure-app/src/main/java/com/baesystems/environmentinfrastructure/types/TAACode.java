package com.baesystems.environmentinfrastructure.types;

public class TAACode {
	// Indicates one of the three area types of the Terminal Arrival Area.
	public static final TAACode LEFT_BASE = new TAACode("LEFT_BASE"); // Left base
	public static final TAACode RIGHT_BASE = new TAACode("RIGHT_BASE"); // Right base
	public static final TAACode STRAIGHT_IN = new TAACode("STRAIGHT_IN"); // Straight-in
	
	private String value;
	
	public TAACode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TAACode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
