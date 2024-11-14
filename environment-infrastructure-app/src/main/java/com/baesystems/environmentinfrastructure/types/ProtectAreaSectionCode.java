package com.baesystems.environmentinfrastructure.types;

public class ProtectAreaSectionCode {
	// A code indicating the location of the Protect Area lighting.
	public static final ProtectAreaSectionCode EDGE = new ProtectAreaSectionCode("EDGE"); // Area edge.
	public static final ProtectAreaSectionCode END = new ProtectAreaSectionCode("END"); // Area end.
	public static final ProtectAreaSectionCode CL = new ProtectAreaSectionCode("CL"); // Area centreline
	
	private String value;
	
	public ProtectAreaSectionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ProtectAreaSectionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
