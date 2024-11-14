package com.baesystems.environmentinfrastructure.types;

public class RunwayMarkingCode {
	// Type of runway marking related to landing categories such as precision, non-precision and basic.
	public static final RunwayMarkingCode PRECISION = new RunwayMarkingCode("PRECISION"); // Markings appropriate for precision approach  runway.Precision Instrument runway marking elements include markings for Runway Designation, Centreline, Threshold, Aiming Point, Touchdown Zone and Side Stripes.
	public static final RunwayMarkingCode NONPRECISION = new RunwayMarkingCode("NONPRECISION"); // Markings appropriate for non-precision approach  runway.  Non-Precision Instrument runway marking elements include markings for Runway designation, Centreline, threshold and Aiming Point.
	public static final RunwayMarkingCode BASIC = new RunwayMarkingCode("BASIC"); // Basic (or Visual) runway marking elements include markings for Runway Designation, Centreline, Threshold (On runways sued or intended to be used by international commercial transports) and Aiming Point (On runways 4000 ft (1200M) or longer used by jet aircraft).
	public static final RunwayMarkingCode NONE = new RunwayMarkingCode("NONE"); // No runway markings present.
	public static final RunwayMarkingCode RUNWAY_NUMBERS = new RunwayMarkingCode("RUNWAY_NUMBERS"); // The only runway marking element present is the Runway Designation.
	public static final RunwayMarkingCode NON_STANDARD = new RunwayMarkingCode("NON_STANDARD"); // Runway marking elements such as Runway Designation, Centreline, Threshold and Aiming Point may be present, but they are Not standard markings.
	public static final RunwayMarkingCode HELIPORT = new RunwayMarkingCode("HELIPORT"); // Heliport specific marking elements are present.
	
	private String value;
	
	public RunwayMarkingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RunwayMarkingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
