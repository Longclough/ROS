package com.baesystems.environmentinfrastructure.types;

public class NavaidServiceCode {
	// Types of Navaid Services.
	public static final NavaidServiceCode VOR = new NavaidServiceCode("VOR"); // VHF Omnidirectional Radio Range.
	public static final NavaidServiceCode DME = new NavaidServiceCode("DME"); // Distance Measuring Equipment.
	public static final NavaidServiceCode NDB = new NavaidServiceCode("NDB"); // Non-Directional Radio Beacon
	public static final NavaidServiceCode TACAN = new NavaidServiceCode("TACAN"); // Tactical Air Navigation Beacon
	public static final NavaidServiceCode MKR = new NavaidServiceCode("MKR"); // Marker Beacon
	public static final NavaidServiceCode ILS = new NavaidServiceCode("ILS"); // Instrument Landing System
	public static final NavaidServiceCode ILS_DME = new NavaidServiceCode("ILS_DME"); // ILS with collocated DME.  Collocation can be with the antenna or the loc.  See NavaidComponent collocationGroup
	public static final NavaidServiceCode MLS = new NavaidServiceCode("MLS"); // Microwave Landing System
	public static final NavaidServiceCode MLS_DME = new NavaidServiceCode("MLS_DME"); // MLS with collocated DME.   See NavaidComponent collocationGroup
	public static final NavaidServiceCode VORTAC = new NavaidServiceCode("VORTAC"); // VOR and TACAN collocated.
	public static final NavaidServiceCode VOR_DME = new NavaidServiceCode("VOR_DME"); // VOR and DME collocated.
	public static final NavaidServiceCode NDB_DME = new NavaidServiceCode("NDB_DME"); // NDB and DME collocated.
	public static final NavaidServiceCode TLS = new NavaidServiceCode("TLS"); // Transponder Landing System
	public static final NavaidServiceCode LOC = new NavaidServiceCode("LOC"); // Localizer.  
	public static final NavaidServiceCode LOC_DME = new NavaidServiceCode("LOC_DME"); // LOC and DME collocated.
	public static final NavaidServiceCode NDB_MKR = new NavaidServiceCode("NDB_MKR"); // Non-Directional Radio Beacon and Marker Beacon
	public static final NavaidServiceCode DF = new NavaidServiceCode("DF"); // Direction Finder.
	public static final NavaidServiceCode SDF = new NavaidServiceCode("SDF"); // Simplified Directional Facility.
	
	private String value;
	
	public NavaidServiceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NavaidServiceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
