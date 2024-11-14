package com.baesystems.environmentinfrastructure.types;

public class StatusServiceCode {
	// A coded list of values that indicate the operational capability of a service.
	public static final StatusServiceCode NORMAL = new StatusServiceCode("NORMAL"); // Normal operations.
	public static final StatusServiceCode LIMITED = new StatusServiceCode("LIMITED"); // Operating with limited capabilities.
	public static final StatusServiceCode ONTEST = new StatusServiceCode("ONTEST"); // On test, do not use.
	public static final StatusServiceCode UNSERVICEABLE = new StatusServiceCode("UNSERVICEABLE"); // Unserviceable (unavailable).
	
	private String value;
	
	public StatusServiceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof StatusServiceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
