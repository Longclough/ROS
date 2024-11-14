package com.baesystems.environmentinfrastructure.types;

public class RadioEmissionCode {
	// A code indicating the type of emission, as defined at the 1979 ITU World Administrative Radio Conference.For example, A3E, NONA2a, G1D.
	public static final RadioEmissionCode A2 = new RadioEmissionCode("A2"); // Telegraphy, no voice.
	public static final RadioEmissionCode A3A = new RadioEmissionCode("A3A"); // Single side-band, reduced carrier.
	public static final RadioEmissionCode A3B = new RadioEmissionCode("A3B"); // Two independent side-bands.
	public static final RadioEmissionCode A3E = new RadioEmissionCode("A3E"); // AM double side-band telephony.
	public static final RadioEmissionCode A3H = new RadioEmissionCode("A3H"); // Single side-band, full carrier.
	public static final RadioEmissionCode A3J = new RadioEmissionCode("A3J"); // Single side-band, suppressed carrier.
	public static final RadioEmissionCode A3L = new RadioEmissionCode("A3L"); // Lower single side-band, carrier unknown.
	public static final RadioEmissionCode A3U = new RadioEmissionCode("A3U"); // Upper single side-band, carrier unknown
	public static final RadioEmissionCode J3E = new RadioEmissionCode("J3E"); // AM double side-band suppressed carrier telephony.
	public static final RadioEmissionCode NONA1A = new RadioEmissionCode("NONA1A"); // Unmod trans. morse ident. carrier emission interrupted.
	public static final RadioEmissionCode NONA2A = new RadioEmissionCode("NONA2A"); // Unmod. trans. morse ident. carrier emission continuous.
	public static final RadioEmissionCode PON = new RadioEmissionCode("PON"); // Pulse.
	public static final RadioEmissionCode A8W = new RadioEmissionCode("A8W"); // AM (unkeyed) plus ON/OFF keying of ident tone.
	public static final RadioEmissionCode A9W = new RadioEmissionCode("A9W"); // Composite AM/FM (unkeyed) plus ON/OFF keying of ident tone.
	public static final RadioEmissionCode NOX = new RadioEmissionCode("NOX"); // Unmodulated carrier.
	public static final RadioEmissionCode G1D = new RadioEmissionCode("G1D"); // DPSK Data Transmission.
	
	private String value;
	
	public RadioEmissionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RadioEmissionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
