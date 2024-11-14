package com.baesystems.environmentinfrastructure.types;

public class ProcedureDistanceCode {
	// Indicates the distance and altitude type associated with an approach procedure.
	public static final ProcedureDistanceCode HAT = new ProcedureDistanceCode("HAT"); // Height Above Touchdown
	public static final ProcedureDistanceCode OM = new ProcedureDistanceCode("OM"); // Outer marker
	public static final ProcedureDistanceCode MM = new ProcedureDistanceCode("MM"); // Middle marker
	public static final ProcedureDistanceCode IM = new ProcedureDistanceCode("IM"); // Inner marker
	public static final ProcedureDistanceCode PFAF = new ProcedureDistanceCode("PFAF"); // Precision final approach fix
	public static final ProcedureDistanceCode GSANT = new ProcedureDistanceCode("GSANT"); // Glideslope antenna
	public static final ProcedureDistanceCode FAF = new ProcedureDistanceCode("FAF"); // Final Approach Fix
	public static final ProcedureDistanceCode MAP = new ProcedureDistanceCode("MAP"); // Missed Approach Point
	public static final ProcedureDistanceCode THLD = new ProcedureDistanceCode("THLD"); // Runway Threshold
	public static final ProcedureDistanceCode VDP = new ProcedureDistanceCode("VDP"); // Visual Descent Point
	public static final ProcedureDistanceCode RECH = new ProcedureDistanceCode("RECH"); // Runway End Crossing Height
	
	private String value;
	
	public ProcedureDistanceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ProcedureDistanceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
