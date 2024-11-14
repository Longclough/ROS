package com.baesystems.environmentinfrastructure.types;

public class TextInstructionCode {
	// A textual description of a sequence of elementary steps.
	
	private String value;
	
	public TextInstructionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TextInstructionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
