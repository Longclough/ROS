package com.baesystems.environmentinfrastructure.types;

public class DateTimeCode {
	// A full date and time value.
	
	private String value;
	
	public DateTimeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DateTimeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
