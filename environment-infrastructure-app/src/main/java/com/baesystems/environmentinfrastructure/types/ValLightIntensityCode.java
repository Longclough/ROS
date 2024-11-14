package com.baesystems.environmentinfrastructure.types;

public class ValLightIntensityCode {
	// The luminous intensity of a light source. It is a measure of the wavelength-weighted power emitted by a light source in a particular direction.
	
	private String value;
	
	public ValLightIntensityCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValLightIntensityCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
