package com.baesystems.environmentinfrastructure.types;

public class VerticalReferenceCode {
	// A code indicating the reference for a vertical distance.Two series of values exist:1) real distance: from GND, from the MSL, from the WGS-84 ellipsoid;2) distance based on a difference of pressures, according to the standard atmosphere.
	public static final VerticalReferenceCode SFC = new VerticalReferenceCode("SFC"); // The distance measured from the surface of the Earth (equivalent to AGL - Above Ground Level).
	public static final VerticalReferenceCode MSL = new VerticalReferenceCode("MSL"); // The distance measured from mean sea level (equivalent to altitude).
	public static final VerticalReferenceCode W84 = new VerticalReferenceCode("W84"); // The distance measured from the WGS84 ellipsoid.
	public static final VerticalReferenceCode STD = new VerticalReferenceCode("STD"); // The vertical distance is measured with an altimeter set to the standard atmosphere.
	
	private String value;
	
	public VerticalReferenceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof VerticalReferenceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
