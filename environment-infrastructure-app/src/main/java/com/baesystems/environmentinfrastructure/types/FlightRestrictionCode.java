package com.baesystems.environmentinfrastructure.types;

public class FlightRestrictionCode {
	// A code indicating if the restriction is an interdiction or a mandatory routing.
	public static final FlightRestrictionCode FORBID = new FlightRestrictionCode("FORBID"); // Forbidden
	public static final FlightRestrictionCode MANDATORY = new FlightRestrictionCode("MANDATORY"); // Mandatory.
	public static final FlightRestrictionCode CLSD = new FlightRestrictionCode("CLSD"); // Closed for cruising.[note: It is allowed to climb or descend through the levels associated with the restriction but it is not allowed to fly straight and level on the said levels, in any part of the route. .]  
	public static final FlightRestrictionCode ALLOWED = new FlightRestrictionCode("ALLOWED"); // Flight that comply with the condition are explicitly permitted to use the associated routings, even if other more general flight restrictions forbid the routings (for the same flight conditions).
	
	private String value;
	
	public FlightRestrictionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FlightRestrictionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
