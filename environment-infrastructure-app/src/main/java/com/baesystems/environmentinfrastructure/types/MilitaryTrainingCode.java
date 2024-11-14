package com.baesystems.environmentinfrastructure.types;

public class MilitaryTrainingCode {
	// A code indicating the type of flying on a military training route.
	public static final MilitaryTrainingCode IR = new MilitaryTrainingCode("IR"); // IFR Training route
	public static final MilitaryTrainingCode VR = new MilitaryTrainingCode("VR"); // VFR Training Route
	public static final MilitaryTrainingCode SR = new MilitaryTrainingCode("SR"); // Slow Speed Low Altitude Training Route
	
	private String value;
	
	public MilitaryTrainingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MilitaryTrainingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
