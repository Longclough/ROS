package com.baesystems.environmentinfrastructure.types;

public class LightHoldingPositionCode {
	// A coded list of light signs provided for a taxiway holding position.
	public static final LightHoldingPositionCode STOP_BAR = new LightHoldingPositionCode("STOP_BAR"); // Stop-bar (on the surface of the taxiway).
	public static final LightHoldingPositionCode SIGN = new LightHoldingPositionCode("SIGN"); // Lighted sign on the side of the holding position.
	
	private String value;
	
	public LightHoldingPositionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LightHoldingPositionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
