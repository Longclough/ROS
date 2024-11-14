package com.baesystems.environmentinfrastructure.types;

public class AerialRefuellingPrefixCode {
	// A prefix for the designator of the Aerial Refuelling route.
	public static final AerialRefuellingPrefixCode AR = new AerialRefuellingPrefixCode("AR"); // Aerial Refuelling.
	
	private String value;
	
	public AerialRefuellingPrefixCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AerialRefuellingPrefixCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
