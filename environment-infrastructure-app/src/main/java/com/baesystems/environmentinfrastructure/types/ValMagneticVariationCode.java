package com.baesystems.environmentinfrastructure.types;

public class ValMagneticVariationCode {
	// The value of an angle (at a given point) between the direction of Magnetic North and the direction of Geographical North. A positive value indicates that Magnetic North is East of Geographical North. A negative value indicates that Magnetic North is West of Geographical North.
	
	private String value;
	
	public ValMagneticVariationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValMagneticVariationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
