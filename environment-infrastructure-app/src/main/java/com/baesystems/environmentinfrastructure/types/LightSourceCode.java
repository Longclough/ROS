package com.baesystems.environmentinfrastructure.types;

public class LightSourceCode {
	// A code indicating a type of light source, such as strobe or flood.
	public static final LightSourceCode FLOOD = new LightSourceCode("FLOOD"); // Flood light.[note: This indicates that the light source contains a large powerful lamp that produces a strong broad beam of artificial light and is used to illuminate the outside at night. .]  
	public static final LightSourceCode STROBE = new LightSourceCode("STROBE"); // Strobe light.[note: This indicates that the light source contains a high intensity flashing beam of light produced by charging a capacitor to a very high voltage then discharging it as a high-intensity flash of light in a tube. .]  
	
	private String value;
	
	public LightSourceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LightSourceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
