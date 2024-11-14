package com.baesystems.environmentinfrastructure.types;

public class OperationManoeuvringAreaCode {
	// A coded list of values that indicates a type of activity on an airport/heliport manoeuvring area element.
	public static final OperationManoeuvringAreaCode LANDING = new OperationManoeuvringAreaCode("LANDING"); // Aircraft landing.
	public static final OperationManoeuvringAreaCode TAKEOFF = new OperationManoeuvringAreaCode("TAKEOFF"); // Aircraft take off.
	public static final OperationManoeuvringAreaCode TOUCHGO = new OperationManoeuvringAreaCode("TOUCHGO"); // Aircraft landing followed by an immediate take-off, without deceleration.
	public static final OperationManoeuvringAreaCode TRAIN_APPROACH = new OperationManoeuvringAreaCode("TRAIN_APPROACH"); // Aircraft practices low approaches.
	public static final OperationManoeuvringAreaCode TAXIING = new OperationManoeuvringAreaCode("TAXIING"); // Aircraft taxiing along an element of the airport/heliport movement area.
	public static final OperationManoeuvringAreaCode CROSSING = new OperationManoeuvringAreaCode("CROSSING"); // Crossing an element of the airport/heliport manoeuvring area, as opposed to taxiing along that element.
	public static final OperationManoeuvringAreaCode AIRSHOW = new OperationManoeuvringAreaCode("AIRSHOW"); // Air show and aircraft display activities.
	public static final OperationManoeuvringAreaCode ALL = new OperationManoeuvringAreaCode("ALL"); // All operation types.
	
	private String value;
	
	public OperationManoeuvringAreaCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof OperationManoeuvringAreaCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
