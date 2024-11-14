package com.baesystems.environmentinfrastructure.types;

public class TrajectoryCode {
	// A code classifying the trajectory of a segment path.
	public static final TrajectoryCode STRAIGHT = new TrajectoryCode("STRAIGHT"); // Straight.
	public static final TrajectoryCode ARC = new TrajectoryCode("ARC"); // Arc.
	public static final TrajectoryCode PT = new TrajectoryCode("PT"); // Procedure Turn.
	public static final TrajectoryCode BASETURN = new TrajectoryCode("BASETURN"); // Base turn.
	public static final TrajectoryCode HOLDING = new TrajectoryCode("HOLDING"); // Holding.
	
	private String value;
	
	public TrajectoryCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TrajectoryCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
