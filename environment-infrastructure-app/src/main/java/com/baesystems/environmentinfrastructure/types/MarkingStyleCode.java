package com.baesystems.environmentinfrastructure.types;

public class MarkingStyleCode {
	// A coded list of values indicating styles of painted lines.
	public static final MarkingStyleCode SOLID = new MarkingStyleCode("SOLID"); // solid line.
	public static final MarkingStyleCode DASHED = new MarkingStyleCode("DASHED"); // Dashed line.
	public static final MarkingStyleCode DOTTED = new MarkingStyleCode("DOTTED"); // Dotted line.
	
	private String value;
	
	public MarkingStyleCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MarkingStyleCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
