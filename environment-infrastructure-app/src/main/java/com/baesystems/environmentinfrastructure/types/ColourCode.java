package com.baesystems.environmentinfrastructure.types;

public class ColourCode {
	// A code indicating a colour. The list of allowable values comprises 'named' colours, not colours being only describable using the RGB or the CYMK or another colour system combination.
	public static final ColourCode YELLOW = new ColourCode("YELLOW"); // Yellow.
	public static final ColourCode RED = new ColourCode("RED"); // Red,
	public static final ColourCode WHITE = new ColourCode("WHITE"); // White.
	public static final ColourCode BLUE = new ColourCode("BLUE"); // Blue.
	public static final ColourCode GREEN = new ColourCode("GREEN"); // Green.
	public static final ColourCode PURPLE = new ColourCode("PURPLE"); // Purple.
	public static final ColourCode ORANGE = new ColourCode("ORANGE"); // Orange.
	public static final ColourCode AMBER = new ColourCode("AMBER"); // amber
	public static final ColourCode BLACK = new ColourCode("BLACK"); // Black
	public static final ColourCode BROWN = new ColourCode("BROWN"); // Brown
	public static final ColourCode GREY = new ColourCode("GREY"); // Grey
	public static final ColourCode LIGHT_GREY = new ColourCode("LIGHT_GREY"); // Light grey
	public static final ColourCode MAGENTA = new ColourCode("MAGENTA"); // Magenta
	public static final ColourCode PINK = new ColourCode("PINK"); // Pink
	public static final ColourCode VIOLET = new ColourCode("VIOLET"); // Violet
	
	private String value;
	
	public ColourCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ColourCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
