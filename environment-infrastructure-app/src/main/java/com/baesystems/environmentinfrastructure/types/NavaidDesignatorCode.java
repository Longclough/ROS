package com.baesystems.environmentinfrastructure.types;

public class NavaidDesignatorCode {
	// The coded identifier of a radio navigation aid.
	
	private String value;
	
	public NavaidDesignatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NavaidDesignatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
