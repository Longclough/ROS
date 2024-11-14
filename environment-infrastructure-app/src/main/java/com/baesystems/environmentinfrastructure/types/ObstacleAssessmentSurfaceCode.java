package com.baesystems.environmentinfrastructure.types;

public class ObstacleAssessmentSurfaceCode {
	// A code indicating the type of surface assessment.  Used for indicating assessment surfaces used in design and evaluation activities such as approach procedure design.
	public static final ObstacleAssessmentSurfaceCode _40_TO_1 = new ObstacleAssessmentSurfaceCode("40_TO_1"); // 40 to 1 sloped surface.
	public static final ObstacleAssessmentSurfaceCode _72_TO_1 = new ObstacleAssessmentSurfaceCode("72_TO_1"); // 72 to 1 sloped surface.
	public static final ObstacleAssessmentSurfaceCode MA = new ObstacleAssessmentSurfaceCode("MA"); // Missed approach area.
	public static final ObstacleAssessmentSurfaceCode FINAL = new ObstacleAssessmentSurfaceCode("FINAL"); // Final approach area.
	public static final ObstacleAssessmentSurfaceCode PT_ENTRY_AREA = new ObstacleAssessmentSurfaceCode("PT_ENTRY_AREA"); // Procedure turn entry area.
	public static final ObstacleAssessmentSurfaceCode PRIMARY = new ObstacleAssessmentSurfaceCode("PRIMARY"); // Primary area.
	public static final ObstacleAssessmentSurfaceCode SECONDARY = new ObstacleAssessmentSurfaceCode("SECONDARY"); // Secondary Area.
	public static final ObstacleAssessmentSurfaceCode ZONE1 = new ObstacleAssessmentSurfaceCode("ZONE1"); // Zone 1
	public static final ObstacleAssessmentSurfaceCode ZONE2 = new ObstacleAssessmentSurfaceCode("ZONE2"); // Zone 2
	public static final ObstacleAssessmentSurfaceCode ZONE3 = new ObstacleAssessmentSurfaceCode("ZONE3"); // Zone 3
	public static final ObstacleAssessmentSurfaceCode AREA1 = new ObstacleAssessmentSurfaceCode("AREA1"); // AREA 1
	public static final ObstacleAssessmentSurfaceCode AREA2 = new ObstacleAssessmentSurfaceCode("AREA2"); // AREA 2
	public static final ObstacleAssessmentSurfaceCode AREA3 = new ObstacleAssessmentSurfaceCode("AREA3"); // AREA 3
	public static final ObstacleAssessmentSurfaceCode TURN_INITIATION = new ObstacleAssessmentSurfaceCode("TURN_INITIATION"); //  
	public static final ObstacleAssessmentSurfaceCode TURN = new ObstacleAssessmentSurfaceCode("TURN"); //  
	public static final ObstacleAssessmentSurfaceCode DER = new ObstacleAssessmentSurfaceCode("DER"); // Departure End of Runway Area
	
	private String value;
	
	public ObstacleAssessmentSurfaceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ObstacleAssessmentSurfaceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
