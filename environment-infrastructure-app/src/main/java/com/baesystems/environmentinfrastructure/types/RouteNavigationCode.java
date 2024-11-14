package com.baesystems.environmentinfrastructure.types;

public class RouteNavigationCode {
	// The type of the route from the navigation point of view. For example, conventional, RNAV, etc..
	public static final RouteNavigationCode CONV = new RouteNavigationCode("CONV"); // Conventional navigation route.
	public static final RouteNavigationCode RNAV = new RouteNavigationCode("RNAV"); // Area navigation route.
	public static final RouteNavigationCode TACAN = new RouteNavigationCode("TACAN"); // TACAN route.
	
	private String value;
	
	public RouteNavigationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RouteNavigationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
