package com.baesystems.environmentinfrastructure.types;

public class CommunicationChannelCode {
	// A codified value that indicates a pair of frequencies or a band used for radio communications.Note: unable yet to provide a list of values in the current version of the model.
	
	private String value;
	
	public CommunicationChannelCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof CommunicationChannelCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
