package com.baesystems.environmentinfrastructure.types;

public class ValLCNCode {
	// The value of a load classification number (LCN) for a surface.
	
	private String value;
	
	public ValLCNCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValLCNCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
