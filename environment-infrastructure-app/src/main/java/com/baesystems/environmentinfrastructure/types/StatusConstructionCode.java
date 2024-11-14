package com.baesystems.environmentinfrastructure.types;

public class StatusConstructionCode {
	// A code indicating the status of the construction of a Vertical Structure.
	public static final StatusConstructionCode IN_CONSTRUCTION = new StatusConstructionCode("IN_CONSTRUCTION"); // In Construction.
	public static final StatusConstructionCode COMPLETED = new StatusConstructionCode("COMPLETED"); // Completed.
	public static final StatusConstructionCode DEMOLITION_PLANNED = new StatusConstructionCode("DEMOLITION_PLANNED"); // Removal is planned.
	public static final StatusConstructionCode IN_DEMOLITION  = new StatusConstructionCode("IN_DEMOLITION "); // Work in progress to remove the item.
	
	private String value;
	
	public StatusConstructionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof StatusConstructionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
