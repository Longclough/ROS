package com.baesystems.environmentinfrastructure.types;

public class ApproachPrefixCode {
	// Code indicating the prefix used in support of current approach procedure naming conventions
	public static final ApproachPrefixCode HI = new ApproachPrefixCode("HI"); // Approach procedures with segments such as a high altitude teardrop penetration that are within the high airspace stratum, requested by Military.  Normally C, D and E Minimums only.
	public static final ApproachPrefixCode COPTER = new ApproachPrefixCode("COPTER"); // Indicates helicopter approach
	public static final ApproachPrefixCode CONVERGING = new ApproachPrefixCode("CONVERGING"); // Parallel or joining operation with parallel or joining ILS courses
	
	private String value;
	
	public ApproachPrefixCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ApproachPrefixCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
