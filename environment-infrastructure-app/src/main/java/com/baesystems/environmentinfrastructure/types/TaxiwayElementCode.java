package com.baesystems.environmentinfrastructure.types;

public class TaxiwayElementCode {
	// A code list of values indicating a component of the taxiway surface.
	public static final TaxiwayElementCode NORMAL = new TaxiwayElementCode("NORMAL"); // The default/regular type.
	public static final TaxiwayElementCode INTERSECTION = new TaxiwayElementCode("INTERSECTION"); // Intersection element - with a runway or with a taxiway.
	public static final TaxiwayElementCode SHOULDER = new TaxiwayElementCode("SHOULDER"); // Intersection element - with a runway or with another taxiway.
	public static final TaxiwayElementCode HOLDING_BAY = new TaxiwayElementCode("HOLDING_BAY"); // A defined area, on the side of a taxiway, where aircraft can be held, or bypassed, to facilitate efficient surface movement of aircraft.
	
	private String value;
	
	public TaxiwayElementCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TaxiwayElementCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
