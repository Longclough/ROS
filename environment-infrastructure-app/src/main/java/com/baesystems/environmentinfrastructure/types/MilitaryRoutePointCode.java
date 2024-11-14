package com.baesystems.environmentinfrastructure.types;

public class MilitaryRoutePointCode {
	// A code indicating the usage of a point on a military training route.
	public static final MilitaryRoutePointCode S = new MilitaryRoutePointCode("S"); // Entry Point (Starting Point)
	public static final MilitaryRoutePointCode T = new MilitaryRoutePointCode("T"); // Turning Point
	public static final MilitaryRoutePointCode X = new MilitaryRoutePointCode("X"); // Exit Point (Ending Point)
	public static final MilitaryRoutePointCode AS = new MilitaryRoutePointCode("AS"); // Alternate Entry Point
	public static final MilitaryRoutePointCode AX = new MilitaryRoutePointCode("AX"); // Alternate Exit Point
	public static final MilitaryRoutePointCode ASX = new MilitaryRoutePointCode("ASX"); // Alternate Entry/Exit Point
	
	private String value;
	
	public MilitaryRoutePointCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MilitaryRoutePointCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
