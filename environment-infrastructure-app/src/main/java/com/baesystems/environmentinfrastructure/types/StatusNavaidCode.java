package com.baesystems.environmentinfrastructure.types;

public class StatusNavaidCode {
	// The operational status of a Navaid or NavaidEquipment
	public static final StatusNavaidCode OPERATIONAL = new StatusNavaidCode("OPERATIONAL"); // Operating normally.
	public static final StatusNavaidCode UNSERVICEABLE = new StatusNavaidCode("UNSERVICEABLE"); // Not available.
	public static final StatusNavaidCode ONTEST = new StatusNavaidCode("ONTEST"); // On test, do not use.
	public static final StatusNavaidCode INTERRUPT = new StatusNavaidCode("INTERRUPT"); // Expect interruptions of the signal.
	public static final StatusNavaidCode PARTIAL = new StatusNavaidCode("PARTIAL"); // Operating with limited capabilities. For example, used when just the DME part of a VOR/DME is working.
	public static final StatusNavaidCode CONDITIONAL = new StatusNavaidCode("CONDITIONAL"); // Operative subject to published limitations or conditions.
	public static final StatusNavaidCode FALSE_INDICATION = new StatusNavaidCode("FALSE_INDICATION"); // Giving false indication, do not use.
	public static final StatusNavaidCode FALSE_POSSIBLE = new StatusNavaidCode("FALSE_POSSIBLE"); // False indication possible, use with caution.
	public static final StatusNavaidCode DISPLACED = new StatusNavaidCode("DISPLACED"); // Displaced
	public static final StatusNavaidCode IN_CONSTRUCTION = new StatusNavaidCode("IN_CONSTRUCTION"); // In Construction
	
	private String value;
	
	public StatusNavaidCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof StatusNavaidCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
