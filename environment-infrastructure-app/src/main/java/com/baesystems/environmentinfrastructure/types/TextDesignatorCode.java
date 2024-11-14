package com.baesystems.environmentinfrastructure.types;

public class TextDesignatorCode {
	// A textual designator.
	
	private String value;
	
	public TextDesignatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TextDesignatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
