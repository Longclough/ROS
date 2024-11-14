package com.baesystems.environmentinfrastructure.types;

public class PCNMethodCode {
	// A code indicating the method used in the evaluation of a PCN number.
	public static final PCNMethodCode TECH = new PCNMethodCode("TECH"); // [T] Technical evaluation.
	public static final PCNMethodCode ACFT = new PCNMethodCode("ACFT"); // [U] Based on aircraft experience.
	
	private String value;
	
	public PCNMethodCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof PCNMethodCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
