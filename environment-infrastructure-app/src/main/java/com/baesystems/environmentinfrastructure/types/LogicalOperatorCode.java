package com.baesystems.environmentinfrastructure.types;

public class LogicalOperatorCode {
	// A boolean operator.
	public static final LogicalOperatorCode AND = new LogicalOperatorCode("AND"); // The result is true only when all operands are true.
	public static final LogicalOperatorCode OR = new LogicalOperatorCode("OR"); // The result is true if any operand is true.
	public static final LogicalOperatorCode NOT = new LogicalOperatorCode("NOT"); // The result is the opposite of the operands true/false state (it applies to a single operand).
	public static final LogicalOperatorCode NONE = new LogicalOperatorCode("NONE"); // No operation (used for single conditions).
	
	private String value;
	
	public LogicalOperatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LogicalOperatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
