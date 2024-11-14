package com.baesystems.environmentinfrastructure.types;

public class MissedApproachCode {
	// Types of missed approach.
	public static final MissedApproachCode PRIMARY = new MissedApproachCode("PRIMARY"); // The default missed approach.
	public static final MissedApproachCode SECONDARY = new MissedApproachCode("SECONDARY"); // An alternate missed approach to be used instead of primary.
	public static final MissedApproachCode ALTERNATE = new MissedApproachCode("ALTERNATE"); // A missed approach to be used when directed by ATC.
	public static final MissedApproachCode TACAN = new MissedApproachCode("TACAN"); // A missed approach to be used when using TACAN guidance.
	public static final MissedApproachCode TACANALT = new MissedApproachCode("TACANALT"); // An alternate missed approach to be used instead of TACAN missed approach when directed by ATC.
	public static final MissedApproachCode ENGINEOUT = new MissedApproachCode("ENGINEOUT"); // Missed Approach to be used when Engine Out
	
	private String value;
	
	public MissedApproachCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MissedApproachCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
