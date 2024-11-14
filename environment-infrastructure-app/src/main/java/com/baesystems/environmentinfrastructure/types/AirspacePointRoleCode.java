package com.baesystems.environmentinfrastructure.types;

public class AirspacePointRoleCode {
	// A code indicating the type of association between a significant point and an airspace. For example, entry point, exit point, etc..
	public static final AirspacePointRoleCode ENTRY = new AirspacePointRoleCode("ENTRY"); // The first reporting point, determined by reference to a significant point, over which an aircraft passes or is expected to pass upon entering an airspace.
	public static final AirspacePointRoleCode EXIT = new AirspacePointRoleCode("EXIT"); // Exit point. The last reporting point, determined by reference to a significant point, over which an aircraft passes or is expected to pass before leaving an airspace.
	public static final AirspacePointRoleCode ENTRY_EXIT = new AirspacePointRoleCode("ENTRY_EXIT"); // Entry/exit point.  The first or the last reporting point, determined by reference to a significant point, over which an aircraft passes or is expected to pass upon entering or before leaving an airspace.
	
	private String value;
	
	public AirspacePointRoleCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirspacePointRoleCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
