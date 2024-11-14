package com.baesystems.environmentinfrastructure.types;

public class RunwaySectionCode {
	// A code indicating the position of an item on a surface of a runway.Eg: THR, runway end, runway centre line, TDZ, etc.
	public static final RunwaySectionCode TDZ = new RunwaySectionCode("TDZ"); // Touch down zone.
	public static final RunwaySectionCode AIM = new RunwaySectionCode("AIM"); // Aiming point.
	public static final RunwaySectionCode CL = new RunwaySectionCode("CL"); // Centre line.
	public static final RunwaySectionCode EDGE = new RunwaySectionCode("EDGE"); // Edge.
	public static final RunwaySectionCode THR = new RunwaySectionCode("THR"); // Threshold.
	public static final RunwaySectionCode DESIG = new RunwaySectionCode("DESIG"); // Runway designation.
	public static final RunwaySectionCode AFT_THR = new RunwaySectionCode("AFT_THR"); // After threshold (for fixed distance markings.)
	public static final RunwaySectionCode DTHR = new RunwaySectionCode("DTHR"); // Displaced threshold.
	public static final RunwaySectionCode END = new RunwaySectionCode("END"); // Runway end.
	public static final RunwaySectionCode TWY_INT = new RunwaySectionCode("TWY_INT"); // Taxiway intersection.
	public static final RunwaySectionCode RPD_TWY_INT = new RunwaySectionCode("RPD_TWY_INT"); // Rapid taxiway intersection.
	public static final RunwaySectionCode _1_THIRD = new RunwaySectionCode("1_THIRD"); // The first third of the runway, starting from the threshold with the lower designation number.
	public static final RunwaySectionCode _2_THIRD = new RunwaySectionCode("2_THIRD"); // The second third of the runway, starting from the threshold with the lower designation number.
	public static final RunwaySectionCode _3_THIRD = new RunwaySectionCode("3_THIRD"); // The last third of the runway, starting from the threshold with the lower designation number.
	
	private String value;
	
	public RunwaySectionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RunwaySectionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
