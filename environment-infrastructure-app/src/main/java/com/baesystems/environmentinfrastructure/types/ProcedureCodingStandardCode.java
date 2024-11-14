package com.baesystems.environmentinfrastructure.types;

public class ProcedureCodingStandardCode {
	// Code indicating the standard used to encode the approach procedure.
	public static final ProcedureCodingStandardCode PANS_OPS = new ProcedureCodingStandardCode("PANS_OPS"); // ICAO PANS-OPS.
	public static final ProcedureCodingStandardCode ARINC_424_15 = new ProcedureCodingStandardCode("ARINC_424_15"); // ARINC 424 version 15
	public static final ProcedureCodingStandardCode ARINC_424_18 = new ProcedureCodingStandardCode("ARINC_424_18"); // ARINC 424 Version 18
	public static final ProcedureCodingStandardCode ARINC_424_19 = new ProcedureCodingStandardCode("ARINC_424_19"); // ARINC 424 Version 19.
	
	private String value;
	
	public ProcedureCodingStandardCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ProcedureCodingStandardCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
