package com.baesystems.environmentinfrastructure.types;

public class FrictionEstimateCode {
	// An enumeration of qualitative estimates of the friction on a movement area.
	public static final FrictionEstimateCode GOOD = new FrictionEstimateCode("GOOD"); // Good.
	public static final FrictionEstimateCode MEDIUM_GOOD = new FrictionEstimateCode("MEDIUM_GOOD"); // Medium to good.
	public static final FrictionEstimateCode MEDIUM = new FrictionEstimateCode("MEDIUM"); // Medium.
	public static final FrictionEstimateCode MEDIUM_POOR = new FrictionEstimateCode("MEDIUM_POOR"); // Medium to poor.
	public static final FrictionEstimateCode POOR = new FrictionEstimateCode("POOR"); // Poor.
	public static final FrictionEstimateCode UNRELIABLE = new FrictionEstimateCode("UNRELIABLE"); // The surface conditions or available friction measuring device do not permit a reliable surface friction measurement to be made.
	
	private String value;
	
	public FrictionEstimateCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FrictionEstimateCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
