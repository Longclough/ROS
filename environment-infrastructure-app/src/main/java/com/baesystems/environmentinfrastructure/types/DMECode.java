package com.baesystems.environmentinfrastructure.types;

public class DMECode {
	// A code indicating the type of UHF distance measuring equipment.
	public static final DMECode NARROW = new DMECode("NARROW"); // DME/N, narrow spectrum characteristics.
	public static final DMECode PRECISION = new DMECode("PRECISION"); // DME/P, improved accuracy compared to DME/N
	public static final DMECode WIDE = new DMECode("WIDE"); // DME/W, wide spectrum characteristics.
	
	private String value;
	
	public DMECode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DMECode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
