package com.baesystems.environmentinfrastructure.types;

public class ProcedureFixRoleCode {
	// A code indicating the role of a fix within an instrument approach procedure. Examples: initial approach fix, final approach fix, missed approach point, etc.
	public static final ProcedureFixRoleCode IAF = new ProcedureFixRoleCode("IAF"); // Initial approach fix.
	public static final ProcedureFixRoleCode IF = new ProcedureFixRoleCode("IF"); // Intermediate fix.
	public static final ProcedureFixRoleCode IF_IAF = new ProcedureFixRoleCode("IF_IAF"); // Intermediate Fix or an Initial Approach Fix
	public static final ProcedureFixRoleCode FAF = new ProcedureFixRoleCode("FAF"); // Final approach fix.
	public static final ProcedureFixRoleCode VDP = new ProcedureFixRoleCode("VDP"); // (FAA AIM) Visual descent point.   The VDP is a defined point on the final approach course of a non precision straight-in approach procedure from which normal descent from the MDA to the runway touchdown point may be commenced, provided visual reference required by 14 CFR Section 91.175(c)(3) is established.
	public static final ProcedureFixRoleCode SDF = new ProcedureFixRoleCode("SDF"); // Step down fix.
	public static final ProcedureFixRoleCode FPAP = new ProcedureFixRoleCode("FPAP"); // Flight Path Alignment Point.
	public static final ProcedureFixRoleCode FTP = new ProcedureFixRoleCode("FTP"); // Fictitious threshold point.  The equivalent of the landing threshold point (LTP) when the final approach course is offset from runway centreline. It is the intersection of the final course and a line perpendicular to the final course that passes through the LTP. Offset direction L/R distance from centreline
	public static final ProcedureFixRoleCode FROP = new ProcedureFixRoleCode("FROP"); // Final Rollout Point - Where a course change is required within the Final Approach Segment (FAS), the point that the aircraft rolls to a wings-level attitude aligned with the runway centreline extended is considered the FROP.FROP is used in an RNP-SAAAR procedure when a turn is required in the final between the FAF and the threshold.
	public static final ProcedureFixRoleCode TP = new ProcedureFixRoleCode("TP"); // Turn Point
	public static final ProcedureFixRoleCode MAPT = new ProcedureFixRoleCode("MAPT"); // Missed approach point.
	public static final ProcedureFixRoleCode MAHF = new ProcedureFixRoleCode("MAHF"); // Missed approach holding fix.
	
	private String value;
	
	public ProcedureFixRoleCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ProcedureFixRoleCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
