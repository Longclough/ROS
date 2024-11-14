package com.baesystems.environmentinfrastructure.types;

public class RouteSegmentPathCode {
	// A code indicating the type of segment path.
	public static final RouteSegmentPathCode GRC = new RouteSegmentPathCode("GRC"); // Great circle.
	public static final RouteSegmentPathCode RHL = new RouteSegmentPathCode("RHL"); // Rhumb line.
	public static final RouteSegmentPathCode GDS = new RouteSegmentPathCode("GDS"); // Geodesic.
	
	private String value;
	
	public RouteSegmentPathCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RouteSegmentPathCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
