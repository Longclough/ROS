package com.baesystems.environmentinfrastructure.types;

public class LevelCode {
	// A code indicating the level: upper airspace, lower airspace or both.
	public static final LevelCode UPPER = new LevelCode("UPPER"); // Upper airspace.
	public static final LevelCode LOWER = new LevelCode("LOWER"); // Lower airspace.
	public static final LevelCode BOTH = new LevelCode("BOTH"); // Both upper and lower airspace.
	
	private String value;
	
	public LevelCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LevelCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
