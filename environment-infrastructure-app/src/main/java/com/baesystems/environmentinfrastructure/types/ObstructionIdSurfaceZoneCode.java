package com.baesystems.environmentinfrastructure.types;

public class ObstructionIdSurfaceZoneCode {
	// Specifies zones within obstruction identification surfaces (OIS)
	public static final ObstructionIdSurfaceZoneCode APPROACH = new ObstructionIdSurfaceZoneCode("APPROACH"); // (AirMAT)
	public static final ObstructionIdSurfaceZoneCode CONICAL = new ObstructionIdSurfaceZoneCode("CONICAL"); // (AirMAT)
	public static final ObstructionIdSurfaceZoneCode HORIZONTAL = new ObstructionIdSurfaceZoneCode("HORIZONTAL"); // (AirMAT)
	public static final ObstructionIdSurfaceZoneCode PRIMARY = new ObstructionIdSurfaceZoneCode("PRIMARY"); // (AirMAT)
	public static final ObstructionIdSurfaceZoneCode TRANSITION = new ObstructionIdSurfaceZoneCode("TRANSITION"); // (AirMAT)
	
	private String value;
	
	public ObstructionIdSurfaceZoneCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ObstructionIdSurfaceZoneCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
