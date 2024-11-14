package com.baesystems.environmentinfrastructure.types;

public class ValDistanceSignedCode {
	// A signed distance.
	
	private String value;
	
	public ValDistanceSignedCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValDistanceSignedCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
