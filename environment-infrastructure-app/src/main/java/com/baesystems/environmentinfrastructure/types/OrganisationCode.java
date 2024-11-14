package com.baesystems.environmentinfrastructure.types;

public class OrganisationCode {
	// A code indicating the type of an Organisation/Authority.For example, State, Association of States, International Organisation, etc..
	public static final OrganisationCode STATE = new OrganisationCode("STATE"); // State.
	public static final OrganisationCode STATE_GROUP = new OrganisationCode("STATE_GROUP"); // Group of States.
	public static final OrganisationCode ORG = new OrganisationCode("ORG"); // Organisation within a State.
	public static final OrganisationCode INTL_ORG = new OrganisationCode("INTL_ORG"); // International organisation.
	public static final OrganisationCode ACFT_OPR = new OrganisationCode("ACFT_OPR"); // Aircraft operating agency.
	public static final OrganisationCode HANDLING_AGENCY = new OrganisationCode("HANDLING_AGENCY"); // Handling agency.
	public static final OrganisationCode NTL_AUTH = new OrganisationCode("NTL_AUTH"); // National authority.
	public static final OrganisationCode ATS = new OrganisationCode("ATS"); // Air traffic services provider.
	public static final OrganisationCode COMMERCIAL = new OrganisationCode("COMMERCIAL"); // Other commercial organisation.
	
	private String value;
	
	public OrganisationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof OrganisationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
