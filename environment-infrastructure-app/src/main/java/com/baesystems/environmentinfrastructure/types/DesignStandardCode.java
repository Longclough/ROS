package com.baesystems.environmentinfrastructure.types;

public class DesignStandardCode {
	// A code indicating the rules used to design and evaluate terminal procedures
	public static final DesignStandardCode PANS_OPS = new DesignStandardCode("PANS_OPS"); // ICAO PANS-OPS
	public static final DesignStandardCode TERPS = new DesignStandardCode("TERPS"); // US TERPS (Terminal Procedure criteria)
	public static final DesignStandardCode CANADA_TERPS = new DesignStandardCode("CANADA_TERPS"); // Canadian variant of US TERPS
	public static final DesignStandardCode NATO = new DesignStandardCode("NATO"); // NATO
	
	private String value;
	
	public DesignStandardCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DesignStandardCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
