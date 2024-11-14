package com.baesystems.environmentinfrastructure.types;

public class ProcedurePhaseCode {
	// A code indicating a phase of a SID, STAR or IAP.
	public static final ProcedurePhaseCode RWY = new ProcedurePhaseCode("RWY"); // Runway transition.
	public static final ProcedurePhaseCode COMMON = new ProcedurePhaseCode("COMMON"); // Common route
	public static final ProcedurePhaseCode EN_ROUTE = new ProcedurePhaseCode("EN_ROUTE"); // En-route transition
	public static final ProcedurePhaseCode APPROACH = new ProcedurePhaseCode("APPROACH"); // Approach transition (IAP only)
	public static final ProcedurePhaseCode FINAL = new ProcedurePhaseCode("FINAL"); // Final transition (IAP only).
	public static final ProcedurePhaseCode MISSED = new ProcedurePhaseCode("MISSED"); // Missed approach (IAP only)
	public static final ProcedurePhaseCode MISSED_P = new ProcedurePhaseCode("MISSED_P"); // Primary Missed Approach (IAP only)
	public static final ProcedurePhaseCode MISSED_S = new ProcedurePhaseCode("MISSED_S"); // Secondary Missed Approach (IAP only)
	public static final ProcedurePhaseCode ENGINE_OUT = new ProcedurePhaseCode("ENGINE_OUT"); // Engine out (SID only) 
	
	private String value;
	
	public ProcedurePhaseCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ProcedurePhaseCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
