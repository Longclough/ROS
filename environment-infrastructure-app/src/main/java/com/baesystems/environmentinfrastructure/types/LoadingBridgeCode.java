package com.baesystems.environmentinfrastructure.types;

public class LoadingBridgeCode {
	// An coded list of values that indicate types of passenger loading bridges.
	public static final LoadingBridgeCode ARM = new LoadingBridgeCode("ARM"); // Arm
	public static final LoadingBridgeCode MOVABLE_ARM = new LoadingBridgeCode("MOVABLE_ARM"); // Movable arm
	public static final LoadingBridgeCode PORTABLE_RAMP = new LoadingBridgeCode("PORTABLE_RAMP"); // Portable ramp
	public static final LoadingBridgeCode PORTABLE_STAIRS = new LoadingBridgeCode("PORTABLE_STAIRS"); // Portable stairs
	
	private String value;
	
	public LoadingBridgeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LoadingBridgeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
