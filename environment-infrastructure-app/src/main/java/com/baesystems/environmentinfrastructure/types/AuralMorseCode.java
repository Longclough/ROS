package com.baesystems.environmentinfrastructure.types;

public class AuralMorseCode {
	// The sequence of dot/dash characters that corresponds to an aural Morse code.
	
	private String value;
	
	public AuralMorseCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AuralMorseCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
