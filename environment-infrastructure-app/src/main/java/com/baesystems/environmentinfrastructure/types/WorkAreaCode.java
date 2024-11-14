package com.baesystems.environmentinfrastructure.types;

public class WorkAreaCode {
	// A code indicating the type of work performed in the work area.
	public static final WorkAreaCode CONSTRUCTION = new WorkAreaCode("CONSTRUCTION"); // The work area is used for construction.Used for AMDB (DO272/ED99) Construction Area.
	public static final WorkAreaCode SURFACEWORK = new WorkAreaCode("SURFACEWORK"); // The work area is used for surface improvements.
	public static final WorkAreaCode PARKED = new WorkAreaCode("PARKED"); // Parked or disabled aircraft or machinery.
	
	private String value;
	
	public WorkAreaCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof WorkAreaCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
