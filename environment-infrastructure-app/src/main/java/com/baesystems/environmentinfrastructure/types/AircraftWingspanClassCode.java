package com.baesystems.environmentinfrastructure.types;

public class AircraftWingspanClassCode {
	// A grouping of airplanes based on wingspan.
	public static final AircraftWingspanClassCode I = new AircraftWingspanClassCode("I"); // Up to but not including 49 ft (15 m)
	public static final AircraftWingspanClassCode II = new AircraftWingspanClassCode("II"); // 49 ft (15 m) up to but not including 79 ft (24 m)
	public static final AircraftWingspanClassCode III = new AircraftWingspanClassCode("III"); // 79 ft (24 m) up to but not including 118 ft (36 m)
	public static final AircraftWingspanClassCode IV = new AircraftWingspanClassCode("IV"); // 118 ft (36 m) up to but not including 171 ft (52 m) 
	public static final AircraftWingspanClassCode V = new AircraftWingspanClassCode("V"); // 171 ft (52 m) up to but not including 214 ft (65 m) 
	public static final AircraftWingspanClassCode VI = new AircraftWingspanClassCode("VI"); // 214 ft (65 m) up to but not including 262 ft (80 m) 
	
	private String value;
	
	public AircraftWingspanClassCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AircraftWingspanClassCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
