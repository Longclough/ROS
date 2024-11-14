package com.baesystems.environmentinfrastructure.types;

public class MilitaryOperationsCode {
	// A code indicating in terms of civil or military, the type of operations.
	public static final MilitaryOperationsCode CIVIL = new MilitaryOperationsCode("CIVIL"); // Only Civil Air traffic is concerned.
	public static final MilitaryOperationsCode MIL = new MilitaryOperationsCode("MIL"); // Only Military Air traffic is concerned.
	public static final MilitaryOperationsCode JOINT = new MilitaryOperationsCode("JOINT"); // Both Civil and Military air traffic are concerned.
	
	private String value;
	
	public MilitaryOperationsCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MilitaryOperationsCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
