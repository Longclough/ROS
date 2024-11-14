package com.baesystems.environmentinfrastructure.types;

public class RouteOriginCode {
	// Code indicating if a route is international or domestic.
	public static final RouteOriginCode INTL = new RouteOriginCode("INTL"); // International.
	public static final RouteOriginCode DOM = new RouteOriginCode("DOM"); // Domestic.
	public static final RouteOriginCode BOTH = new RouteOriginCode("BOTH"); // BOTH
	
	private String value;
	
	public RouteOriginCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RouteOriginCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
