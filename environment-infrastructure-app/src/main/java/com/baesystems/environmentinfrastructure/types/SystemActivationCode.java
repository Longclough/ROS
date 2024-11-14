package com.baesystems.environmentinfrastructure.types;

public class SystemActivationCode {
	// A code indicating the activation / deactivation of a system following a specific comand.
	public static final SystemActivationCode ON = new SystemActivationCode("ON"); // System in status "on-line".
	public static final SystemActivationCode ON_OR_OFF = new SystemActivationCode("ON_OR_OFF"); // System changes between "ON" and "OFF", depending on the previous state.
	public static final SystemActivationCode OFF = new SystemActivationCode("OFF"); // System in status "off-line".
	
	private String value;
	
	public SystemActivationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SystemActivationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
