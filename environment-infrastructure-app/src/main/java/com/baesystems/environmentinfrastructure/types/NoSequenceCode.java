package com.baesystems.environmentinfrastructure.types;

public class NoSequenceCode {
	// A sequence number
	
	private String value;
	
	public NoSequenceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NoSequenceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
