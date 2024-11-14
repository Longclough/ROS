package com.baesystems.environmentinfrastructure.types;

public class SideCode {
	// A code describing a position, relative to an axis. For example: left/right of runway centreline.
	public static final SideCode LEFT = new SideCode("LEFT"); // On the left side of the axis.
	public static final SideCode RIGHT = new SideCode("RIGHT"); // On the right side of the axis.
	public static final SideCode BOTH = new SideCode("BOTH"); // Distributed on both sides of the axis.
	
	private String value;
	
	public SideCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SideCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
