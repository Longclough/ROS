package com.baesystems.environmentinfrastructure.types;

public class MLSAzimuthCode {
	// A code indicating the type of azimuth equipment: normal or backward.
	public static final MLSAzimuthCode FWD = new MLSAzimuthCode("FWD"); // Forward
	public static final MLSAzimuthCode BWD = new MLSAzimuthCode("BWD"); // Backward.
	
	private String value;
	
	public MLSAzimuthCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MLSAzimuthCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
