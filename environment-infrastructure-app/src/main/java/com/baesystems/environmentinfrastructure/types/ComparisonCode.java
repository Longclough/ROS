package com.baesystems.environmentinfrastructure.types;

public class ComparisonCode {
	// A list of comparison operators.
	public static final ComparisonCode LESS = new ComparisonCode("LESS"); // Lower.
	public static final ComparisonCode LESS_OR_EQUAL = new ComparisonCode("LESS_OR_EQUAL"); // Lower or equal.
	public static final ComparisonCode EQUAL = new ComparisonCode("EQUAL"); // Equal.
	public static final ComparisonCode GREATER_OR_EQUAL = new ComparisonCode("GREATER_OR_EQUAL"); // Greater or equal.
	public static final ComparisonCode GREATER = new ComparisonCode("GREATER"); // Greater.
	
	private String value;
	
	public ComparisonCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ComparisonCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
