package com.baesystems.environmentinfrastructure.types;

public class IntensityStandByCode {
	// Enumeration to indicate the intensity level of the lighting when not in use.
	public static final IntensityStandByCode OFF = new IntensityStandByCode("OFF"); // Off
	public static final IntensityStandByCode LOW = new IntensityStandByCode("LOW"); // Low
	
	private String value;
	
	public IntensityStandByCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof IntensityStandByCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
