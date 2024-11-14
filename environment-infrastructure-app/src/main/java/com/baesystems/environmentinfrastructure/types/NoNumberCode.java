package com.baesystems.environmentinfrastructure.types;

public class NoNumberCode {
	// A (positive) number of similar items.
	
	private String value;
	
	public NoNumberCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NoNumberCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
