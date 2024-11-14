package com.baesystems.environmentinfrastructure.types;

public class ValHexCode {
	// A hexadecimal value x ('00000000' LE x LE 'FFFFFFFF').
	
	private String value;
	
	public ValHexCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValHexCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
