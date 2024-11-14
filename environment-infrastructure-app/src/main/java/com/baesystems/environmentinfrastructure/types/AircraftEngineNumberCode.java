package com.baesystems.environmentinfrastructure.types;

public class AircraftEngineNumberCode {
	// A coded indication for the number of engines of an aircraft.
	public static final AircraftEngineNumberCode _1 = new AircraftEngineNumberCode("1"); // One engine.
	public static final AircraftEngineNumberCode _2 = new AircraftEngineNumberCode("2"); // Two engines.
	public static final AircraftEngineNumberCode _3 = new AircraftEngineNumberCode("3"); // Three engines.
	public static final AircraftEngineNumberCode _4 = new AircraftEngineNumberCode("4"); // Four engines.
	public static final AircraftEngineNumberCode _6 = new AircraftEngineNumberCode("6"); // Six engines.
	public static final AircraftEngineNumberCode _8 = new AircraftEngineNumberCode("8"); // Eight engines.
	public static final AircraftEngineNumberCode _2C = new AircraftEngineNumberCode("2C"); // Two coupled engines driving one propeller.
	
	private String value;
	
	public AircraftEngineNumberCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AircraftEngineNumberCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
