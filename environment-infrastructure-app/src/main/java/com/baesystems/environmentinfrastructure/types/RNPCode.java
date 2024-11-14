package com.baesystems.environmentinfrastructure.types;

public class RNPCode {
	// A code indicating the value of the required navigation performance.
	
	private String value;
	
	public RNPCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RNPCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
