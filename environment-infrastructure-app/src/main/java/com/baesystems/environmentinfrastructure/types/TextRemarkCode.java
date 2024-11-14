package com.baesystems.environmentinfrastructure.types;

public class TextRemarkCode {
	// Free text remarks.
	
	private String value;
	
	public TextRemarkCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TextRemarkCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
