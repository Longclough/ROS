package com.baesystems.environmentinfrastructure.types;

public class YesNoCode {
	// A code for a logical value: Yes or No.
	public static final YesNoCode YES = new YesNoCode("YES"); // Yes.
	public static final YesNoCode NO = new YesNoCode("NO"); // No.
	
	private String value;
	
	public YesNoCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof YesNoCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
