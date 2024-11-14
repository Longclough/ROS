package com.baesystems.environmentinfrastructure.types;

public class RunwayPointRoleCode {
	// Role of the Runway Centreline Point.
	public static final RunwayPointRoleCode START = new RunwayPointRoleCode("START"); // Physical start of a runway direction.
	public static final RunwayPointRoleCode THR = new RunwayPointRoleCode("THR"); // Threshold
	public static final RunwayPointRoleCode DISTHR = new RunwayPointRoleCode("DISTHR"); // Displaced threshold.
	public static final RunwayPointRoleCode TDZ = new RunwayPointRoleCode("TDZ"); // Touchdown Zone
	public static final RunwayPointRoleCode MID = new RunwayPointRoleCode("MID"); // The mid point of the runway
	public static final RunwayPointRoleCode END = new RunwayPointRoleCode("END"); // Physical end of a runway direction
	public static final RunwayPointRoleCode START_RUN = new RunwayPointRoleCode("START_RUN"); // Start of take off run
	public static final RunwayPointRoleCode LAHSO = new RunwayPointRoleCode("LAHSO"); // Point indicating Land And Hold Short Operation location
	public static final RunwayPointRoleCode ABEAM_GLIDESLOPE = new RunwayPointRoleCode("ABEAM_GLIDESLOPE"); // The point perpendicular to the Glideslope Antenna on the Runway Centreline.  Also known as the Aiming Point.
	public static final RunwayPointRoleCode ABEAM_PAR = new RunwayPointRoleCode("ABEAM_PAR"); // The point perpendicular to the Precision Approach Radar (PAR) Antenna on the Runway Centreline. 
	public static final RunwayPointRoleCode ABEAM_ELEVATION = new RunwayPointRoleCode("ABEAM_ELEVATION"); // The point perpendicular to the Elevation Antenna on the Runway Centreline. 
	public static final RunwayPointRoleCode ABEAM_TDR = new RunwayPointRoleCode("ABEAM_TDR"); // The point perpendicular to the Touchdown Reflector (TDR) on the Runway Centreline. 
	public static final RunwayPointRoleCode ABEAM_RER = new RunwayPointRoleCode("ABEAM_RER"); // The point perpendicular to the Runway End Reflector (RER) on the Runway Centreline. 
	
	private String value;
	
	public RunwayPointRoleCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RunwayPointRoleCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
