package com.baesystems.environmentinfrastructure.types;

public class AirportHeliportDesignatorCode {
	// A coded identifier for an Aerodrome/Heliport. The rules according to which this identifier should be formed are as follows:1) If the AD/HP has an ICAO four letter location indicator, this will become the CODE_ID for the Aerodrome/Heliport;2) If the AD/HP does not have an ICAO four letter location indicator but has an IATA three letter code, then this will become the CODE_ID for the Aerodrome/Heliport;3) If the AD/HP does not have either an ICAO four letter location indicator or an IATA three letter code, an artificially generated code will be used. This will contain a group of letters and a number. The group of letters could be the 2 letter code of the State responsible for the Aerodrome/Heliport (or one of these, if there are more than one, like ED and ET for Germany) and the number could be an integer between 0001 and 9999.
	
	private String value;
	
	public AirportHeliportDesignatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirportHeliportDesignatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
