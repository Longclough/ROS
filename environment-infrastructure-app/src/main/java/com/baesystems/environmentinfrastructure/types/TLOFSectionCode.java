package com.baesystems.environmentinfrastructure.types;

public class TLOFSectionCode {
	// A code indicating the position of an item on the surface of a Touch Down and Lift-off Area.
	public static final TLOFSectionCode AIM = new TLOFSectionCode("AIM"); // Aiming point.
	public static final TLOFSectionCode EDGE = new TLOFSectionCode("EDGE"); // TLOF edge.
	
	private String value;
	
	public TLOFSectionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TLOFSectionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
