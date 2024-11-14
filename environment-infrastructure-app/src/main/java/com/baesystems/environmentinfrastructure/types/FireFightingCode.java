package com.baesystems.environmentinfrastructure.types;

public class FireFightingCode {
	// A code indicating the category of the fire fighting service provided at the aerodrome/heliport.
	public static final FireFightingCode H1 = new FireFightingCode("H1"); // H1 [(Helicopter) rescue and fire category 1..]  [note: (ICAO) Up to but not including 15m in length. .]  
	public static final FireFightingCode H2 = new FireFightingCode("H2"); // H2 [(Helicopter) rescue and fire category 2..]  [note: (ICAO) From 15m up to but not including 24m in length. .]  
	public static final FireFightingCode H3 = new FireFightingCode("H3"); // H3 [(Helicopter) rescue and fire category 3..]  [note: (ICAO) From 24m up to but not including 35m in length. .]  
	public static final FireFightingCode A1 = new FireFightingCode("A1"); // A1 [(Aircraft) rescue and fire category 1..]  [note: (ICAO, NATO) 0 up to but not including 9m over-all length and 2m maximum fuselage width. .]  
	public static final FireFightingCode A2 = new FireFightingCode("A2"); // A2 [(Aircraft) rescue and fire category 2..]  [note: (ICAO, NATO) 9m up to but not including 12m over-all length and 2m maximum fuselage width. .]  
	public static final FireFightingCode A3 = new FireFightingCode("A3"); // A3 [(Aircraft) rescue and fire category 3..]  [note: (ICAO, NATO) 12m up to but not including 18m over-all length and 3m maximum fuselage width. .] 
	public static final FireFightingCode A4 = new FireFightingCode("A4"); // A4 [(Aircraft) rescue and fire category 4..]  [note: (ICAO, NATO) 18m up to but not including 24m over-all length and 4m maximum fuselage width. .] 
	public static final FireFightingCode A5 = new FireFightingCode("A5"); // A5 [(Aircraft) rescue and fire category 5..]  [note: (ICAO, NATO) 24m up to but not including 28m over-all length and 4m maximum fuselage width. .]  
	public static final FireFightingCode A6 = new FireFightingCode("A6"); // A6 [(Aircraft) rescue and fire category 6..]  [note: (ICAO, NATO) 28m up to but not including 39m over-all length and 5m maximum fuselage width. .] 
	public static final FireFightingCode A7 = new FireFightingCode("A7"); // A7 [(Aircraft) rescue and fire category 7..]  [note: (ICAO, NATO) 39m up to but not including 49m over-all length and 5m maximum fuselage width. .] 
	public static final FireFightingCode A8 = new FireFightingCode("A8"); // A8 [(Aircraft) rescue and fire category 8..]  [note: (ICAO, NATO) 49m up to but not including 61m over-all length and 7m maximum fuselage width. .]  
	public static final FireFightingCode A9 = new FireFightingCode("A9"); // A9 [(Aircraft) rescue and fire category 9..]  [note: (ICAO, NATO) 61m up to but not including 76m over-all length and 7m maximum fuselage width. .] 
	public static final FireFightingCode A10 = new FireFightingCode("A10"); // A10 [(Aircraft) rescue and fire category 10.]  [note: 76m up to but not including 91m over-all length and 8m maximum fuselage width. .]  
	
	private String value;
	
	public FireFightingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FireFightingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
