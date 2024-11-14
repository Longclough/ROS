package com.baesystems.environmentinfrastructure.types;

public class DistanceIndicationCode {
	// Coding indicating the type of distance indication.
	public static final DistanceIndicationCode DME = new DistanceIndicationCode("DME"); // Distance provided by DME indication.
	public static final DistanceIndicationCode GEODETIC = new DistanceIndicationCode("GEODETIC"); // Distance calculated using geodetic calculations.
	
	private String value;
	
	public DistanceIndicationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DistanceIndicationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
