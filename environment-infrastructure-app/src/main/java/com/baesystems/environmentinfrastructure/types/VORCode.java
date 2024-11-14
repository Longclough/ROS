package com.baesystems.environmentinfrastructure.types;

public class VORCode {
	// A code indicating the type of path to the next point.For example, great circle, clockwise arc, counter clockwise arc, etc.
	public static final VORCode VOR = new VORCode("VOR"); // Conventional VOR.
	public static final VORCode DVOR = new VORCode("DVOR"); // Doppler VOR.
	public static final VORCode VOT = new VORCode("VOT"); // VOR test facility
	
	private String value;
	
	public VORCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof VORCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
