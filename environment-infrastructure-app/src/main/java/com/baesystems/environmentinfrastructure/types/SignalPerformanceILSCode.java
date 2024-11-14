package com.baesystems.environmentinfrastructure.types;

public class SignalPerformanceILSCode {
	// A coded value indicating the signal performance level in space corresponding to the precision of an ILS or MLS system according to ICAO Annex 10, Volume I, Chapter 3.
	public static final SignalPerformanceILSCode I = new SignalPerformanceILSCode("I"); //  Facility Performance category I.
	public static final SignalPerformanceILSCode II = new SignalPerformanceILSCode("II"); //  Facility Performance category II.
	public static final SignalPerformanceILSCode III = new SignalPerformanceILSCode("III"); //  Facility Performance category III.
	
	private String value;
	
	public SignalPerformanceILSCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SignalPerformanceILSCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
