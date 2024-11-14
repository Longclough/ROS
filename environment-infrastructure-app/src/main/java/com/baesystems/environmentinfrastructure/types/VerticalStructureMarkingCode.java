package com.baesystems.environmentinfrastructure.types;

public class VerticalStructureMarkingCode {
	// A code indicating the type and pattern of markings on a vertical structure.
	public static final VerticalStructureMarkingCode MONOCOLOUR = new VerticalStructureMarkingCode("MONOCOLOUR"); // Markings painted as a single colour.
	public static final VerticalStructureMarkingCode CHEQUERED = new VerticalStructureMarkingCode("CHEQUERED"); // Markings painted in a chequered pattern.
	public static final VerticalStructureMarkingCode HBANDS = new VerticalStructureMarkingCode("HBANDS"); // Markings painted as horizontal bands.
	public static final VerticalStructureMarkingCode VBANDS = new VerticalStructureMarkingCode("VBANDS"); // Markings painted as vertical bands.
	public static final VerticalStructureMarkingCode FLAG = new VerticalStructureMarkingCode("FLAG"); // Flag marked with chequered pattern.
	public static final VerticalStructureMarkingCode MARKERS = new VerticalStructureMarkingCode("MARKERS"); // Marks attached to cables or wires.
	
	private String value;
	
	public VerticalStructureMarkingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof VerticalStructureMarkingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
