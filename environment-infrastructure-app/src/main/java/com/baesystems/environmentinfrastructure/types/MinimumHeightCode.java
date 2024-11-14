package com.baesystems.environmentinfrastructure.types;

public class MinimumHeightCode {
	// A code classifying heights for approach procedure minima.
	public static final MinimumHeightCode DH = new MinimumHeightCode("DH"); // [ICAO] Decision height. A specified height in the precision approach or approach with vertical guidance at which a missed approach must he initiated if the required visual reference to continue the approach has not been established.
	public static final MinimumHeightCode OCH = new MinimumHeightCode("OCH"); // [ICAO] Obstacle clearance height (OCH). The lowest height above the elevation of the relevant runway threshold or the aerodrome elevation as applicable, used in establishing compliance with appropriate obstacle clearance criteria.
	public static final MinimumHeightCode MDH = new MinimumHeightCode("MDH"); // [ICAO] Minimum descent height. A specified height in a nonprecision approach or circling approach below which descent must not be made without the required visual reference.
	
	private String value;
	
	public MinimumHeightCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MinimumHeightCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
