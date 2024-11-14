package com.baesystems.environmentinfrastructure.types;

public class FacilityRankingCode {
	// The order of priority of a facility, within a range of similar facilities. For example, "primary", "secondary" or "alternate".
	public static final FacilityRankingCode PRIMARY = new FacilityRankingCode("PRIMARY"); // Primary.
	public static final FacilityRankingCode SECONDARY = new FacilityRankingCode("SECONDARY"); // Secondary
	public static final FacilityRankingCode ALTERNATE = new FacilityRankingCode("ALTERNATE"); // Alternate
	public static final FacilityRankingCode EMERG = new FacilityRankingCode("EMERG"); // Emergency
	public static final FacilityRankingCode GUARD = new FacilityRankingCode("GUARD"); // Guarding
	
	private String value;
	
	public FacilityRankingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FacilityRankingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
