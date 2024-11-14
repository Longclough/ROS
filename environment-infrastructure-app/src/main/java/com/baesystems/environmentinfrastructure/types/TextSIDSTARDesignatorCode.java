package com.baesystems.environmentinfrastructure.types;

public class TextSIDSTARDesignatorCode {
	// The textual designator of a SID, STAR or IAP (instrument approach procedure).
	
	private String value;
	
	public TextSIDSTARDesignatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TextSIDSTARDesignatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
