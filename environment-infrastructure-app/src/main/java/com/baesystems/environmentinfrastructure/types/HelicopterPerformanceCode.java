package com.baesystems.environmentinfrastructure.types;

public class HelicopterPerformanceCode {
	// A code indicating the performance class of a helicopter.
	public static final HelicopterPerformanceCode _1 = new HelicopterPerformanceCode("1"); // Helicopter class 1.
	public static final HelicopterPerformanceCode _2 = new HelicopterPerformanceCode("2"); // Helicopter class 2.
	public static final HelicopterPerformanceCode _3 = new HelicopterPerformanceCode("3"); // Helicopter class 3.
	
	private String value;
	
	public HelicopterPerformanceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof HelicopterPerformanceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
