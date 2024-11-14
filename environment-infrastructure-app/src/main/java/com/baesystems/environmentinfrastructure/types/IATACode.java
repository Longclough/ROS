package com.baesystems.environmentinfrastructure.types;

public class IATACode {
	// The three letter coded location identifier of an airport/heliport according to the IATA Resolution 763.
	
	private String value;
	
	public IATACode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof IATACode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
