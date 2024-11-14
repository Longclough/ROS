package com.baesystems.environmentinfrastructure.types;

public class LanguageCode {
	// A 3-letter code indicating a language (according to ISO 639-2)
	
	private String value;
	
	public LanguageCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LanguageCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
