package com.baesystems.environmentinfrastructure.types;

public class MarkerBeaconSignalCode {
	// A code indicating the class of a radio marker.
	public static final MarkerBeaconSignalCode FAN = new MarkerBeaconSignalCode("FAN"); // Fan marker.
	public static final MarkerBeaconSignalCode LOW_PWR_FAN = new MarkerBeaconSignalCode("LOW_PWR_FAN"); // Low powered fan marker.
	public static final MarkerBeaconSignalCode Z = new MarkerBeaconSignalCode("Z"); // Z marker.
	public static final MarkerBeaconSignalCode BONES = new MarkerBeaconSignalCode("BONES"); // Bone Shaped Fan marker.
	
	private String value;
	
	public MarkerBeaconSignalCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MarkerBeaconSignalCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
