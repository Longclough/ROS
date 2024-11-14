package com.baesystems.environmentinfrastructure.types;

public class RouteDesignatorLetterCode {
	// (ICAO) A one character designator for the route.
	public static final RouteDesignatorLetterCode A = new RouteDesignatorLetterCode("A"); // null
	public static final RouteDesignatorLetterCode B = new RouteDesignatorLetterCode("B"); // null
	public static final RouteDesignatorLetterCode G = new RouteDesignatorLetterCode("G"); // null
	public static final RouteDesignatorLetterCode H = new RouteDesignatorLetterCode("H"); // null
	public static final RouteDesignatorLetterCode J = new RouteDesignatorLetterCode("J"); // null
	public static final RouteDesignatorLetterCode L = new RouteDesignatorLetterCode("L"); // null
	public static final RouteDesignatorLetterCode M = new RouteDesignatorLetterCode("M"); // null
	public static final RouteDesignatorLetterCode N = new RouteDesignatorLetterCode("N"); // null
	public static final RouteDesignatorLetterCode P = new RouteDesignatorLetterCode("P"); // null
	public static final RouteDesignatorLetterCode Q = new RouteDesignatorLetterCode("Q"); // null
	public static final RouteDesignatorLetterCode R = new RouteDesignatorLetterCode("R"); // null
	public static final RouteDesignatorLetterCode T = new RouteDesignatorLetterCode("T"); // null
	public static final RouteDesignatorLetterCode V = new RouteDesignatorLetterCode("V"); // null
	public static final RouteDesignatorLetterCode W = new RouteDesignatorLetterCode("W"); // null
	public static final RouteDesignatorLetterCode Y = new RouteDesignatorLetterCode("Y"); // null
	public static final RouteDesignatorLetterCode Z = new RouteDesignatorLetterCode("Z"); // null
	
	private String value;
	
	public RouteDesignatorLetterCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RouteDesignatorLetterCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
