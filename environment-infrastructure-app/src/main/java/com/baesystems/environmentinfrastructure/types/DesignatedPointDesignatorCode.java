package com.baesystems.environmentinfrastructure.types;

public class DesignatedPointDesignatorCode {
	// The coded identifier of a designated point
	
	private String value;
	
	public DesignatedPointDesignatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DesignatedPointDesignatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
