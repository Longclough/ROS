package com.baesystems.environmentinfrastructure.types;

public class SegmentTerminationCode {
	// A code indicating the end point of a terminal procedure segment leg.
	public static final SegmentTerminationCode ALTITUDE = new SegmentTerminationCode("ALTITUDE"); // Leg is terminated when reaching the altitude conditions specified in the segment leg.
	public static final SegmentTerminationCode DISTANCE = new SegmentTerminationCode("DISTANCE"); // Leg is terminated when the distance has passed.
	public static final SegmentTerminationCode DURATION = new SegmentTerminationCode("DURATION"); // Leg is terminated when the duration has passed.
	public static final SegmentTerminationCode INTERCEPT = new SegmentTerminationCode("INTERCEPT"); // Leg is terminated when reaching the limited angle indication or reaching the limiting distance indication associated with the leg.
	
	private String value;
	
	public SegmentTerminationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SegmentTerminationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
