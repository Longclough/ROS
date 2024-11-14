package com.baesystems.environmentinfrastructure.types;

public class TextPropertyNameCode {
	// The name of a simple property, in lowerCamelCase.
	
	private String value;
	
	public TextPropertyNameCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TextPropertyNameCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
