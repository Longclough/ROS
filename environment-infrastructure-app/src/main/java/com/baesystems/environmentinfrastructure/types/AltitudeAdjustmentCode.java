package com.baesystems.environmentinfrastructure.types;

public class AltitudeAdjustmentCode {
	// A code indicating the type of adjustment used to produce a usable altitude.
	public static final AltitudeAdjustmentCode RA = new AltitudeAdjustmentCode("RA"); // Remote altimeter
	public static final AltitudeAdjustmentCode AS = new AltitudeAdjustmentCode("AS"); // Airspace
	public static final AltitudeAdjustmentCode AT = new AltitudeAdjustmentCode("AT"); // Air traffic
	public static final AltitudeAdjustmentCode AC = new AltitudeAdjustmentCode("AC"); // Accuracy code
	public static final AltitudeAdjustmentCode SI = new AltitudeAdjustmentCode("SI"); // Straight-in minimums
	public static final AltitudeAdjustmentCode XL = new AltitudeAdjustmentCode("XL"); // Excessive length of final
	public static final AltitudeAdjustmentCode PR = new AltitudeAdjustmentCode("PR"); // Precipitous terrain
	public static final AltitudeAdjustmentCode HAA = new AltitudeAdjustmentCode("HAA"); // Minimum required HAA (height above airport) calculated, round to a reportable value, and applied for charted
	public static final AltitudeAdjustmentCode MA = new AltitudeAdjustmentCode("MA"); // Missed approach due to obstacle penetration of missed approach slope (segment assessment area)
	public static final AltitudeAdjustmentCode PT = new AltitudeAdjustmentCode("PT"); // Procedure turn
	public static final AltitudeAdjustmentCode DG = new AltitudeAdjustmentCode("DG"); // Descent gradient
	public static final AltitudeAdjustmentCode GS = new AltitudeAdjustmentCode("GS"); // Glideslope - adjustment to set altitude at glideslope intercept
	public static final AltitudeAdjustmentCode CA = new AltitudeAdjustmentCode("CA"); // Cardinal altitude
	public static final AltitudeAdjustmentCode MT = new AltitudeAdjustmentCode("MT"); // Mountainous terrain
	public static final AltitudeAdjustmentCode MAH = new AltitudeAdjustmentCode("MAH"); // Missed approach hold
	public static final AltitudeAdjustmentCode SA = new AltitudeAdjustmentCode("SA"); // Secondary area (also X/y surfaces, transition areas)
	public static final AltitudeAdjustmentCode AAO = new AltitudeAdjustmentCode("AAO"); // Adverse Assumption Obstruction. Designates adjustment to a terrain value to account for natural vegetation growth, uncharted cell phone towers, buildings, and other man-made obstructions.
	public static final AltitudeAdjustmentCode VA = new AltitudeAdjustmentCode("VA"); // Vegetation Allowance. Designates an adjustment to a terrain value to account for natural vegetation growth.
	
	private String value;
	
	public AltitudeAdjustmentCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AltitudeAdjustmentCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
