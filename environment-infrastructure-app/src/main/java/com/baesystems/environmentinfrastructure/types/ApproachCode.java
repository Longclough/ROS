package com.baesystems.environmentinfrastructure.types;

public class ApproachCode {
	// A code describing the type of instrument approach procedure.
	public static final ApproachCode ASR = new ApproachCode("ASR"); // Airport surveillance radar (ASR)
	public static final ApproachCode ARA = new ApproachCode("ARA"); // Airborne radar approach (ARA)
	public static final ApproachCode ARSR = new ApproachCode("ARSR"); // Air Route Surveillance Radar
	public static final ApproachCode PAR = new ApproachCode("PAR"); // Precision Approach Radar
	public static final ApproachCode ILS = new ApproachCode("ILS"); // Instrument landing system (ILS)
	public static final ApproachCode ILS_DME = new ApproachCode("ILS_DME"); // Instrument landing system with Direction measuring equipment
	public static final ApproachCode ILS_PRM = new ApproachCode("ILS_PRM"); // Instrument landing system using a Precision runway monitor
	public static final ApproachCode LDA = new ApproachCode("LDA"); // Localizer Type Directional Aid
	public static final ApproachCode LDA_DME = new ApproachCode("LDA_DME"); // Localizer Type Directional Aid with Distance Measuring Equipment.
	public static final ApproachCode LOC = new ApproachCode("LOC"); // Localizer
	public static final ApproachCode LOC_BC = new ApproachCode("LOC_BC"); // Localizer Back course
	public static final ApproachCode LOC_DME = new ApproachCode("LOC_DME"); // Localizer with Distance Measuring Equipment
	public static final ApproachCode LOC_DME_BC = new ApproachCode("LOC_DME_BC"); // Localizer with Distance Measuring Equipment back course
	public static final ApproachCode MLS = new ApproachCode("MLS"); // Microwave Landing System
	public static final ApproachCode MLS_DME = new ApproachCode("MLS_DME"); // Microwave Landing System with Distance Measuring Equipment.
	public static final ApproachCode NDB = new ApproachCode("NDB"); // Non-Directional Beacon.
	public static final ApproachCode NDB_DME = new ApproachCode("NDB_DME"); // Non-Directional Beacon with Distance Measuring Equipment.
	public static final ApproachCode SDF = new ApproachCode("SDF"); // Simplified Directional Facility.
	public static final ApproachCode TLS = new ApproachCode("TLS"); // Transponder Landing System.
	public static final ApproachCode VOR = new ApproachCode("VOR"); // VHF Omnidirectional Radio
	public static final ApproachCode VOR_DME = new ApproachCode("VOR_DME"); // VHF Omnidirectional Radio with Distance Measuring Equipment.
	public static final ApproachCode TACAN = new ApproachCode("TACAN"); // UHF Tactical Air Navigation beacon
	public static final ApproachCode VORTAC = new ApproachCode("VORTAC"); // VHF Omnidirectional Radio with UHF Tactical Air Navigation beacon
	public static final ApproachCode DME = new ApproachCode("DME"); // Distance Measuring Equipment
	public static final ApproachCode DME_DME = new ApproachCode("DME_DME"); // Distance Measuring Equipment with Distance Measuring Equipment.
	public static final ApproachCode RNP = new ApproachCode("RNP"); // Required Navigation Performance.
	public static final ApproachCode GPS = new ApproachCode("GPS"); // Global Positioning System
	public static final ApproachCode GLONASS = new ApproachCode("GLONASS"); // GLONASS
	public static final ApproachCode GALILEO = new ApproachCode("GALILEO"); // GALILEO
	public static final ApproachCode RNAV = new ApproachCode("RNAV"); // Area Navigation
	public static final ApproachCode IGS = new ApproachCode("IGS"); // Instrument Guidance System
	
	private String value;
	
	public ApproachCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ApproachCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
