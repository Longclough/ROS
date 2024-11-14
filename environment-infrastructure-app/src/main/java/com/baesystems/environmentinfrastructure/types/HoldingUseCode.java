package com.baesystems.environmentinfrastructure.types;

public class HoldingUseCode {
	// A code to identify the holding is used by a segment
	public static final HoldingUseCode PT = new HoldingUseCode("PT"); // The holding pattern is used as a procedure turn.  (Commonly referred to as Holding in Lieu of Procedure Turn.)
	public static final HoldingUseCode ARRIVAL = new HoldingUseCode("ARRIVAL"); // Arrival holding. A holding pattern provided at any Initial Approach Fix (IAF) and should be aligned with the initial segment track.
	public static final HoldingUseCode MISSED_APPROACH = new HoldingUseCode("MISSED_APPROACH"); // Missed Approach Holding. A holding pattern provided at the end of the missed approach 
	public static final HoldingUseCode CLIMB = new HoldingUseCode("CLIMB"); // A holding pattern used in conjunction with climb and hold instructions.
	public static final HoldingUseCode ATC = new HoldingUseCode("ATC"); // A holding pattern defined specifically for ATC use.
	
	private String value;
	
	public HoldingUseCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof HoldingUseCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
