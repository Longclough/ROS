package com.baesystems.environmentinfrastructure.types;

public class NavigationAreaRestrictionCode {
	// Indicates the type of restricted area that aircraft should avoid
	public static final NavigationAreaRestrictionCode VECTOR = new NavigationAreaRestrictionCode("VECTOR"); // Vectoring area restriction
	public static final NavigationAreaRestrictionCode OMNIDIRECTIONAL = new NavigationAreaRestrictionCode("OMNIDIRECTIONAL"); // Omnidirectional departure restriction
	
	private String value;
	
	public NavigationAreaRestrictionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NavigationAreaRestrictionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
