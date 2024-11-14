package com.baesystems.environmentinfrastructure.types;

public class ArrestingGearEngageDeviceCode {
	// A code indicating the type of device (for example: a hook) that is used to engage an aircraft upon landing in order to immediately stop it.
	public static final ArrestingGearEngageDeviceCode _61QSII = new ArrestingGearEngageDeviceCode("61QSII"); // 61QSII, a barricade net system
	public static final ArrestingGearEngageDeviceCode _62NI = new ArrestingGearEngageDeviceCode("62NI"); // 62NI, a net barrier with hook cable interconnect
	public static final ArrestingGearEngageDeviceCode _63PI = new ArrestingGearEngageDeviceCode("63PI"); // 63PI, a dual cable interconnect for hook engagements
	public static final ArrestingGearEngageDeviceCode NET_A30 = new ArrestingGearEngageDeviceCode("NET_A30"); // A30, an AERAZUR (manufacturer name) 30-element net (F30)
	public static final ArrestingGearEngageDeviceCode NET_A40 = new ArrestingGearEngageDeviceCode("NET_A40"); // A40, an AERAZUR (manufacturer name) 40-element net (F40)
	public static final ArrestingGearEngageDeviceCode BAK_11_STRUT = new ArrestingGearEngageDeviceCode("BAK_11_STRUT"); // BAK-11, a main strut engaging device.
	public static final ArrestingGearEngageDeviceCode BAK_12 = new ArrestingGearEngageDeviceCode("BAK_12"); // BAK-12, engaging device.
	public static final ArrestingGearEngageDeviceCode BAK_14_HOOK = new ArrestingGearEngageDeviceCode("BAK_14_HOOK"); // BAK-14, a retractable hook cable engaging device that may be used bi-directionally.  The cable takes 5 seconds to be raised.
	public static final ArrestingGearEngageDeviceCode BAK_15_STANCHION_NET = new ArrestingGearEngageDeviceCode("BAK_15_STANCHION_NET"); // BAK-15, a 61QSIIM stanchion and net barricade system.
	public static final ArrestingGearEngageDeviceCode BAK_15_HOOK = new ArrestingGearEngageDeviceCode("BAK_15_HOOK"); // BAK-15 (NI), a web barrier interconnected with hook pickup cable.
	public static final ArrestingGearEngageDeviceCode EMAS = new ArrestingGearEngageDeviceCode("EMAS"); // Engineered Materials Arresting System.  High-energy-absorbing material located in the runway overrun that is designed to crush under the weight of an aircraft as the material exerts deceleration forces on the aircraft landing gear.
	public static final ArrestingGearEngageDeviceCode HOOK_CABLE = new ArrestingGearEngageDeviceCode("HOOK_CABLE"); // An unspecified type of hook cable (tail hook) engagement.
	public static final ArrestingGearEngageDeviceCode HP_NET = new ArrestingGearEngageDeviceCode("HP_NET"); // HP-NET, an ADEC (brand name) high performance net.
	public static final ArrestingGearEngageDeviceCode J_BAR = new ArrestingGearEngageDeviceCode("J_BAR"); // J-BAR, a generic 'barrier' (non-hook cable) engagements.
	public static final ArrestingGearEngageDeviceCode JET_BARRIER = new ArrestingGearEngageDeviceCode("JET_BARRIER"); // An unspecified barrier used to stop aircraft.
	public static final ArrestingGearEngageDeviceCode MA_1_NET = new ArrestingGearEngageDeviceCode("MA_1_NET"); // MA-1, a main gear cable engagement net barrier (early MA-1A).
	public static final ArrestingGearEngageDeviceCode MA_1A_HOOK_CABLE = new ArrestingGearEngageDeviceCode("MA_1A_HOOK_CABLE"); // MA-1A (MOD), an MA-1A main gear cable engagement net barrier with interconnected hook cable.
	public static final ArrestingGearEngageDeviceCode NET = new ArrestingGearEngageDeviceCode("NET"); // An unspecified type of net engagement.
	public static final ArrestingGearEngageDeviceCode HOOK_H = new ArrestingGearEngageDeviceCode("HOOK_H"); // Type H, a retractable hook cable engaging device that may be used bi-directionally.  The cable takes 1.5 seconds to be raised.
	
	private String value;
	
	public ArrestingGearEngageDeviceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ArrestingGearEngageDeviceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
