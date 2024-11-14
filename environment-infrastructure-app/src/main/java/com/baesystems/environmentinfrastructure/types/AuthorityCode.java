package com.baesystems.environmentinfrastructure.types;

public class AuthorityCode {
	// A code indicating the type of responsibility that one organisation/authority has for an aeronautical feature (for example, an airspace).
	public static final AuthorityCode OWN = new AuthorityCode("OWN"); // An authority has the legal right of possession and proprietorship over the feature.
	public static final AuthorityCode DLGT = new AuthorityCode("DLGT"); // An authority is assigned or entrusted with the responsibility for that feature.
	public static final AuthorityCode AIS = new AuthorityCode("AIS"); // The organization is responsible for the provision of aeronautical information in relation with that feature.
	
	private String value;
	
	public AuthorityCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AuthorityCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
