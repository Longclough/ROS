package com.baesystems.environmentinfrastructure.types;

public class ProcedureAvailabilityCode {
	// A code indicating the availability of a procedure for use.
	public static final ProcedureAvailabilityCode USABLE = new ProcedureAvailabilityCode("USABLE"); // The procedure may be flown according to its timetable. Is active and can be used.
	public static final ProcedureAvailabilityCode UNUSABLE = new ProcedureAvailabilityCode("UNUSABLE"); // Temporarily suspended because, for example, a temporary obstacle makes the procedure unsafe
	
	private String value;
	
	public ProcedureAvailabilityCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ProcedureAvailabilityCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
