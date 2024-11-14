package com.baesystems.environmentinfrastructure.types;

public class AircraftEngineCode {
	// A code indicating the type of aircraft engine (for example, jet, piston, turbo).
	public static final AircraftEngineCode JET = new AircraftEngineCode("JET"); // Jet Engine
	public static final AircraftEngineCode PISTON = new AircraftEngineCode("PISTON"); // Piston Engine
	public static final AircraftEngineCode TURBOPROP = new AircraftEngineCode("TURBOPROP"); // Turbo Propeller Engine
	public static final AircraftEngineCode ALL = new AircraftEngineCode("ALL"); // All aircraft engine types.
	
	private String value;
	
	public AircraftEngineCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AircraftEngineCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
