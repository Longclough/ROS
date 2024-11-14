package com.baesystems.environmentinfrastructure.types;

public class ServiceATCCode {
	// A list of codes used to designate flight separation and ground control services.
	public static final ServiceATCCode ACS = new ServiceATCCode("ACS"); // En-route area control service (same as ARTCC service in US)
	public static final ServiceATCCode UAC = new ServiceATCCode("UAC"); // Upper area control service
	public static final ServiceATCCode OACS = new ServiceATCCode("OACS"); // Oceanic area control service.
	public static final ServiceATCCode APP = new ServiceATCCode("APP"); // Approach area control service (includes departure and arrival).
	public static final ServiceATCCode TWR = new ServiceATCCode("TWR"); // Aerodrome control tower service.
	public static final ServiceATCCode ADVS = new ServiceATCCode("ADVS"); // Advisory service.
	public static final ServiceATCCode EFAS = new ServiceATCCode("EFAS"); // En-route flight advisory service.
	public static final ServiceATCCode CTAF = new ServiceATCCode("CTAF"); // Common traffic advisory frequency service.
	
	private String value;
	
	public ServiceATCCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ServiceATCCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
