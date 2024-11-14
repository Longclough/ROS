package com.baesystems.environmentinfrastructure.types;

public class LightingJARCode {
	// Classification of the approach lighting system using as criteria JAR-OPS 1 - Subpart E, Appendix 1 to 1.430]
	public static final LightingJARCode FALS = new LightingJARCode("FALS"); // Full approach light facilities; comprise runway markings, 720 m or more of high/medium intensity approach lights, runway edge lights, threshold lights and runway end lights. 
	public static final LightingJARCode IALS = new LightingJARCode("IALS"); // Intermediate approach light facilities; comprise runway markings, 420 to 720 m of high/medium intensity approach lights, runway edge lights, threshold lights and runway end lights. 
	public static final LightingJARCode BALS = new LightingJARCode("BALS"); // Basic approach light facilities; comprise runway markings, less than 420 m of high/medium intensity approach lights (or any length of low intensity approach lights), runway edge lights, threshold lights and runway end lights. 
	public static final LightingJARCode NALS = new LightingJARCode("NALS"); // None or insufficient approach light facilities; comprise runway markings, runway edge lights, threshold lights, runway end lights or no lights at all.
	
	private String value;
	
	public LightingJARCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LightingJARCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
