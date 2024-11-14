package com.baesystems.environmentinfrastructure.types;

public class VerticalDatumCode {
	// List of vertical datums.
	public static final VerticalDatumCode EGM_96 = new VerticalDatumCode("EGM_96"); // (ICAO Doc 9674) Earth gravitational model 1996.  ICAO recommended vertical datum.
	public static final VerticalDatumCode AHD = new VerticalDatumCode("AHD"); // Australian Height Datum
	public static final VerticalDatumCode NAVD88 = new VerticalDatumCode("NAVD88"); // North American Vertical Datum of 1988
	
	private String value;
	
	public VerticalDatumCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof VerticalDatumCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
