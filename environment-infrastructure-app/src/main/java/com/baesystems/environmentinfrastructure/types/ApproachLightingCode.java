package com.baesystems.environmentinfrastructure.types;

public class ApproachLightingCode {
	// A regional or organisation specific classification of the Runway approach lighting system equipment. Could also be a brand name.
	public static final ApproachLightingCode ALSAF = new ApproachLightingCode("ALSAF"); // 3000 Foot high intensity Approach Lighting System with Sequenced Flashing Lights.
	public static final ApproachLightingCode MALS = new ApproachLightingCode("MALS"); // 1400 Foot Medium Intensity Approach Lighting System.
	public static final ApproachLightingCode MALSR = new ApproachLightingCode("MALSR"); // 1400 Foot Medium Intensity Approach Lighting System with Runway Alignment Indicator Lights.
	public static final ApproachLightingCode SALS = new ApproachLightingCode("SALS"); // Simple Approach Lighting System.
	public static final ApproachLightingCode SSALS = new ApproachLightingCode("SSALS"); // Simplified Short Approach Lighting System.
	public static final ApproachLightingCode SSALR = new ApproachLightingCode("SSALR"); // Simplified Short Approach Lighting System with Runway Alignment Indicator Lights.
	public static final ApproachLightingCode LDIN = new ApproachLightingCode("LDIN"); // Lead-In Lighting System.
	public static final ApproachLightingCode ODALS = new ApproachLightingCode("ODALS"); // Omni Directional Approach Lighting System.
	public static final ApproachLightingCode AFOVRN = new ApproachLightingCode("AFOVRN"); // US Air Force Overrun 1000 Foot Standard Approach Lighting System.
	public static final ApproachLightingCode MILOVRN = new ApproachLightingCode("MILOVRN"); // Military Overrun.
	public static final ApproachLightingCode CALVERT = new ApproachLightingCode("CALVERT"); // Calvert Approach Lighting System 
	
	private String value;
	
	public ApproachLightingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ApproachLightingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
