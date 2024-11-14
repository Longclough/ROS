package com.baesystems.environmentinfrastructure.types;

public class BearingCode {
	// A code indicating the type of angle: magnetic, bearing, VOR radial.
	public static final BearingCode TRUE = new BearingCode("TRUE"); // True bearing.
	public static final BearingCode MAG = new BearingCode("MAG"); // Magnetic bearing.
	public static final BearingCode RDL = new BearingCode("RDL"); // VOR radial.
	public static final BearingCode TRK = new BearingCode("TRK"); // Track
	public static final BearingCode HDG = new BearingCode("HDG"); // Heading.
	
	private String value;
	
	public BearingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof BearingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
