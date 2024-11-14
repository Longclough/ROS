package com.baesystems.environmentinfrastructure.types;

public class FrictionDeviceCode {
	// An enumeration of equipment types used to determine the friction coefficient on an airport/heliport movement area.
	public static final FrictionDeviceCode BRD = new FrictionDeviceCode("BRD"); // Brakemeter-Dynometer.
	public static final FrictionDeviceCode GRT = new FrictionDeviceCode("GRT"); // Grip tester.
	public static final FrictionDeviceCode MUM = new FrictionDeviceCode("MUM"); // Mu-meter.
	public static final FrictionDeviceCode RFT = new FrictionDeviceCode("RFT"); // Runway friction tester.
	public static final FrictionDeviceCode SFH = new FrictionDeviceCode("SFH"); // Surface friction tester (high-pressure tire).
	public static final FrictionDeviceCode SFL = new FrictionDeviceCode("SFL"); // Surface friction tester (low-pressure tire).
	public static final FrictionDeviceCode SKH = new FrictionDeviceCode("SKH"); // Skiddometer (high-pressure tire).
	public static final FrictionDeviceCode SKL = new FrictionDeviceCode("SKL"); // Skiddometer (low-pressure tire).
	public static final FrictionDeviceCode TAP = new FrictionDeviceCode("TAP"); // Tapley meter.
	
	private String value;
	
	public FrictionDeviceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FrictionDeviceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
