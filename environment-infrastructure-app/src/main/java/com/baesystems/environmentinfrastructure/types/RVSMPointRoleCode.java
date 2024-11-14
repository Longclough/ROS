package com.baesystems.environmentinfrastructure.types;

public class RVSMPointRoleCode {
	// A code indicating that the point has a specific role in the RVSM context.
	public static final RVSMPointRoleCode IN = new RVSMPointRoleCode("IN"); // RVSM Entry Point.
	public static final RVSMPointRoleCode OUT = new RVSMPointRoleCode("OUT"); // RVSM Exit point.
	public static final RVSMPointRoleCode IN_OUT = new RVSMPointRoleCode("IN_OUT"); // RVSM Entry/Exit Point.
	
	private String value;
	
	public RVSMPointRoleCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RVSMPointRoleCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
