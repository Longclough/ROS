package com.baesystems.environmentinfrastructure.types;

public class RadioFrequencyAreaCode {
	// A code indicating the type of radio navigation aid limitation.
	public static final RadioFrequencyAreaCode COV = new RadioFrequencyAreaCode("COV"); // Actual coverage range (flight checked).  Equivalent to Operational Service Volume.
	public static final RadioFrequencyAreaCode T_COV = new RadioFrequencyAreaCode("T_COV"); // Theoretical coverage range (not flight checked). Equivalent to Standard Service Volume.
	public static final RadioFrequencyAreaCode SCL = new RadioFrequencyAreaCode("SCL"); // Scalloping.
	public static final RadioFrequencyAreaCode RHG = new RadioFrequencyAreaCode("RHG"); // Roughness (signal roughness experienced).
	public static final RadioFrequencyAreaCode UNREL = new RadioFrequencyAreaCode("UNREL"); // Unreliability.
	public static final RadioFrequencyAreaCode RES = new RadioFrequencyAreaCode("RES"); // Restricted (use is restricted to defined sectors).
	public static final RadioFrequencyAreaCode UUS = new RadioFrequencyAreaCode("UUS"); // Un-usability (use is not permitted in the defined sectors).
	public static final RadioFrequencyAreaCode OUT = new RadioFrequencyAreaCode("OUT"); // Out of tolerance.
	public static final RadioFrequencyAreaCode ESV = new RadioFrequencyAreaCode("ESV"); // Extended Service Volume (Coverage)
	
	private String value;
	
	public RadioFrequencyAreaCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RadioFrequencyAreaCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
