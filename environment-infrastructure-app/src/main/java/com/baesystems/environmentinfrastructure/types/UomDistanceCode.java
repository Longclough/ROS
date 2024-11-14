package com.baesystems.environmentinfrastructure.types;

public class UomDistanceCode {
	// A unit of measurement for a horizontal distance.For example, metres, feet, nautical miles, kilometres, etc...
	public static final UomDistanceCode NM = new UomDistanceCode("NM"); // Nautical miles.
	public static final UomDistanceCode KM = new UomDistanceCode("KM"); // Kilometres.
	public static final UomDistanceCode M = new UomDistanceCode("M"); // Metres.
	public static final UomDistanceCode FT = new UomDistanceCode("FT"); // Feet.
	public static final UomDistanceCode MI = new UomDistanceCode("MI"); // Statute Mile
	public static final UomDistanceCode CM = new UomDistanceCode("CM"); // Centimetre.
	
	private String value;
	
	public UomDistanceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomDistanceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
