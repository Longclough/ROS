package com.baesystems.environmentinfrastructure.types;

public class HoldingUsageCode {
	// A code indicating the type of holding procedure.For example, en-route holding, terminal area holding.
	public static final HoldingUsageCode ENR = new HoldingUsageCode("ENR"); // En-route holding.
	public static final HoldingUsageCode TER = new HoldingUsageCode("TER"); // Terminal area holding.
	
	private String value;
	
	public HoldingUsageCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof HoldingUsageCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
