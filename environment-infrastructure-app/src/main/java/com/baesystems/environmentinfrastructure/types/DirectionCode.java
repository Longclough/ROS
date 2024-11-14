package com.baesystems.environmentinfrastructure.types;

public class DirectionCode {
	// A code indicating a 1-dimensional direction, for example, forward or backward.
	public static final DirectionCode FORWARD = new DirectionCode("FORWARD"); // Forward.
	public static final DirectionCode BACKWARD = new DirectionCode("BACKWARD"); // Backward.
	public static final DirectionCode BOTH = new DirectionCode("BOTH"); // Both
	
	private String value;
	
	public DirectionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DirectionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
