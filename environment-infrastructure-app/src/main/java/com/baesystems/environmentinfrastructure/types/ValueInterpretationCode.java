package com.baesystems.environmentinfrastructure.types;

public class ValueInterpretationCode {
	// A code indicating how a value needs to be interpreted when used as a filter or condition. For example: above the value or below the value.
	public static final ValueInterpretationCode ABOVE = new ValueInterpretationCode("ABOVE"); // Higher than the value.
	public static final ValueInterpretationCode AT_OR_ABOVE = new ValueInterpretationCode("AT_OR_ABOVE"); // Equal or higher than the value.
	public static final ValueInterpretationCode AT_OR_BELOW = new ValueInterpretationCode("AT_OR_BELOW"); // Equal or lower than the value.
	public static final ValueInterpretationCode BELOW = new ValueInterpretationCode("BELOW"); // Lower than the value.
	
	private String value;
	
	public ValueInterpretationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValueInterpretationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
