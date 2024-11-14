package com.baesystems.environmentinfrastructure.types;

public class UomFLCode {
	// Unit of measurement for flight levels.
	public static final UomFLCode FL = new UomFLCode("FL"); // Flight level in hundreds of feet.
	public static final UomFLCode SM = new UomFLCode("SM"); // Standard meters (tens of meters).
	
	private String value;
	
	public UomFLCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomFLCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
