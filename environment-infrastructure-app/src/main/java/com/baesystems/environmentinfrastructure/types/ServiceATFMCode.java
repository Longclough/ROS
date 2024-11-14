package com.baesystems.environmentinfrastructure.types;

public class ServiceATFMCode {
	// A list of codes used to designate flight planning and air traffic flow management services.
	public static final ServiceATFMCode FPL = new ServiceATFMCode("FPL"); // A service that provides flight planning acceptance and distribution to the ATC Unites concerned. 
	public static final ServiceATFMCode FPLV = new ServiceATFMCode("FPLV"); // A service that provides flight planning validation.
	public static final ServiceATFMCode ATFM = new ServiceATFMCode("ATFM"); // Air traffic flow management service.
	public static final ServiceATFMCode CLEARANCE = new ServiceATFMCode("CLEARANCE"); // A service providing permissions (entry, landing, overflying, exit, etc.) for a given location.
	public static final ServiceATFMCode SCHED = new ServiceATFMCode("SCHED"); // Scheduling and slot allocation service.
	
	private String value;
	
	public ServiceATFMCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ServiceATFMCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
