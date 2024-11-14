package com.baesystems.environmentinfrastructure.types;

public class OrganisationHierarchyCode {
	// The values indicating the type of association between two organisations/authorities.
	public static final OrganisationHierarchyCode MEMBER = new OrganisationHierarchyCode("MEMBER"); // Child ORG is a member of the parent ORG.
	public static final OrganisationHierarchyCode OWNED_BY = new OrganisationHierarchyCode("OWNED_BY"); // Indicates that the current feature is hierarchically positioned immediately below the parent organisation.
	public static final OrganisationHierarchyCode SUPERVISED_BY = new OrganisationHierarchyCode("SUPERVISED_BY"); // Indicates that the current feature is under the supervision of the parent organisation.
	
	private String value;
	
	public OrganisationHierarchyCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof OrganisationHierarchyCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
