package com.baesystems.environmentinfrastructure.types;

public class ValAngleCode {
	// The value of an angle.
	
	private String value;
	
	public ValAngleCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValAngleCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
