package com.baesystems.environmentinfrastructure.types;

public class ObstacleAreaCode {
	// A code indicating the type of obstacle coverage area, according to ICAO Annex 15.
	public static final ObstacleAreaCode AREA1 = new ObstacleAreaCode("AREA1"); // ICAO Area 1: entire territory of a State.
	public static final ObstacleAreaCode AREA2 = new ObstacleAreaCode("AREA2"); // ICAO Area 2: terminal control area.
	public static final ObstacleAreaCode AREA3 = new ObstacleAreaCode("AREA3"); // ICAO Area 3: aerodrome/heliport area.
	public static final ObstacleAreaCode AREA4 = new ObstacleAreaCode("AREA4"); // ICAO Area 4: Category II or III operations area.
	public static final ObstacleAreaCode OLS = new ObstacleAreaCode("OLS"); // ICAO Annex 14 Obstacle Limitation Surface.
	public static final ObstacleAreaCode FAR77 = new ObstacleAreaCode("FAR77"); // FAA Regulations Part 77 Obstacle Limitation Surfaces.
	public static final ObstacleAreaCode MANAGED = new ObstacleAreaCode("MANAGED"); // A 'virtual' area containing the VerticalStructures included in the data collection exercise, which do not qualify yet as Obstacles in any specific Area
	
	private String value;
	
	public ObstacleAreaCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ObstacleAreaCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
