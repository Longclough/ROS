package com.baesystems.environmentinfrastructure.types;

public class LevelSeriesCode {
	// A series of predefined levels.For example Odd, Even.
	public static final LevelSeriesCode ODD = new LevelSeriesCode("ODD"); // "Odd" flight levels (10, 30, 50, 70, ...)
	public static final LevelSeriesCode EVEN = new LevelSeriesCode("EVEN"); // "Even" flight levels (20, 40, 60, 80, ...)
	public static final LevelSeriesCode ODD_HALF = new LevelSeriesCode("ODD_HALF"); // Intermediate flight levels, above odd levels (15, 35, 55, 75, ...)
	public static final LevelSeriesCode EVEN_HALF = new LevelSeriesCode("EVEN_HALF"); // Intermediate flight levels, above even levels (5, 25, 45, 65, ...)
	
	private String value;
	
	public LevelSeriesCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LevelSeriesCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
