package com.baesystems.environmentinfrastructure.types;

public class RadioSignalCode {
	// A coded indicator for the type of information transmitted by a navaid or other radio emission source.
	public static final RadioSignalCode AZIMUTH = new RadioSignalCode("AZIMUTH"); // The signal supports the provision/calculation of horizontal angle information.
	public static final RadioSignalCode DISTANCE = new RadioSignalCode("DISTANCE"); // The signal supports the provision/calculation of linear separation information.
	public static final RadioSignalCode BEAM = new RadioSignalCode("BEAM"); // The signal provides a directional guidance, in the horizontal or vertical planes.
	public static final RadioSignalCode VOICE = new RadioSignalCode("VOICE"); // The signal provides a carrier for voice information.
	public static final RadioSignalCode DATALINK = new RadioSignalCode("DATALINK"); // The signal provides a carrier for data.
	
	private String value;
	
	public RadioSignalCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RadioSignalCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
