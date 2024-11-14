package com.baesystems.environmentinfrastructure.types;

public class ValWeightCode {
	// The value of a weight.
	
	private String value;
	
	public ValWeightCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValWeightCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
