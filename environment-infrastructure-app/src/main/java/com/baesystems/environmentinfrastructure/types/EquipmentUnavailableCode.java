package com.baesystems.environmentinfrastructure.types;

public class EquipmentUnavailableCode {
	// A code to indicate the type of unavailable equipment
	public static final EquipmentUnavailableCode STANDARD = new EquipmentUnavailableCode("STANDARD"); // Standard
	public static final EquipmentUnavailableCode NONSTANDARD = new EquipmentUnavailableCode("NONSTANDARD"); // Non standard
	
	private String value;
	
	public EquipmentUnavailableCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof EquipmentUnavailableCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
