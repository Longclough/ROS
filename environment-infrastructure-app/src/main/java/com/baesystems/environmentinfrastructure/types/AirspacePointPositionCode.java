package com.baesystems.environmentinfrastructure.types;

public class AirspacePointPositionCode {
	// A code indicating the location of a significant point in relation to airspace.Description:Ex: In, Out, On Border.
	public static final AirspacePointPositionCode IN = new AirspacePointPositionCode("IN"); // Situated inside the airspace.
	public static final AirspacePointPositionCode OUT = new AirspacePointPositionCode("OUT"); // Situated outside the airspace.
	public static final AirspacePointPositionCode BORDER = new AirspacePointPositionCode("BORDER"); // Situated on the border of the airspace.
	
	private String value;
	
	public AirspacePointPositionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirspacePointPositionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
