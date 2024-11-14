package com.baesystems.environmentinfrastructure.types;

public class IntegrityLevelILSCode {
	// A coded value indicating the quality which relates to the trust which can be placed in the correctness of the information supplied by the ILS facility, according to ICAO Annex 10, Volume I, Attachment C.
	public static final IntegrityLevelILSCode _1 = new IntegrityLevelILSCode("1"); // Integrity Level 1.
	public static final IntegrityLevelILSCode _2 = new IntegrityLevelILSCode("2"); // Integrity Level 2.
	public static final IntegrityLevelILSCode _3 = new IntegrityLevelILSCode("3"); // Integrity Level 3.
	public static final IntegrityLevelILSCode _4 = new IntegrityLevelILSCode("4"); // Integrity Level 4.
	
	private String value;
	
	public IntegrityLevelILSCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof IntegrityLevelILSCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
