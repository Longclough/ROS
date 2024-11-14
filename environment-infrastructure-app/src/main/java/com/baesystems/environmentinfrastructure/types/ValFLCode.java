package com.baesystems.environmentinfrastructure.types;

public class ValFLCode {
	// A value expressed in flight levels (FL).
	
	private String value;
	
	public ValFLCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValFLCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
