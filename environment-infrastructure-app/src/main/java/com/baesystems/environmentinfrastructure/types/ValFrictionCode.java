package com.baesystems.environmentinfrastructure.types;

public class ValFrictionCode {
	// The value of a friction coefficient.
	
	private String value;
	
	public ValFrictionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValFrictionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
