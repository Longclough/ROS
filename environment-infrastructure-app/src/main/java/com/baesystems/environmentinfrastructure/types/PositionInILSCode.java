package com.baesystems.environmentinfrastructure.types;

public class PositionInILSCode {
	// A code indicating a position in the ILS system.For example, outer, middle, inner, backcourse.
	public static final PositionInILSCode OUTER = new PositionInILSCode("OUTER"); // Outer.
	public static final PositionInILSCode MIDDLE = new PositionInILSCode("MIDDLE"); // Middle.
	public static final PositionInILSCode INNER = new PositionInILSCode("INNER"); // Inner.
	public static final PositionInILSCode BACKCOURSE = new PositionInILSCode("BACKCOURSE"); // Backcourse.
	
	private String value;
	
	public PositionInILSCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof PositionInILSCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
