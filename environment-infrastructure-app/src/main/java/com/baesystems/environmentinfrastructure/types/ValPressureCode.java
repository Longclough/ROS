package com.baesystems.environmentinfrastructure.types;

public class ValPressureCode {
	// The value of a pressure.
	
	private String value;
	
	public ValPressureCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValPressureCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
