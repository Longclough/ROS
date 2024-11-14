package com.baesystems.environmentinfrastructure.types;

public class ValDepthCode {
	// The value of a depth.
	
	private String value;
	
	public ValDepthCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValDepthCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
