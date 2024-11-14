package com.baesystems.environmentinfrastructure.types;

public class AuthorityRoleCode {
	// A code indicating the role of the OrganisationAuthority for the aeronautical feature.
	public static final AuthorityRoleCode OWN = new AuthorityRoleCode("OWN"); // The OrganisationAuthority owns the feature.
	public static final AuthorityRoleCode OPERATE = new AuthorityRoleCode("OPERATE"); // The OrganisationAuthority operates the feature.
	public static final AuthorityRoleCode SUPERVISE = new AuthorityRoleCode("SUPERVISE"); // The OrganisationAuthority exercises regulatory role over the facility.
	
	private String value;
	
	public AuthorityRoleCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AuthorityRoleCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
