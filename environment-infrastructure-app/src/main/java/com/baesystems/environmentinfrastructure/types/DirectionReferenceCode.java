package com.baesystems.environmentinfrastructure.types;

public class DirectionReferenceCode {
	// A code indicating a direction with regard to a reference point, e.g. to or from.
	public static final DirectionReferenceCode TO = new DirectionReferenceCode("TO"); // Towards the reference point.
	public static final DirectionReferenceCode FROM = new DirectionReferenceCode("FROM"); // From the reference point.
	
	private String value;
	
	public DirectionReferenceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DirectionReferenceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
