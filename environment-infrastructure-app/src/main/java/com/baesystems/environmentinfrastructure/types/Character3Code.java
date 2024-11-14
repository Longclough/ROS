package com.baesystems.environmentinfrastructure.types;

public class Character3Code {
	// A string of Simple Latin upper case letters and/or digits and/or more special characters (space| exclamation mark| double quote| number sign| dollar sign| percent| ampersand| quote| left paren| right paren| asterisk| plus sign| comma| minus sign| period| solidus| colon| semicolon| less than operator| equals operator| greater than operator| question mark| commercial at| left bracket| reverse solidus| right bracket| circumflex| underscore| vertical bar| left brace| right brace).
	
	private String value;
	
	public Character3Code(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Character3Code) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
