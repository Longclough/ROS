package com.baesystems.environmentinfrastructure.types;

public class PCNPavementCode {
	// A code indicating the pavement behaviour (rigid or flexible) used for the ACN determination.
	public static final PCNPavementCode RIGID = new PCNPavementCode("RIGID"); // [R] Rigid pavement.
	public static final PCNPavementCode FLEXIBLE = new PCNPavementCode("FLEXIBLE"); // [F] Flexible pavement.
	
	private String value;
	
	public PCNPavementCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof PCNPavementCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
