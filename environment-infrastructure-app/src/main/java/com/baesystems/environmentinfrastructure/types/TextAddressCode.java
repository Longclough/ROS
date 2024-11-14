package com.baesystems.environmentinfrastructure.types;

public class TextAddressCode {
	// A full free text address.For example, +32(2)-729 3326, edgr@eurocontrol.be, LABBYOYX, etc..
	
	private String value;
	
	public TextAddressCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TextAddressCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
