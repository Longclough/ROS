package com.baesystems.environmentinfrastructure.types;

public class ValDurationCode {
	// A duration value or elapsed time period.  E.g. 5 minutes, 200 seconds, etc..
	
	private String value;
	
	public ValDurationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValDurationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
