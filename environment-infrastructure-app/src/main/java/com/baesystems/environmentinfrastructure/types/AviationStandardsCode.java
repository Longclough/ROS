package com.baesystems.environmentinfrastructure.types;

public class AviationStandardsCode {
	// A code indicating the standard referred to by a list of values, in case where different aviation authorities use different categorisation criteria.
	public static final AviationStandardsCode ICAO = new AviationStandardsCode("ICAO"); // The values refer to ICAO standards.
	public static final AviationStandardsCode IATA = new AviationStandardsCode("IATA"); // The values refer to IATA standards.
	public static final AviationStandardsCode NATO = new AviationStandardsCode("NATO"); // The values refer to NATO military standards.
	public static final AviationStandardsCode FAA = new AviationStandardsCode("FAA"); // The values refer to US FAA standards.
	
	private String value;
	
	public AviationStandardsCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AviationStandardsCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
