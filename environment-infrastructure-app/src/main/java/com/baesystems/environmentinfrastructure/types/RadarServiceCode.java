package com.baesystems.environmentinfrastructure.types;

public class RadarServiceCode {
	// A list of service types for Radar Systems.
	public static final RadarServiceCode PAR = new RadarServiceCode("PAR"); // Precision Approach RadarPrecision Approach Radar (PAR) is designed for use as a landing aid rather than an aid for sequencing and spacing aircraft to provide lateral and vertical guidance to an aircraft pilot for landing up to the missed approach point.  PAR equipment may be used as a primary landing aid or it may be used to monitor other types of approaches.  It is designed to display range, azimuth, and elevation information.  It is similar to an instrument landing system (ILS) but requires control instructions.  One type of instrument approach that can make use of PAR is the ground-controlled approach (GCA).
	public static final RadarServiceCode ARSR = new RadarServiceCode("ARSR"); // Air Route Surveillance RadarAir Route Surveillance Radar (ARSR) or Route Surveillance Radar (RSR) is a system of remotely located, long-range radars that primarily provides a display of aircraft locations over large areas to air route traffic control centres
	public static final RadarServiceCode ASR = new RadarServiceCode("ASR"); // Airport Surveillance RadarAirport Surveillance Radar (ASR) is a category of surveillance radars.  ASR is designed to provide relatively short-range coverage in the general vicinity of an airport and to serve as an expeditious means of handling terminal traffic through observation of precise aircraft locations on a radarscope.  The ASR can also be used as an instrument approach aid.
	public static final RadarServiceCode SSR = new RadarServiceCode("SSR"); // Secondary Surveillance Radar or ATCRBS (Air Traffic Control Radar Beacon System)Secondary Surveillance Radar (SSR) (aka Secondary Radar (SECRA) or ATC Radar Beacon System (ATCRBS)) is a radar system in which the object to be detected is fitted with the cooperative equipment in the form of a radio receiver/transmitter (transponder).  Radar pulses transmitted from the searching transmitter/receiver (interrogator) site are received in the cooperative equipment and used to trigger a distinctive transmission from the transponder.  This reply transmission, rather than a reflected signal, is then received back at the transmitter/receiver site for processing and display at an air traffic control facility.
	
	private String value;
	
	public RadarServiceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RadarServiceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
