package com.baesystems.environmentinfrastructure.types;

public class DateYearCode {
	// A date for which only the year value is significant.
	
	private String value;
	
	public DateYearCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DateYearCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
