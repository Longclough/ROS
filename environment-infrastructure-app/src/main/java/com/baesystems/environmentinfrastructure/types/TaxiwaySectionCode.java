package com.baesystems.environmentinfrastructure.types;

public class TaxiwaySectionCode {
	// A code indicating the position of an item on the surface of a taxiway.
	public static final TaxiwaySectionCode CL = new TaxiwaySectionCode("CL"); // Centre line.
	public static final TaxiwaySectionCode EDGE = new TaxiwaySectionCode("EDGE"); // Edge.
	public static final TaxiwaySectionCode END = new TaxiwaySectionCode("END"); // Taxiway end.
	public static final TaxiwaySectionCode RWY_INT = new TaxiwaySectionCode("RWY_INT"); // Runway intersections.
	public static final TaxiwaySectionCode TWY_INT = new TaxiwaySectionCode("TWY_INT"); // Taxiway intersections.
	
	private String value;
	
	public TaxiwaySectionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TaxiwaySectionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
