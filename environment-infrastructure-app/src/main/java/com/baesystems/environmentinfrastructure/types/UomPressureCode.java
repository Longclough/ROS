package com.baesystems.environmentinfrastructure.types;

public class UomPressureCode {
	// A unit of measurement for pressure values.
	public static final UomPressureCode PA = new UomPressureCode("PA"); // Pascal (Pa)
	public static final UomPressureCode MPA = new UomPressureCode("MPA"); // Mega Pascal.
	public static final UomPressureCode PSI = new UomPressureCode("PSI"); // Pounds per square inch.
	public static final UomPressureCode BAR = new UomPressureCode("BAR"); // 100000 Pascals (Pa).
	public static final UomPressureCode TORR = new UomPressureCode("TORR"); // mm of mercury (mmHg).
	public static final UomPressureCode ATM = new UomPressureCode("ATM"); // Standard Atmosphere.
	public static final UomPressureCode HPA = new UomPressureCode("HPA"); // Hectopascal.
	
	private String value;
	
	public UomPressureCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomPressureCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
