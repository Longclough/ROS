package com.baesystems.environmentinfrastructure.types;

public class ApproachGuidanceCode {
	// Degree to which navigation aids provide accurate approach guidance.  Precision approaches utilize both lateral (course) and vertical (glideslope) information
	public static final ApproachGuidanceCode NON_PRECISION = new ApproachGuidanceCode("NON_PRECISION"); // Non-precision approach runway
	public static final ApproachGuidanceCode ILS_PRECISION_CAT_I = new ApproachGuidanceCode("ILS_PRECISION_CAT_I"); //  ILS precision approach runway, category I
	public static final ApproachGuidanceCode ILS_PRECISION_CAT_II = new ApproachGuidanceCode("ILS_PRECISION_CAT_II"); // ILS precision approach runway, category II
	public static final ApproachGuidanceCode ILS_PRECISION_CAT_IIIA = new ApproachGuidanceCode("ILS_PRECISION_CAT_IIIA"); // ILS precision approach runway category III A
	public static final ApproachGuidanceCode ILS_PRECISION_CAT_IIIB = new ApproachGuidanceCode("ILS_PRECISION_CAT_IIIB"); // ILS precision approach runway category III B
	public static final ApproachGuidanceCode ILS_PRECISION_CAT_IIIC = new ApproachGuidanceCode("ILS_PRECISION_CAT_IIIC"); // ILS precision approach runway category III C
	public static final ApproachGuidanceCode ILS_PRECISION_CAT_IIID = new ApproachGuidanceCode("ILS_PRECISION_CAT_IIID"); // ILS precision approach runway category III D
	public static final ApproachGuidanceCode MLS_PRECISION = new ApproachGuidanceCode("MLS_PRECISION"); // Microwave landing system precision approach
	
	private String value;
	
	public ApproachGuidanceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ApproachGuidanceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
