package com.baesystems.environmentinfrastructure.types;

public class ApproachEquipmentAdditionalCode {
	// A code indicating the additional equipment needed to fly the procedure not listed in approachType
	public static final ApproachEquipmentAdditionalCode ADF = new ApproachEquipmentAdditionalCode("ADF"); // ADF Required
	public static final ApproachEquipmentAdditionalCode DME = new ApproachEquipmentAdditionalCode("DME"); // DME Required
	public static final ApproachEquipmentAdditionalCode RADAR = new ApproachEquipmentAdditionalCode("RADAR"); // Radar required
	public static final ApproachEquipmentAdditionalCode RADARDME = new ApproachEquipmentAdditionalCode("RADARDME"); // Radar or DME required.
	public static final ApproachEquipmentAdditionalCode VORLOC = new ApproachEquipmentAdditionalCode("VORLOC"); // VOR and localizer required.
	public static final ApproachEquipmentAdditionalCode DUALVORDME = new ApproachEquipmentAdditionalCode("DUALVORDME"); // Dual VOR or VOR/DME required
	public static final ApproachEquipmentAdditionalCode DUALADF = new ApproachEquipmentAdditionalCode("DUALADF"); // Dual ADF required
	public static final ApproachEquipmentAdditionalCode ADFMA = new ApproachEquipmentAdditionalCode("ADFMA"); // ADF required for missed approach.
	public static final ApproachEquipmentAdditionalCode SPECIAL = new ApproachEquipmentAdditionalCode("SPECIAL"); // al aircraft and aircrew certification required
	public static final ApproachEquipmentAdditionalCode DUALVHF = new ApproachEquipmentAdditionalCode("DUALVHF"); // Dual VHF communication required.
	public static final ApproachEquipmentAdditionalCode GPSRNP3 = new ApproachEquipmentAdditionalCode("GPSRNP3"); // GPS or RNP-0.3 required.
	public static final ApproachEquipmentAdditionalCode ADFILS = new ApproachEquipmentAdditionalCode("ADFILS"); // ADF required for ILS approach.
	public static final ApproachEquipmentAdditionalCode DUALADF_DME = new ApproachEquipmentAdditionalCode("DUALADF_DME"); // DME and dual ADF required for LOC approach
	public static final ApproachEquipmentAdditionalCode RADAR_RNAV = new ApproachEquipmentAdditionalCode("RADAR_RNAV"); // Radar or RNAV required.
	
	private String value;
	
	public ApproachEquipmentAdditionalCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ApproachEquipmentAdditionalCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
