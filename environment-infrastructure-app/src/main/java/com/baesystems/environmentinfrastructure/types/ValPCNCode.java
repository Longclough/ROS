package com.baesystems.environmentinfrastructure.types;

public class ValPCNCode {
	// The value of a pavement classification number (PCN) for a surface.
	
	private String value;
	
	public ValPCNCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValPCNCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
