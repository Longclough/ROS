package com.baesystems.environmentinfrastructure.types;

public class RouteDesignatorSuffixCode {
	// (ICAO) A suffix for the route designator.
	public static final RouteDesignatorSuffixCode F = new RouteDesignatorSuffixCode("F"); // (ICAO) Advisory service only is provided on a portion of the route.
	public static final RouteDesignatorSuffixCode G = new RouteDesignatorSuffixCode("G"); // (ICAO) Flight information service only on a portion of the route.
	
	private String value;
	
	public RouteDesignatorSuffixCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RouteDesignatorSuffixCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
