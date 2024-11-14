package com.baesystems.environmentinfrastructure.types;

public class AlphaCode {
	// A type representing a combination of alphabetic characters.
	
	private String value;
	
	public AlphaCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AlphaCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
