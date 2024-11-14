package com.baesystems.environmentinfrastructure.types;

public class FlightRestrictionDesignatorCode {
	// A coded value which uniquely identifies a traffic flow restriction.
	
	private String value;
	
	public FlightRestrictionDesignatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FlightRestrictionDesignatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
