package com.baesystems.environmentinfrastructure.types;

public class RVRReadingCode {
	// A code indicating the position where the RVR reading is reported.
	public static final RVRReadingCode TDZ = new RVRReadingCode("TDZ"); // Touchdown
	public static final RVRReadingCode MID = new RVRReadingCode("MID"); // Middle or centre of runway
	public static final RVRReadingCode TO = new RVRReadingCode("TO"); // Takeoff or rollout point.
	
	private String value;
	
	public RVRReadingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RVRReadingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
