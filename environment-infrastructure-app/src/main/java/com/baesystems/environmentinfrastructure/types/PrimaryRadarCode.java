package com.baesystems.environmentinfrastructure.types;

public class PrimaryRadarCode {
	// Type of Radar System (not to be confused with the component list)
	public static final PrimaryRadarCode ASR = new PrimaryRadarCode("ASR"); // Airport Surveillance Radar system.Airport Surveillance Radar (ASR) is a category of surveillance radars.  ASR is designed to provide relatively short-range coverage in the general vicinity of an airport and to serve as an expeditious means of handling terminal traffic through observation of precise aircraft locations on a radarscope.  The ASR can also be used as an instrument approach aid.
	public static final PrimaryRadarCode ARSR = new PrimaryRadarCode("ARSR"); // Air Route Surveillance Radar system.Air Route Surveillance Radar (ARSR) or Route Surveillance Radar (RSR) is a system of remotely located, long-range radars that primarily provides a display of aircraft locations over large areas to air route traffic control centres
	
	private String value;
	
	public PrimaryRadarCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof PrimaryRadarCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
