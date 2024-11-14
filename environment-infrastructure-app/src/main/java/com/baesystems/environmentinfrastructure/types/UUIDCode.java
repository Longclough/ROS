package com.baesystems.environmentinfrastructure.types;

public class UUIDCode {
	// A Universal Unique Identifier (UUID).
	
	private String value;
	
	public UUIDCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UUIDCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
