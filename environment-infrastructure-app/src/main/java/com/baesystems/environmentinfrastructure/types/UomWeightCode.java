package com.baesystems.environmentinfrastructure.types;

public class UomWeightCode {
	// A unit of measurement for weight values.
	public static final UomWeightCode KG = new UomWeightCode("KG"); // Kilogram.
	public static final UomWeightCode T = new UomWeightCode("T"); // Tonne (metric).
	public static final UomWeightCode LB = new UomWeightCode("LB"); // Pound.
	public static final UomWeightCode TON = new UomWeightCode("TON"); // Non-metric US short ton (2000 ob or 907.18474 kg).
	
	private String value;
	
	public UomWeightCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomWeightCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
