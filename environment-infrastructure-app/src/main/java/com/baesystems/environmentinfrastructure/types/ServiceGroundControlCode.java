package com.baesystems.environmentinfrastructure.types;

public class ServiceGroundControlCode {
	// A code indicating the type of ground traffic control service.
	public static final ServiceGroundControlCode TWR = new ServiceGroundControlCode("TWR"); // Aerodrome control tower service.
	public static final ServiceGroundControlCode SMGCS = new ServiceGroundControlCode("SMGCS"); // Surface movement control service.
	public static final ServiceGroundControlCode TAXI = new ServiceGroundControlCode("TAXI"); // Taxi clearance service.
	
	private String value;
	
	public ServiceGroundControlCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ServiceGroundControlCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
