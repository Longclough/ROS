package com.baesystems.environmentinfrastructure.types;

public class ValSpeedCode {
	// The value of a speed.
	
	private String value;
	
	public ValSpeedCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValSpeedCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
