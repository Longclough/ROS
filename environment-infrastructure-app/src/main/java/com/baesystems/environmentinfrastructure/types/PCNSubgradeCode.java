package com.baesystems.environmentinfrastructure.types;

public class PCNSubgradeCode {
	// A code indicating the sub-grade strength category related to a PCN number.
	public static final PCNSubgradeCode A = new PCNSubgradeCode("A"); // High strength sub-grade.
	public static final PCNSubgradeCode B = new PCNSubgradeCode("B"); // Medium strength sub-grade.
	public static final PCNSubgradeCode C = new PCNSubgradeCode("C"); // Low strength sub-grade.
	public static final PCNSubgradeCode D = new PCNSubgradeCode("D"); // Ultra-low strength sub-grade.
	
	private String value;
	
	public PCNSubgradeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof PCNSubgradeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
