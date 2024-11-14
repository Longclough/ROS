package com.baesystems.environmentinfrastructure.types;

public class TextNameCode {
	// The official name of a State, an aerodrome, a unit, etc..
	
	private String value;
	
	public TextNameCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TextNameCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
