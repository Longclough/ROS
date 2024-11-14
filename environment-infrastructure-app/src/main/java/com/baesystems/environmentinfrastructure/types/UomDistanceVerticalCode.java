package com.baesystems.environmentinfrastructure.types;

public class UomDistanceVerticalCode {
	// A unit of measurement for a vertical distance.For example, Flight Level, metres, feet.
	public static final UomDistanceVerticalCode FT = new UomDistanceVerticalCode("FT"); // Feet.
	public static final UomDistanceVerticalCode M = new UomDistanceVerticalCode("M"); // Meters.
	public static final UomDistanceVerticalCode FL = new UomDistanceVerticalCode("FL"); // Flight level in hundreds of feet.
	public static final UomDistanceVerticalCode SM = new UomDistanceVerticalCode("SM"); // Standard meters (tens of meters).
	
	private String value;
	
	public UomDistanceVerticalCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomDistanceVerticalCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
