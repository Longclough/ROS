package com.baesystems.environmentinfrastructure.types;

public class UomDepthCode {
	// Unit of measurement for depth.
	public static final UomDepthCode MM = new UomDepthCode("MM"); // Millimetre.
	public static final UomDepthCode CM = new UomDepthCode("CM"); // Centimetre.
	public static final UomDepthCode IN = new UomDepthCode("IN"); // Inches.
	public static final UomDepthCode FT = new UomDepthCode("FT"); // Feet.
	
	private String value;
	
	public UomDepthCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomDepthCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
