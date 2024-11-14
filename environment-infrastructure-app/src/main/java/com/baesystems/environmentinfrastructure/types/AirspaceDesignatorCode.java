package com.baesystems.environmentinfrastructure.types;

public class AirspaceDesignatorCode {
	// Allowed types of airspace.
	
	private String value;
	
	public AirspaceDesignatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirspaceDesignatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
