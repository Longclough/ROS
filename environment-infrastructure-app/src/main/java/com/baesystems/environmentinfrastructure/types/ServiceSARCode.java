package com.baesystems.environmentinfrastructure.types;

public class ServiceSARCode {
	// A list of codes used to designate services in relation with search and rescue.
	public static final ServiceSARCode ALRS = new ServiceSARCode("ALRS"); // Alerting service.
	public static final ServiceSARCode SAR = new ServiceSARCode("SAR"); // Search and rescue service.
	public static final ServiceSARCode RCC = new ServiceSARCode("RCC"); // Rescue co-ordination service.
	
	private String value;
	
	public ServiceSARCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ServiceSARCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
