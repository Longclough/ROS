package com.baesystems.environmentinfrastructure.types;

public class UomTemperatureCode {
	// A unit of measurement for temperature.
	public static final UomTemperatureCode C = new UomTemperatureCode("C"); // Degrees Celsius.
	public static final UomTemperatureCode F = new UomTemperatureCode("F"); // Degrees Fahrenheit.
	public static final UomTemperatureCode K = new UomTemperatureCode("K"); // Degrees Kelvin.
	
	private String value;
	
	public UomTemperatureCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomTemperatureCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
