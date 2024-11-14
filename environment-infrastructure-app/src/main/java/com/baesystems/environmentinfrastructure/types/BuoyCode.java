package com.baesystems.environmentinfrastructure.types;

public class BuoyCode {
	// Code indicating the type of Buoy
	public static final BuoyCode BLACK_RED_FL2 = new BuoyCode("BLACK_RED_FL2"); // Danger - Black and red alternating horizontal stripes indicates position of isolated danger
	public static final BuoyCode GREEN = new BuoyCode("GREEN"); // Lateral buoy - Marks port side of the channel when sailing toward the sea
	public static final BuoyCode GREEN_RED_GFL = new BuoyCode("GREEN_RED_GFL"); // Lateral buoy - Preferred channel is to port when a red horizontal stripe is sandwiched between two green horizontal stripes
	public static final BuoyCode Q3_VQ3 = new BuoyCode("Q3_VQ3"); // Cardinal buoy - Yellow stripe sandwiched between two black stripes and/or two triangles, apex on one pointing up and apex of other pointing down indicates safe water is to the east
	public static final BuoyCode Q6_VQ6 = new BuoyCode("Q6_VQ6"); // Cardinal buoy - Yellow stripe is atop a black stripe and/or twp triangles, apex of both pointing down indicates safe water is to the south
	public static final BuoyCode Q9_VQ9 = new BuoyCode("Q9_VQ9"); // Cardinal buoy - Black stripe sandwiched between two yellow stripes and/or two triangles apex of both point toward each other indicates safe water is to the west
	public static final BuoyCode Q_VQ = new BuoyCode("Q_VQ"); // Cardinal buoy - Black stripe atop a yellow stripe and/or two triangles apex of both point up indicates safe water is to the north
	public static final BuoyCode RED = new BuoyCode("RED"); // Lateral buoy - Marks port side of the channel when returning from the sea
	public static final BuoyCode RED_GREEN_RFL = new BuoyCode("RED_GREEN_RFL"); // Lateral buoy - Preferred channel to starboard when a green horizontal strips is sandwiched between two red horizontal stripes
	public static final BuoyCode RED_WHITE = new BuoyCode("RED_WHITE"); // Safe water buoy - Alternating red and white vertical stripes indicates safe water
	public static final BuoyCode WHITE = new BuoyCode("WHITE"); // No colour is stated on the chart 
	public static final BuoyCode YELLOW = new BuoyCode("YELLOW"); // Special buoy - Area used by navies, pipelines, surfing 
	
	private String value;
	
	public BuoyCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof BuoyCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
