package com.baesystems.environmentinfrastructure.types;

public class MilitaryStatusCode {
	// A code distinguishing between military and civil status.
	public static final MilitaryStatusCode MIL = new MilitaryStatusCode("MIL"); // Military.
	public static final MilitaryStatusCode CIVIL = new MilitaryStatusCode("CIVIL"); // Civil.
	public static final MilitaryStatusCode ALL = new MilitaryStatusCode("ALL"); // Both civil and military.
	
	private String value;
	
	public MilitaryStatusCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MilitaryStatusCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
