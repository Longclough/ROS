package com.baesystems.environmentinfrastructure.types;

public class RunwayProtectionAreaCode {
	// A code indicating the type of protection area for a runwayFor example, clearway, obstacle free zone, ILS protection area, etc..
	public static final RunwayProtectionAreaCode CWY = new RunwayProtectionAreaCode("CWY"); // Clearway.
	public static final RunwayProtectionAreaCode RESA = new RunwayProtectionAreaCode("RESA"); // Runway end safety area.
	public static final RunwayProtectionAreaCode OFZ = new RunwayProtectionAreaCode("OFZ"); // Obstacle free zone or surface
	public static final RunwayProtectionAreaCode IOFZ = new RunwayProtectionAreaCode("IOFZ"); // Inner Obstacle free zone or surface  
	public static final RunwayProtectionAreaCode POFZ = new RunwayProtectionAreaCode("POFZ"); // Precision Obstacle Free Zone
	public static final RunwayProtectionAreaCode ILS = new RunwayProtectionAreaCode("ILS"); // ILS protection area.  Protects ILS signal distortion by forbidding large objects in the area.
	public static final RunwayProtectionAreaCode VGSI = new RunwayProtectionAreaCode("VGSI"); // Visual Glide Slope Indicator (VGSI) protection area.  Protects VGSI signal coverage by forbidding objects in the area.
	public static final RunwayProtectionAreaCode STOPWAY = new RunwayProtectionAreaCode("STOPWAY"); // A defined rectangular area on the ground at the end of take-off run available prepared as a suitable area in which an aircraft can be stopped in the case of an abandoned take-off.
	
	private String value;
	
	public RunwayProtectionAreaCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RunwayProtectionAreaCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
