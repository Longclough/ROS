package com.baesystems.environmentinfrastructure.types;

public class VASISCode {
	// A code indicating a type of visual approach slope indicator system.For example, VASIS, AVASIS, 3-BAR VASIS, PAPI, APAPI, etc..
	public static final VASISCode PAPI = new VASISCode("PAPI"); // Precision approach path indicator.
	public static final VASISCode APAPI = new VASISCode("APAPI"); // Abbreviated precision approach path indicator.
	public static final VASISCode HAPI = new VASISCode("HAPI"); // Helicopter approach path indicator.
	public static final VASISCode VASIS = new VASISCode("VASIS"); // Visual approach slope indicator system.
	public static final VASISCode AVASIS = new VASISCode("AVASIS"); // Abbreviated visual approach slow indicator system.
	public static final VASISCode TVASIS = new VASISCode("TVASIS"); // T-shaped VASIS
	public static final VASISCode ATVASIS = new VASISCode("ATVASIS"); // Abbreviated TVASIS
	public static final VASISCode _3B_VASIS = new VASISCode("3B_VASIS"); // 3 bar VASIS.
	public static final VASISCode _3B_AVASIS = new VASISCode("3B_AVASIS"); // 3 bar AVASIS
	public static final VASISCode _3B_ATVASIS = new VASISCode("3B_ATVASIS"); // 3 bar ATVASIS.
	public static final VASISCode PVASI = new VASISCode("PVASI"); // Pulsating/steady burning visual approach slope indicator, normally a single light unit projecting two colours.
	public static final VASISCode TRCV = new VASISCode("TRCV"); // Tri-colour visual approach slope indicator, normally a single light unit projecting three colours.
	public static final VASISCode PNI = new VASISCode("PNI"); // Alignment of elements system.
	public static final VASISCode ILU = new VASISCode("ILU"); // A number of identical light units.
	public static final VASISCode OLS = new VASISCode("OLS"); // Optical landing system for strip decks and aircraft carriers (sometimes available on ground air bases for training purposes).
	public static final VASISCode LCVASI = new VASISCode("LCVASI"); // Low cost visual approach slope indicator: 3 sets of 4 white lights on 3 mounts usually on only one side of the runway.
	
	private String value;
	
	public VASISCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof VASISCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
