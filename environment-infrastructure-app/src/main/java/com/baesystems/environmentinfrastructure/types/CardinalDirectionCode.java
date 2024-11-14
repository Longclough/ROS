package com.baesystems.environmentinfrastructure.types;

public class CardinalDirectionCode {
	// An angle expressed as compass directions.
	public static final CardinalDirectionCode N = new CardinalDirectionCode("N"); // North.
	public static final CardinalDirectionCode NE = new CardinalDirectionCode("NE"); // Northeast
	public static final CardinalDirectionCode E = new CardinalDirectionCode("E"); // East.
	public static final CardinalDirectionCode SE = new CardinalDirectionCode("SE"); // Southeast
	public static final CardinalDirectionCode S = new CardinalDirectionCode("S"); // South.
	public static final CardinalDirectionCode SW = new CardinalDirectionCode("SW"); // Southwest
	public static final CardinalDirectionCode W = new CardinalDirectionCode("W"); // West.
	public static final CardinalDirectionCode NW = new CardinalDirectionCode("NW"); // Northwest.
	public static final CardinalDirectionCode NNE = new CardinalDirectionCode("NNE"); // North-northeast
	public static final CardinalDirectionCode ENE = new CardinalDirectionCode("ENE"); // East North East
	public static final CardinalDirectionCode ESE = new CardinalDirectionCode("ESE"); // East Southeast
	public static final CardinalDirectionCode SSE = new CardinalDirectionCode("SSE"); // South southeast
	public static final CardinalDirectionCode SSW = new CardinalDirectionCode("SSW"); // South southwest
	public static final CardinalDirectionCode WSW = new CardinalDirectionCode("WSW"); // West southwest
	public static final CardinalDirectionCode WNW = new CardinalDirectionCode("WNW"); // West northwest
	public static final CardinalDirectionCode NNW = new CardinalDirectionCode("NNW"); // North northwest
	
	private String value;
	
	public CardinalDirectionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof CardinalDirectionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
