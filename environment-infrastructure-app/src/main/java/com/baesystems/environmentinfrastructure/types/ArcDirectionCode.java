package com.baesystems.environmentinfrastructure.types;

public class ArcDirectionCode {
	// A code indicating the direction of an arc (clockwise or counterclockwise).
	public static final ArcDirectionCode CWA = new ArcDirectionCode("CWA"); // Clockwise arc
	public static final ArcDirectionCode CCA = new ArcDirectionCode("CCA"); // Counter clockwise arc
	
	private String value;
	
	public ArcDirectionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ArcDirectionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
