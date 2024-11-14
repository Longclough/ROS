package com.baesystems.environmentinfrastructure.types;

public class DateMonthDayCode {
	// A date value without year indication. Same each year.For example, 15-02, 29-04.
	
	private String value;
	
	public DateMonthDayCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DateMonthDayCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
