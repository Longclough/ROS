package com.baesystems.environmentinfrastructure.types;

public class ValSlopeCode {
	// The value of a slope or climb/descent gradient, expressed as a percentage.
	
	private String value;
	
	public ValSlopeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValSlopeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
