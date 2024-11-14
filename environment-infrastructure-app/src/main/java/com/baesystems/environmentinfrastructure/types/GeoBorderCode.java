package com.baesystems.environmentinfrastructure.types;

public class GeoBorderCode {
	// The type of geographical border. The most common situation is the border between two countries.
	public static final GeoBorderCode STATE = new GeoBorderCode("STATE"); // State border.
	public static final GeoBorderCode WATER = new GeoBorderCode("WATER"); // Territorial waters limit.
	public static final GeoBorderCode COAST = new GeoBorderCode("COAST"); // Coastline.
	public static final GeoBorderCode RIVER = new GeoBorderCode("RIVER"); // River centreline.
	public static final GeoBorderCode BANK = new GeoBorderCode("BANK"); // River bank.
	
	private String value;
	
	public GeoBorderCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof GeoBorderCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
