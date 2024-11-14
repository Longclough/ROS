package com.baesystems.environmentinfrastructure.types;

public class PilotControlledLightingCode {
	// A list to indicate the standard with which the pilot controlled lighting service complies.
	public static final PilotControlledLightingCode STANDARD_FAA = new PilotControlledLightingCode("STANDARD_FAA"); // FAA Standard.
	public static final PilotControlledLightingCode NON_STANDARD = new PilotControlledLightingCode("NON_STANDARD"); // Non-standard.
	
	private String value;
	
	public PilotControlledLightingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof PilotControlledLightingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
