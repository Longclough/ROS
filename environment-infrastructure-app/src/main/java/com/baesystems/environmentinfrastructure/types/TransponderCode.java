package com.baesystems.environmentinfrastructure.types;

public class TransponderCode {
	// A code indicating a transponder mode.
	public static final TransponderCode MODE_1 = new TransponderCode("MODE_1"); // Mode 1 provides 2-digit 5-bit mission code. (military only - cockpit selectable)
	public static final TransponderCode MODE_2 = new TransponderCode("MODE_2"); // Mode 2 provides 4-digit octal unit code. (military only - set on ground for fighters, can be changed in flight by transport aircraft)
	public static final TransponderCode MODE_3A = new TransponderCode("MODE_3A"); // Mode 3/A provides a 4-digit octal identification code for the aircraft, assigned by the air traffic controller. (military and civilian)
	public static final TransponderCode MODE_4 = new TransponderCode("MODE_4"); // Mode 4 provides a 3-pulse reply to crypto coded challenge. (military only)
	public static final TransponderCode MODE_5 = new TransponderCode("MODE_5"); // Mode 5 provides a cryptographically secured version of Mode S and ADS-B GPS position. (military only)
	public static final TransponderCode MODE_C = new TransponderCode("MODE_C"); // Mode C provides 4-digit octal code for aircraft's pressure altitude. (military and civilian)
	public static final TransponderCode MODE_S = new TransponderCode("MODE_S"); // Mode S provides multiple information formats to a selective interrogation. Each aircraft is assigned a fixed 24-bit address. (military and civilian)Mode S, or mode select, despite also being called a transponder radar system replacement for Air Traffic Control Radar Beacon System (ATCRBS), is actually a data packet protocol which can be used to augment ATCRBS transponder positioning equipment (radar and TCAS). Mode S is designed to fully interface with ATCRBS systems: mode S SSRs can interrogate ATCRBS transponders, and AIS-P transponders will also reply to older ATCRBS and TCAS interrogations.
	
	private String value;
	
	public TransponderCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TransponderCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
