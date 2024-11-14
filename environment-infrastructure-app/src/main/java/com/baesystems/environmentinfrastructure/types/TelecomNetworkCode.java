package com.baesystems.environmentinfrastructure.types;

public class TelecomNetworkCode {
	// Codelist containing the Telecom Networks that can be used to address an organisation.
	public static final TelecomNetworkCode AFTN = new TelecomNetworkCode("AFTN"); // The data interchange in the AFS is performed by the Aeronautical Fixed Telecommunications Network, AFTN. This is a message handling network running according to ICAO Standards documented in Annex 10 to the ICAO Convention
	public static final TelecomNetworkCode AMHS = new TelecomNetworkCode("AMHS"); // Aeronautical Message Handling System. A standard for aeronautical ground-ground communications (e.g. for the transmission of NOTAM, Flight Plans or Meteorological Data) based on X.400 profiles. It has been defined by the International Civil Aviation Organization (ICAO)
	public static final TelecomNetworkCode INTERNET = new TelecomNetworkCode("INTERNET"); // The Internet is a worldwide, publicly accessible series of interconnected computer networks that transmit data by packet switching using the standard Internet Protocol (IP)
	public static final TelecomNetworkCode SITA = new TelecomNetworkCode("SITA"); // SITA network
	public static final TelecomNetworkCode ACARS = new TelecomNetworkCode("ACARS"); // Aircraft Communications Addressing and Reporting System. A datalink system that enables ground stations (airports, aircraft maintenance bases, etc.) and commercial aircraft to communicate without voice using a datalink system.
	public static final TelecomNetworkCode ADNS = new TelecomNetworkCode("ADNS"); // ARINC Data Network Service (retired Mar 2007)
	
	private String value;
	
	public TelecomNetworkCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TelecomNetworkCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
