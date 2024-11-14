package com.baesystems.environmentinfrastructure.types;

public class EmissionBandCode {
	// The type of emission band
	public static final EmissionBandCode U = new EmissionBandCode("U"); // Ultra high frequency
	public static final EmissionBandCode H = new EmissionBandCode("H"); // High frequency
	public static final EmissionBandCode M = new EmissionBandCode("M"); // Medium frequency
	
	private String value;
	
	public EmissionBandCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof EmissionBandCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
