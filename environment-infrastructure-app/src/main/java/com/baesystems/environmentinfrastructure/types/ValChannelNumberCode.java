package com.baesystems.environmentinfrastructure.types;

public class ValChannelNumberCode {
	// The value of a GNSS channel.
	
	private String value;
	
	public ValChannelNumberCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValChannelNumberCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
