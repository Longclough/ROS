package com.baesystems.environmentinfrastructure.types;

public class UomFrequencyCode {
	// A unit of measurement for a frequency.For example,. Hz, kHz, MHz, GHz.
	public static final UomFrequencyCode HZ = new UomFrequencyCode("HZ"); // Hertz
	public static final UomFrequencyCode KHZ = new UomFrequencyCode("KHZ"); // KiloHertz
	public static final UomFrequencyCode MHZ = new UomFrequencyCode("MHZ"); // MegaHertz
	public static final UomFrequencyCode GHZ = new UomFrequencyCode("GHZ"); // GigaHertz
	
	private String value;
	
	public UomFrequencyCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UomFrequencyCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
