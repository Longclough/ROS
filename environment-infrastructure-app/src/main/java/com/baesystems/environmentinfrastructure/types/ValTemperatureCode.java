package com.baesystems.environmentinfrastructure.types;

public class ValTemperatureCode {
	// The value of a temperature.
	
	private String value;
	
	public ValTemperatureCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValTemperatureCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
