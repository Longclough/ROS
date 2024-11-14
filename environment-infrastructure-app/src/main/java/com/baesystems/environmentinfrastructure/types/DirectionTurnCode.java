package com.baesystems.environmentinfrastructure.types;

public class DirectionTurnCode {
	// A code indicating the direction of a turn.
	public static final DirectionTurnCode LEFT = new DirectionTurnCode("LEFT"); // Left.
	public static final DirectionTurnCode RIGHT = new DirectionTurnCode("RIGHT"); // Right.
	public static final DirectionTurnCode EITHER = new DirectionTurnCode("EITHER"); // Either left or right.
	
	private String value;
	
	public DirectionTurnCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DirectionTurnCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
