package com.baesystems.environmentinfrastructure.types;

public class NavigationAreaCode {
	// code indicating the type of navigation area
	public static final NavigationAreaCode PNA = new NavigationAreaCode("PNA"); // Pilot Navigation Area
	public static final NavigationAreaCode OMNI = new NavigationAreaCode("OMNI"); // Omnidirectional area
	public static final NavigationAreaCode DVA = new NavigationAreaCode("DVA"); // Diverse Vector Area
	
	private String value;
	
	public NavigationAreaCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NavigationAreaCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
