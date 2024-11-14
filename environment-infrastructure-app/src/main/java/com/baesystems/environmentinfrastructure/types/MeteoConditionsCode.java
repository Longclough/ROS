package com.baesystems.environmentinfrastructure.types;

public class MeteoConditionsCode {
	// A code indicating whether the meteorological conditions allow visual or instrumental operations.
	public static final MeteoConditionsCode IMC = new MeteoConditionsCode("IMC"); // [Instrument Meteorological Conditions] Weather conditions that normally require pilots to fly primarily by reference to instruments, and therefore under Instrument Flight Rules (IFR).
	public static final MeteoConditionsCode VMC = new MeteoConditionsCode("VMC"); // [Visual Meteorological Conditions] Weather conditions in which visual flight rules (VFR) flight is permitted. That is, conditions in which pilots have sufficient visibility to fly the aircraft maintaining visual separation from terrain and other aircraft.
	public static final MeteoConditionsCode ALL = new MeteoConditionsCode("ALL"); // Both IMC and VMC.
	
	private String value;
	
	public MeteoConditionsCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MeteoConditionsCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
