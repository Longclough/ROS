package com.baesystems.environmentinfrastructure.types;

public class NorthReferenceCode {
	// A code indicating the type of the North reference used.
	public static final NorthReferenceCode TRUE = new NorthReferenceCode("TRUE"); // True north.
	public static final NorthReferenceCode MAG = new NorthReferenceCode("MAG"); // Magnetic north.
	public static final NorthReferenceCode GRID = new NorthReferenceCode("GRID"); // The direction of the north-south lines of the Universal Transverse Mercator (UTM) grid imposed on topographic maps by the United States and NATO.
	
	private String value;
	
	public NorthReferenceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NorthReferenceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
