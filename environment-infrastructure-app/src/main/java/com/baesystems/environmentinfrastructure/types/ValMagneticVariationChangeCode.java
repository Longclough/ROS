package com.baesystems.environmentinfrastructure.types;

public class ValMagneticVariationChangeCode {
	// The value of the annual rate of change of the magnetic variation. The unit of measurement would be degrees/year and can be positive or negative, i.e qualified by EAST (E) or WEST (W).
	
	private String value;
	
	public ValMagneticVariationChangeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValMagneticVariationChangeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
