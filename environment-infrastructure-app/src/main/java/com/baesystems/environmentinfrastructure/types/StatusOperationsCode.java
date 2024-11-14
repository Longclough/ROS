package com.baesystems.environmentinfrastructure.types;

public class StatusOperationsCode {
	// Code indicating operational status.
	public static final StatusOperationsCode NORMAL = new StatusOperationsCode("NORMAL"); // Normal operations.
	public static final StatusOperationsCode DOWNGRADED = new StatusOperationsCode("DOWNGRADED"); // The system is theoretically able to work at a higher level of service, but it is currently limited to the level described.
	public static final StatusOperationsCode UNSERVICEABLE = new StatusOperationsCode("UNSERVICEABLE"); // Operation is unserviceable (unavailable).
	public static final StatusOperationsCode WORK_IN_PROGRESS = new StatusOperationsCode("WORK_IN_PROGRESS"); // Operation is under construction.
	
	private String value;
	
	public StatusOperationsCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof StatusOperationsCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
