package com.baesystems.environmentinfrastructure.types;

public class MinimaFinalApproachPathCode {
	// Code indicating final approach path type for establishing valid set of minima on a procedure.
	public static final MinimaFinalApproachPathCode STRAIGHT_IN = new MinimaFinalApproachPathCode("STRAIGHT_IN"); // Final approach path is straight in to a landing surface (S 9R).[FAAO 8260.3] A descent in an approved procedure where the navigation facility alignment is normally on the runway centreline, and glide slope (GS) information is provided.
	public static final MinimaFinalApproachPathCode CIRCLING = new MinimaFinalApproachPathCode("CIRCLING"); // Final approach path is circling above the airport. [ICAO] Circling approach. An extension of an instrument approach procedure which provides for visual circling of the aerodrome prior to landing.
	public static final MinimaFinalApproachPathCode SIDESTEP = new MinimaFinalApproachPathCode("SIDESTEP"); // [FAAO 8260.19] A sidestep manoeuvre is the visual alignment manoeuvre, required by a pilot executing an approach to one runway and cleared to land on a parallel runway.
	
	private String value;
	
	public MinimaFinalApproachPathCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MinimaFinalApproachPathCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
