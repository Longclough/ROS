package com.baesystems.environmentinfrastructure.types;

public class StatusAirspaceCode {
	// A coded list of values indicating the activation status of an Airspace.
	public static final StatusAirspaceCode AVBL_FOR_ACTIVATION = new StatusAirspaceCode("AVBL_FOR_ACTIVATION"); // The feature may be activated.
	public static final StatusAirspaceCode ACTIVE = new StatusAirspaceCode("ACTIVE"); // The airspace is active (but it might not be in use yet).
	public static final StatusAirspaceCode IN_USE = new StatusAirspaceCode("IN_USE"); // The airspace is actually used inside the activation period.
	public static final StatusAirspaceCode INACTIVE = new StatusAirspaceCode("INACTIVE"); // The airspace is not active.
	public static final StatusAirspaceCode INTERMITTENT = new StatusAirspaceCode("INTERMITTENT"); // The Airspace is active but with periods of no real usage.
	
	private String value;
	
	public StatusAirspaceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof StatusAirspaceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
