package com.baesystems.environmentinfrastructure.types;

public class MarkingConditionCode {
	// A coded list of values that indicate the status of the painted surface marking elements.
	public static final MarkingConditionCode GOOD = new MarkingConditionCode("GOOD"); // Marking is in good condition.
	public static final MarkingConditionCode FAIR = new MarkingConditionCode("FAIR"); // Marking is in fair condition.
	public static final MarkingConditionCode POOR = new MarkingConditionCode("POOR"); // Marking is in poor condition.
	public static final MarkingConditionCode EXCELLENT = new MarkingConditionCode("EXCELLENT"); // Marking is in perfect condition.
	
	private String value;
	
	public MarkingConditionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MarkingConditionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
