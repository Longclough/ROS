package com.baesystems.environmentinfrastructure.types;

public class ValPercentCode {
	// A numerical value between 0.0 and 100, which designates a part or portion considered in its quantitative relation to the whole.
	
	private String value;
	
	public ValPercentCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValPercentCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
