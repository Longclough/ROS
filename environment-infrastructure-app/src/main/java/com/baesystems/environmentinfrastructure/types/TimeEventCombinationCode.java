package com.baesystems.environmentinfrastructure.types;

public class TimeEventCombinationCode {
	// A code indicating which event in a list of events in time should be given precedence over the others. E.g. the earliest or the latest.
	public static final TimeEventCombinationCode EARLIEST = new TimeEventCombinationCode("EARLIEST"); // Earliest.
	public static final TimeEventCombinationCode LATEST = new TimeEventCombinationCode("LATEST"); // Latest.
	
	private String value;
	
	public TimeEventCombinationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TimeEventCombinationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
