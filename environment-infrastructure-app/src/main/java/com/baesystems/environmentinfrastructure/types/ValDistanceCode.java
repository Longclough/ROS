package com.baesystems.environmentinfrastructure.types;

public class ValDistanceCode {
	// A (positive) distance.
	
	private String value;
	
	public ValDistanceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValDistanceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
