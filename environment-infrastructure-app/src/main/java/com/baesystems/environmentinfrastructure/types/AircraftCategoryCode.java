package com.baesystems.environmentinfrastructure.types;

public class AircraftCategoryCode {
	// Classification of aircraft based on 1.3 times stall speed in landing configuration at maximum certified landing mass.Category A: - less than 169 km/h (91 kt) IASCategory B: - 169 km/h (91 kt) or more but less than 224 km/h (121 kt) IASCategory C: - 224 km/h (121 kt) or more but less than 261 km/h (141 kt) IASCategory D: - 261 km/h (141 kt) or more but less than 307 km/h (166 kt) IASCategory E: - 307 km/h (166 kt) or more but less than 391 km/h (211 kt) IASCategory H: - helicopter (the stall speed method of calculating aircraft category does not apply)(IAS = indicated air speed)
	public static final AircraftCategoryCode A = new AircraftCategoryCode("A"); // Category A
	public static final AircraftCategoryCode B = new AircraftCategoryCode("B"); // Category B.
	public static final AircraftCategoryCode C = new AircraftCategoryCode("C"); // Category C. 
	public static final AircraftCategoryCode D = new AircraftCategoryCode("D"); // Category D.
	public static final AircraftCategoryCode E = new AircraftCategoryCode("E"); // Category E.
	public static final AircraftCategoryCode H = new AircraftCategoryCode("H"); // Category H - Helicopter.
	public static final AircraftCategoryCode ALL = new AircraftCategoryCode("ALL"); // All aircraft and helicopter categories.
	
	private String value;
	
	public AircraftCategoryCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AircraftCategoryCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
