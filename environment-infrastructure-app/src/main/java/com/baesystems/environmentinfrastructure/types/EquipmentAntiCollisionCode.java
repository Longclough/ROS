package com.baesystems.environmentinfrastructure.types;

public class EquipmentAntiCollisionCode {
	// A coded list if values indicating the aircraft equipment with an anti-collision system.
	public static final EquipmentAntiCollisionCode ACAS_I = new EquipmentAntiCollisionCode("ACAS_I"); // Airborne Collision Avoidance System - version I, implemented as Traffic Alert and Collision Avoidance System (TCAS) I.
	public static final EquipmentAntiCollisionCode ACAS_II = new EquipmentAntiCollisionCode("ACAS_II"); // Airborne Collision Avoidance System - version II, implemented as Traffic Alert and Collision Avoidance System (TCAS) II version 7.
	public static final EquipmentAntiCollisionCode GPWS = new EquipmentAntiCollisionCode("GPWS"); // Ground proximity warning system.
	
	private String value;
	
	public EquipmentAntiCollisionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof EquipmentAntiCollisionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
