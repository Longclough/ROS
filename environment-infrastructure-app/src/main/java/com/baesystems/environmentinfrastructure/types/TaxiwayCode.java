package com.baesystems.environmentinfrastructure.types;

public class TaxiwayCode {
	// A code indicating a type of taxiway.For example, normal taxiway, apron taxiway, air taxiway, etc..
	public static final TaxiwayCode AIR = new TaxiwayCode("AIR"); // Air taxiway.
	public static final TaxiwayCode GND = new TaxiwayCode("GND"); // Ground taxiway.
	public static final TaxiwayCode EXIT = new TaxiwayCode("EXIT"); // Exit/turnoff taxiway.
	public static final TaxiwayCode FASTEXIT = new TaxiwayCode("FASTEXIT"); // Rapid exit/turnoff taxiway.
	public static final TaxiwayCode STUB = new TaxiwayCode("STUB"); // Stub taxiway.
	public static final TaxiwayCode TURN_AROUND = new TaxiwayCode("TURN_AROUND"); // Turn around.
	public static final TaxiwayCode PARALLEL = new TaxiwayCode("PARALLEL"); // Parallel taxiway.
	public static final TaxiwayCode BYPASS = new TaxiwayCode("BYPASS"); // Bypass holding bay.
	
	private String value;
	
	public TaxiwayCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TaxiwayCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
