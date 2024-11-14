package com.baesystems.environmentinfrastructure.types;

public class OrganisationDesignatorCode {
	// The coded identifier of an organisation, authority, agency or unit.
	
	private String value;
	
	public OrganisationDesignatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof OrganisationDesignatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
