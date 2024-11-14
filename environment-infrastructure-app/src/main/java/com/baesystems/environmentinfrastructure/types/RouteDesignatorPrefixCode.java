package com.baesystems.environmentinfrastructure.types;

public class RouteDesignatorPrefixCode {
	// (ICAO) A prefix for route designators.Note: Includes a non-ICAO value, used for military TACAN routes.
	public static final RouteDesignatorPrefixCode K = new RouteDesignatorPrefixCode("K"); // Helicopter
	public static final RouteDesignatorPrefixCode U = new RouteDesignatorPrefixCode("U"); // Upper
	public static final RouteDesignatorPrefixCode S = new RouteDesignatorPrefixCode("S"); // Supersonic
	public static final RouteDesignatorPrefixCode T = new RouteDesignatorPrefixCode("T"); // TACAN Route (military)
	
	private String value;
	
	public RouteDesignatorPrefixCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RouteDesignatorPrefixCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
