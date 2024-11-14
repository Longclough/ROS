package com.baesystems.environmentinfrastructure.types;

public class RelativePositionCode {
	// A coded list of values indicating a relative position, in relation with a reference point situated along a given trajectory.
	public static final RelativePositionCode BEFORE = new RelativePositionCode("BEFORE"); // A location in advance of the reference point.
	public static final RelativePositionCode AT = new RelativePositionCode("AT"); // A location at the reference point.
	public static final RelativePositionCode AFTER = new RelativePositionCode("AFTER"); // A location following the reference point
	
	private String value;
	
	public RelativePositionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RelativePositionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
