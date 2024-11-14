package com.baesystems.environmentinfrastructure.types;

public class ICAOCode {
	// The four letter coded location identifier as published in the ICAO DOC 7910 - Location Indicators.
	
	private String value;
	
	public ICAOCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ICAOCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
