package com.baesystems.environmentinfrastructure.types;

public class SurfaceConditionCode {
	// A code indicating the condition of a surface, such as a runway, taxiway, the marking of a threshold, etc..
	public static final SurfaceConditionCode GOOD = new SurfaceConditionCode("GOOD"); // Good.
	public static final SurfaceConditionCode FAIR = new SurfaceConditionCode("FAIR"); // Fair.
	public static final SurfaceConditionCode POOR = new SurfaceConditionCode("POOR"); // Poor.
	public static final SurfaceConditionCode UNSAFE = new SurfaceConditionCode("UNSAFE"); // Unsafe for use.
	public static final SurfaceConditionCode DEFORMED = new SurfaceConditionCode("DEFORMED"); // Presenting deformations.
	
	private String value;
	
	public SurfaceConditionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SurfaceConditionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
