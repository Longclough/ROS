package com.baesystems.environmentinfrastructure.types;

public class OperationAirportHeliportCode {
	// A coded identifier indicating an operation executed by an aircraft in relation with an airport/heliport.
	public static final OperationAirportHeliportCode LANDING = new OperationAirportHeliportCode("LANDING"); // Landing
	public static final OperationAirportHeliportCode TAKEOFF = new OperationAirportHeliportCode("TAKEOFF"); // Take off
	public static final OperationAirportHeliportCode TOUCHGO = new OperationAirportHeliportCode("TOUCHGO"); // Touch and go
	public static final OperationAirportHeliportCode TRAIN_APPROACH = new OperationAirportHeliportCode("TRAIN_APPROACH"); // Practice low approaches.
	public static final OperationAirportHeliportCode ALTN_LANDING = new OperationAirportHeliportCode("ALTN_LANDING"); // Landing at an Alternate Airport/Heliport.
	public static final OperationAirportHeliportCode AIRSHOW = new OperationAirportHeliportCode("AIRSHOW"); // Air show
	public static final OperationAirportHeliportCode ALL = new OperationAirportHeliportCode("ALL"); // All operation types.
	
	private String value;
	
	public OperationAirportHeliportCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof OperationAirportHeliportCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
