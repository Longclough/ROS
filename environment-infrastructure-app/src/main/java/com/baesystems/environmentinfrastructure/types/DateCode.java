package com.baesystems.environmentinfrastructure.types;

public class DateCode {
	// The value of a calendar date.
	
	private String value;
	
	public DateCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DateCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
