package com.baesystems.environmentinfrastructure.types;

public class NavigationSpecificationCode {
	// A coded list of values that indicate a set of aircraft and flight crew requirements needed to support performance-based navigation operations within a defined airspace. There are two kinds of navigation specifications: RNP (includes the requirement for performance monitoring and alerting) and RNAV (does not include the requirement for performance monitoring and alerting).
	public static final NavigationSpecificationCode RNAV_10 = new NavigationSpecificationCode("RNAV_10"); // RNAV 10 (RNP 10) capability - for oceanic and remote continental navigation applications.
	public static final NavigationSpecificationCode RNAV_5 = new NavigationSpecificationCode("RNAV_5"); // RNAV 5 capability - for en-route and terminal navigation applications.
	public static final NavigationSpecificationCode RNAV_2 = new NavigationSpecificationCode("RNAV_2"); // RNAV 2 capability - for en-route and terminal navigation applications.
	public static final NavigationSpecificationCode RNAV_1 = new NavigationSpecificationCode("RNAV_1"); // RNAV 1 capability - for en-route and terminal navigation applications.
	public static final NavigationSpecificationCode RNP_4 = new NavigationSpecificationCode("RNP_4"); // RNP 4 capability - for oceanic and remote continental navigation applications.
	public static final NavigationSpecificationCode RNP_2 = new NavigationSpecificationCode("RNP_2"); // RNP 2 capability (specification to be developed by ICAO) - for various phases of flight.
	public static final NavigationSpecificationCode BASIC_RNP_1 = new NavigationSpecificationCode("BASIC_RNP_1"); // Basic RNP 1 capability - for various phases of flight.
	public static final NavigationSpecificationCode ADVANCED_RNP_1 = new NavigationSpecificationCode("ADVANCED_RNP_1"); // Advanced RNP 1 capability (specification to be developed by ICAO) - for various phases of flight.
	public static final NavigationSpecificationCode RNP_APCH = new NavigationSpecificationCode("RNP_APCH"); // RNP approach capability.
	public static final NavigationSpecificationCode RNP_AR_APCH = new NavigationSpecificationCode("RNP_AR_APCH"); // RNP AR approach capability.
	
	private String value;
	
	public NavigationSpecificationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NavigationSpecificationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
