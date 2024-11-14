package com.baesystems.environmentinfrastructure.types;

public class TextPhoneCode {
	// A phone or facsimile number
	
	private String value;
	
	public TextPhoneCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TextPhoneCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
