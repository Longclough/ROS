package com.baesystems.environmentinfrastructure.types;

public class UnitDependencyCode {
	// A list of coded values that indicate the kind of dependency between a Unit and a RelatedUnit.
	public static final UnitDependencyCode OWNER = new UnitDependencyCode("OWNER"); // The Unit is owned by (subordinated to) the RelatedUnit.
	public static final UnitDependencyCode PROVIDER = new UnitDependencyCode("PROVIDER"); // In the provision of its services, the Unit uses the services of the RelatedUnit.
	public static final UnitDependencyCode ALTERNATE = new UnitDependencyCode("ALTERNATE"); // The RelatedUnit provide an alternate/replacement service to the  current Unit.
	
	private String value;
	
	public UnitDependencyCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UnitDependencyCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
