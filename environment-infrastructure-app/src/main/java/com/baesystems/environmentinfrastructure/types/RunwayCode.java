package com.baesystems.environmentinfrastructure.types;

public class RunwayCode {
	// A code that makes a distinction between runways for airplanes and FATO for helicopters.
	public static final RunwayCode RWY = new RunwayCode("RWY"); // Runway for airplanes
	public static final RunwayCode FATO = new RunwayCode("FATO"); // Final Approach and Take Off Area for helicopters
	
	private String value;
	
	public RunwayCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RunwayCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
