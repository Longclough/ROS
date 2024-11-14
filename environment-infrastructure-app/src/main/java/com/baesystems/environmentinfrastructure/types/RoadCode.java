package com.baesystems.environmentinfrastructure.types;

public class RoadCode {
	// A code indicating the type of a road.
	public static final RoadCode SERVICE = new RoadCode("SERVICE"); // Service road
	public static final RoadCode PUBLIC = new RoadCode("PUBLIC"); // Public road
	
	private String value;
	
	public RoadCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RoadCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
