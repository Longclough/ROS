package com.baesystems.environmentinfrastructure.types;

public class GroundLightingCode {
	// A code indicating a type of aeronautical ground light.For example, Marine, RWY BCN, ABN, IBN, etc.
	public static final GroundLightingCode BCN = new GroundLightingCode("BCN"); // Beacon
	public static final GroundLightingCode IBN = new GroundLightingCode("IBN"); // Identification Beacon
	public static final GroundLightingCode HEL_BCN = new GroundLightingCode("HEL_BCN"); // Heliport Beacon
	public static final GroundLightingCode ABN = new GroundLightingCode("ABN"); // Airport Beacon
	public static final GroundLightingCode MAR_BCN = new GroundLightingCode("MAR_BCN"); // Marine Beacon
	public static final GroundLightingCode RSP_BCN = new GroundLightingCode("RSP_BCN"); // Responder Beacon
	public static final GroundLightingCode TWR_BCN = new GroundLightingCode("TWR_BCN"); // Control tower signalling beacon
	public static final GroundLightingCode HAZ_BCN = new GroundLightingCode("HAZ_BCN"); // An aeronautical beacon used to designate a danger to air navigation.
	
	private String value;
	
	public GroundLightingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof GroundLightingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
