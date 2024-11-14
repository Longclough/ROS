package com.baesystems.environmentinfrastructure.types;

public class Character2Code {
	// A string of Unicode characters.
	
	private String value;
	
	public Character2Code(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Character2Code) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
