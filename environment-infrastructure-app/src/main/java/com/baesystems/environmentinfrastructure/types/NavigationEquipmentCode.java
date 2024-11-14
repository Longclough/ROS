package com.baesystems.environmentinfrastructure.types;

public class NavigationEquipmentCode {
	// A coded list if values indicating the aircraft capability to use a certain ground based, satellite based or on-board system for aerial navigation.
	public static final NavigationEquipmentCode DME = new NavigationEquipmentCode("DME"); // DME Receiver.
	public static final NavigationEquipmentCode VOR_DME = new NavigationEquipmentCode("VOR_DME"); // VOR/DME Receiver.
	public static final NavigationEquipmentCode DME_DME = new NavigationEquipmentCode("DME_DME"); // DME/DME Receiver.
	public static final NavigationEquipmentCode TACAN = new NavigationEquipmentCode("TACAN"); // TACAN Receiver.
	public static final NavigationEquipmentCode ILS = new NavigationEquipmentCode("ILS"); // Instrument Landing System
	public static final NavigationEquipmentCode MLS = new NavigationEquipmentCode("MLS"); // Microwave Landing System
	public static final NavigationEquipmentCode GNSS = new NavigationEquipmentCode("GNSS"); // Global Navigation Satellite System.
	public static final NavigationEquipmentCode WAAS = new NavigationEquipmentCode("WAAS"); // Wide Area Augmentation System.
	public static final NavigationEquipmentCode LORAN = new NavigationEquipmentCode("LORAN"); // LORAN Receiver.
	public static final NavigationEquipmentCode INS = new NavigationEquipmentCode("INS"); // Inertial Navigation System.
	public static final NavigationEquipmentCode FMS = new NavigationEquipmentCode("FMS"); // Flight Management System.
	
	private String value;
	
	public NavigationEquipmentCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NavigationEquipmentCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
