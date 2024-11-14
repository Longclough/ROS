package com.baesystems.environmentinfrastructure.types;

public class ReflectorCode {
	// Type of Reflector associated to the PAR.
	public static final ReflectorCode TOUCHDOWN = new ReflectorCode("TOUCHDOWN"); // Touchdown Reflector
	public static final ReflectorCode RUNWAY_END = new ReflectorCode("RUNWAY_END"); // Reflector placed off the end of the runway
	public static final ReflectorCode REFERENCE = new ReflectorCode("REFERENCE"); // Reference Reflector
	
	private String value;
	
	public ReflectorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ReflectorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
