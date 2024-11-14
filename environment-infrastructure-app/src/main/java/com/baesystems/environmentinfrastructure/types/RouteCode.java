package com.baesystems.environmentinfrastructure.types;

public class RouteCode {
	// The route classification as ATS route or North Atlantic Tracks.
	public static final RouteCode ATS = new RouteCode("ATS"); // ATS Route as described in ICAO Annex 11.
	public static final RouteCode NAT = new RouteCode("NAT"); // North Atlantic Track (part of Organized Track System)
	
	private String value;
	
	public RouteCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RouteCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
