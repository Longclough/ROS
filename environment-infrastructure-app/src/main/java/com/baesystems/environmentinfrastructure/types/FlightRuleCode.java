package com.baesystems.environmentinfrastructure.types;

public class FlightRuleCode {
	// Flight rules to be observed by aircraft.For example, VFR and/or IFR.
	public static final FlightRuleCode IFR = new FlightRuleCode("IFR"); // Instrument flight rules (IFR)
	public static final FlightRuleCode VFR = new FlightRuleCode("VFR"); // Visual flight rules (VFR)
	public static final FlightRuleCode ALL = new FlightRuleCode("ALL"); // Both IFR and VFR.
	
	private String value;
	
	public FlightRuleCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FlightRuleCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
