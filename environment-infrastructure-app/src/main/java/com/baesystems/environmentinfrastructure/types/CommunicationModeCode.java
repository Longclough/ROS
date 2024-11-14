package com.baesystems.environmentinfrastructure.types;

public class CommunicationModeCode {
	// A coded indicator for the type of communication channel.
	public static final CommunicationModeCode HF = new CommunicationModeCode("HF"); // High Frequency radio voice channel.
	public static final CommunicationModeCode VHF = new CommunicationModeCode("VHF"); // Very High Frequency radio voice channel with 25 KHz spacing.
	public static final CommunicationModeCode VDL1 = new CommunicationModeCode("VDL1"); // Legacy VHF data link protocol employing CSMA. Being replaced by VDL2
	public static final CommunicationModeCode VDL2 = new CommunicationModeCode("VDL2"); // VHF data link protocol employing CSMA but much more efficient than VDL1.
	public static final CommunicationModeCode VDL4 = new CommunicationModeCode("VDL4"); // VHF data link protocol using TDMA; being considered for use by ADS-B.
	public static final CommunicationModeCode AMSS = new CommunicationModeCode("AMSS"); // Aeronautical Mobile Satellite Service, currently used by ACARS.
	public static final CommunicationModeCode ADS_B = new CommunicationModeCode("ADS_B"); // Automatic Dependent Surveillance - Broadcast: standard mode.
	public static final CommunicationModeCode ADS_B_VDL = new CommunicationModeCode("ADS_B_VDL"); // Automatic Dependent Surveillance - Broadcast: extended mode, using VDL 4.
	public static final CommunicationModeCode HFDL = new CommunicationModeCode("HFDL"); // High Frequency Data Link.
	public static final CommunicationModeCode VHF_833 = new CommunicationModeCode("VHF_833"); // Very High Frequency radio voice channel with 8.33 KHz spacing.
	public static final CommunicationModeCode UHF = new CommunicationModeCode("UHF"); // Ultra High Frequency radio voice channel.
	
	private String value;
	
	public CommunicationModeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof CommunicationModeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
