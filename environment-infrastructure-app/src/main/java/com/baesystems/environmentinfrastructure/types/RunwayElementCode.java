package com.baesystems.environmentinfrastructure.types;

public class RunwayElementCode {
	// A code indicating the type of Runway or Taxiway element.
	public static final RunwayElementCode NORMAL = new RunwayElementCode("NORMAL"); // The default type.
	public static final RunwayElementCode INTERSECTION = new RunwayElementCode("INTERSECTION"); // Intersection element - with a runway or with a taxiway.
	public static final RunwayElementCode DISPLACED = new RunwayElementCode("DISPLACED"); // The element between the start of the runway and the position of the displaced threshold.
	public static final RunwayElementCode SHOULDER = new RunwayElementCode("SHOULDER"); // Runway or taxiway shoulder element.
	
	private String value;
	
	public RunwayElementCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RunwayElementCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
