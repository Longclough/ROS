package com.baesystems.environmentinfrastructure.types;

public class SpecialDateCode {
	// A code indicating the type of a special date, such as 'holiday', 'busy Friday', etc.
	public static final SpecialDateCode HOL = new SpecialDateCode("HOL"); // Legal holiday.
	public static final SpecialDateCode BUSY_FRI = new SpecialDateCode("BUSY_FRI"); // Busy Friday.  note: The main usage is related to conditional weekend routes, when early access is allowed on Friday these routes. Such 'busy Fridays' are typically declared in AIP Supplements.
	
	private String value;
	
	public SpecialDateCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SpecialDateCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
