package com.baesystems.environmentinfrastructure.types;

public class RVSMCode {
	// A code indicating that reduced vertical separation minima is applied in the column or not.
	public static final RVSMCode RVSM = new RVSMCode("RVSM"); // Reduced Vertical Separation Minima
	public static final RVSMCode NON_RVSM = new RVSMCode("NON_RVSM"); // Non-RVSM.
	
	private String value;
	
	public RVSMCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RVSMCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
