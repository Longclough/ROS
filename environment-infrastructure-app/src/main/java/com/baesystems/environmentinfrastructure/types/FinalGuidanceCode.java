package com.baesystems.environmentinfrastructure.types;

public class FinalGuidanceCode {
	// Codes describing the guidance used on the final approach segment of an instrument approach procedure.
	public static final FinalGuidanceCode LPV = new FinalGuidanceCode("LPV"); // An LPV approach is classified as an APV procedure based on the lateral OCS dimensions of the precision approach trapezoid, with vertical guidance provided by the WAAS where the VAL is greater than 12 and less than or equal to 50 meters. These procedures are published on RNAV Global Positioning System (GPS) approach charts as the LPV minima line.
	public static final FinalGuidanceCode LNAV_VNAV = new FinalGuidanceCode("LNAV_VNAV"); // Lateral navigation/Vertical navigation
	public static final FinalGuidanceCode LNAV = new FinalGuidanceCode("LNAV"); // Lateral navigation (LNAV) . The lateral navigation without positive vertical guidance. This type ofnavigation is associated with nonprecision approach procedures.
	public static final FinalGuidanceCode GLS = new FinalGuidanceCode("GLS"); // Global Landing System. LAAS support.
	public static final FinalGuidanceCode ASR = new FinalGuidanceCode("ASR"); // Airport surveillance radar (ASR)
	public static final FinalGuidanceCode ARA = new FinalGuidanceCode("ARA"); // Airborne radar approach (ARA)
	public static final FinalGuidanceCode ARSR = new FinalGuidanceCode("ARSR"); // Air Route Surveillance Radar
	public static final FinalGuidanceCode PAR = new FinalGuidanceCode("PAR"); // Precision Approach Radar
	public static final FinalGuidanceCode ILS = new FinalGuidanceCode("ILS"); // Instrument landing system (ILS)
	public static final FinalGuidanceCode ILS_DME = new FinalGuidanceCode("ILS_DME"); // Instrument landing system with Direction measuring equipment
	public static final FinalGuidanceCode ILS_PRM = new FinalGuidanceCode("ILS_PRM"); // Instrument landing system using a Precision runway monitor
	public static final FinalGuidanceCode LDA = new FinalGuidanceCode("LDA"); // Localizer Type Directional Aid
	public static final FinalGuidanceCode LDA_DME = new FinalGuidanceCode("LDA_DME"); // Localizer Type Directional Aid with Distance Measuring Equipment.
	public static final FinalGuidanceCode LOC = new FinalGuidanceCode("LOC"); // Localizer.
	public static final FinalGuidanceCode LOC_BC = new FinalGuidanceCode("LOC_BC"); // Localizer Back Course.
	public static final FinalGuidanceCode LOC_DME = new FinalGuidanceCode("LOC_DME"); // Localizer with Distance Measuring Equipment.
	public static final FinalGuidanceCode LOC_DME_BC = new FinalGuidanceCode("LOC_DME_BC"); // Localizer with Distance Measuring Equipment Back Course.
	public static final FinalGuidanceCode MLS = new FinalGuidanceCode("MLS"); // Microwave Landing System.
	public static final FinalGuidanceCode MLS_DME = new FinalGuidanceCode("MLS_DME"); // Microwave Landing System with Distance Measuring Equipment.
	public static final FinalGuidanceCode NDB = new FinalGuidanceCode("NDB"); // Non-Directional Beacon
	public static final FinalGuidanceCode NDB_DME = new FinalGuidanceCode("NDB_DME"); // Non-Directional Beacon with Distance Measuring Equipment.
	public static final FinalGuidanceCode SDF = new FinalGuidanceCode("SDF"); // Simplified Directional Facility.
	public static final FinalGuidanceCode TLS = new FinalGuidanceCode("TLS"); // Transponder Landing System.
	public static final FinalGuidanceCode VOR = new FinalGuidanceCode("VOR"); // VHF Omnidirectional Radio
	public static final FinalGuidanceCode VOR_DME = new FinalGuidanceCode("VOR_DME"); // VHF Omnidirectional Radio with Distance Measuring Equipment.
	public static final FinalGuidanceCode TACAN = new FinalGuidanceCode("TACAN"); // UHF Tactical Air Navigation beacon
	public static final FinalGuidanceCode VORTAC = new FinalGuidanceCode("VORTAC"); // VHF Omnidirectional Radio with UHF Tactical Air Navigation beacon
	public static final FinalGuidanceCode DME = new FinalGuidanceCode("DME"); // Distance Measuring Equipment.
	public static final FinalGuidanceCode LP = new FinalGuidanceCode("LP"); // A Localizer Performance (LP) approach is an RNAV non-vertically guided approach procedure evaluated using the lateral obstacle evaluation area dimensions of the precision localizer trapezoid, with adjustments specific to the WAAS.  These procedures are published on RNAV GPS approaches as the LP minima line.
	
	private String value;
	
	public FinalGuidanceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FinalGuidanceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
