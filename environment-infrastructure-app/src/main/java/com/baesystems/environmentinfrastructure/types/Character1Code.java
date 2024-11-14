package com.baesystems.environmentinfrastructure.types;

public class Character1Code {
	// A string of Simple Latin upper case letters and/or digits and/or a few special characters (space,  plus sign, minus sign, solidus -'/').
	
	private String value;
	
	public Character1Code(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Character1Code) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
