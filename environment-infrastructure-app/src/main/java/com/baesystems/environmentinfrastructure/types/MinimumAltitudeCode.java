package com.baesystems.environmentinfrastructure.types;

public class MinimumAltitudeCode {
	// A code classifying altitudes for approach procedure minima.
	public static final MinimumAltitudeCode OCA = new MinimumAltitudeCode("OCA"); // [ICAO] Obstacle clearance altitude (OCA). The lowest altitude used in establishing compliance with appropriate obstacle clearance criteria.
	public static final MinimumAltitudeCode DA = new MinimumAltitudeCode("DA"); // Decision altitude (DA). [FAAO 8260.3] A specified altitude in reference to mean sea level in an approach with vertical guidance at which a missed approach must be initiated if the required visual references to continue the approach have not been established.
	public static final MinimumAltitudeCode MDA = new MinimumAltitudeCode("MDA"); // [ICAO] Minimum descent altitude (MDA). A specified altitude in a non-precision approach or circling approach below which descent must not be made without the required visual reference.
	
	private String value;
	
	public MinimumAltitudeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MinimumAltitudeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
