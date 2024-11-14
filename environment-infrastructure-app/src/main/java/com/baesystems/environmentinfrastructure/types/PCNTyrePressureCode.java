package com.baesystems.environmentinfrastructure.types;

public class PCNTyrePressureCode {
	// A code indicating the maximum allowable tyre pressure category related to a PCN number.
	public static final PCNTyrePressureCode W = new PCNTyrePressureCode("W"); // High: No pressure limit.
	public static final PCNTyrePressureCode X = new PCNTyrePressureCode("X"); // Medium: Pressure limited to 1.5 MPa (217 psi).
	public static final PCNTyrePressureCode Y = new PCNTyrePressureCode("Y"); // Low: Pressure limited to 1.00 MPa (145 psi).
	public static final PCNTyrePressureCode Z = new PCNTyrePressureCode("Z"); // Very low: Pressure limited to 0.50 MPa (73 psi).
	
	private String value;
	
	public PCNTyrePressureCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof PCNTyrePressureCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
