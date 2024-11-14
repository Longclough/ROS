package com.baesystems.environmentinfrastructure.types;

public class ValFrequencyCode {
	// The frequency value of a navigation system.
	
	private String value;
	
	public ValFrequencyCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValFrequencyCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
