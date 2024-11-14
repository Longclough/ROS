package com.baesystems.environmentinfrastructure.types;

public class UomLightIntensityCode {
	// A unit of measurement for light intensity.
	public static final UomLightIntensityCode CD = new UomLightIntensityCode("CD"); // Candela, the base unit of luminous intensity.
	
	private String value;
	
	public UomLightIntensityCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomLightIntensityCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
