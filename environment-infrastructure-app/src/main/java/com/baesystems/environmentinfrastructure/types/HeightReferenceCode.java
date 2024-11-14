package com.baesystems.environmentinfrastructure.types;

public class HeightReferenceCode {
	// A code indicating the reference surface for a height value, especially for approach procedures related heights.
	public static final HeightReferenceCode HAT = new HeightReferenceCode("HAT"); // Height above threshold.
	public static final HeightReferenceCode HAA = new HeightReferenceCode("HAA"); // Height above airport.
	public static final HeightReferenceCode HAL = new HeightReferenceCode("HAL"); // Height above landing (for helicopters).
	public static final HeightReferenceCode HAS = new HeightReferenceCode("HAS"); // Height above surface (for a point in space).
	
	private String value;
	
	public HeightReferenceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof HeightReferenceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
