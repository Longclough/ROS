package com.baesystems.environmentinfrastructure.types;

public class DesignatedPointCode {
	// A code indicating a specific type of designated point, in direct relation with the designator allocated to that point.
	public static final DesignatedPointCode ICAO = new DesignatedPointCode("ICAO"); // ICAO 5 letter name code designator.
	public static final DesignatedPointCode COORD = new DesignatedPointCode("COORD"); // Point with identifier derived from its geographical coordinates.
	public static final DesignatedPointCode CNF = new DesignatedPointCode("CNF"); // Computer Navigation Fix - A point used for the purpose of defining the navigation track for an airborne computer system (i.e., GPS or FMS). CNFs include unnamed DME fixes, beginning and ending points of DME arcs and sensor final approach fixes (FAFs) on some GPS overlay approaches.
	public static final DesignatedPointCode DESIGNED = new DesignatedPointCode("DESIGNED"); // A point with bearing/distance designator used as control point for procedure design, which is not published.
	public static final DesignatedPointCode MTR = new DesignatedPointCode("MTR"); // Point used on a military training route.
	public static final DesignatedPointCode TERMINAL = new DesignatedPointCode("TERMINAL"); // Point with a five-alphanumeric name-code, used as waypoint in RNAV procedures and which does not have a globally unique ICAO 5-letter designator.
	public static final DesignatedPointCode BRG_DIST = new DesignatedPointCode("BRG_DIST"); // Point with a five-alphanumeric name-code, composed according to the rules provided by the ARINC 424 Specification for unnamed bearing/distance reference waypoints.
	
	public static final DesignatedPointCode VRP = new DesignatedPointCode("VRP");
	
	private String value;
	
	public DesignatedPointCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DesignatedPointCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
