package com.baesystems.environmentinfrastructure.types;

public class AlphanumericCode {
	// A type representing a combination of alphabetic and numeric characters.
	
	private String value;
	
	public AlphanumericCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AlphanumericCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
