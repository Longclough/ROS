package com.baesystems.environmentinfrastructure.types;

public class AerialRefuellingCode {
	// A code indicating the type of aerial refuelling pattern.
	public static final AerialRefuellingCode TRACK = new AerialRefuellingCode("TRACK"); // Aerial Refuelling Track of type TRACK, which is linear.
	public static final AerialRefuellingCode ANCHOR = new AerialRefuellingCode("ANCHOR"); // Aerial Refuelling Track of type ANCHOR, with the shape of a race track.
	public static final AerialRefuellingCode BOTH = new AerialRefuellingCode("BOTH"); // Aerial Refuelling Track with the shape of both TRACK and ANCHOR.
	
	private String value;
	
	public AerialRefuellingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AerialRefuellingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
