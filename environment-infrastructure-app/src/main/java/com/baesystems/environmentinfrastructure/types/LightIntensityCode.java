package com.baesystems.environmentinfrastructure.types;

public class LightIntensityCode {
	// A code indicating the intensity level of a light source.For example, LIL, LIM, LIH, etc.
	public static final LightIntensityCode LIL = new LightIntensityCode("LIL"); // Light intensity low.
	public static final LightIntensityCode LIM = new LightIntensityCode("LIM"); // Light intensity medium.
	public static final LightIntensityCode LIH = new LightIntensityCode("LIH"); // Light intensity high.
	public static final LightIntensityCode LIL_LIH = new LightIntensityCode("LIL_LIH"); // Low intensity for night use; high intensity for day use, as determined by a photo-cell.
	public static final LightIntensityCode PREDETERMINED = new LightIntensityCode("PREDETERMINED"); // A predetermined intensity step, in the approach lighting system that takes precedence for air-to-ground radio control over the runway lighting system which is set, based on expected visibility conditions.
	
	private String value;
	
	public LightIntensityCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LightIntensityCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
