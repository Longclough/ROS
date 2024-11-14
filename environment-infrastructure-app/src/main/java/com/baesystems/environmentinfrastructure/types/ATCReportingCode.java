package com.baesystems.environmentinfrastructure.types;

public class ATCReportingCode {
	// A code indicating the type of position report required by an ATC Unit.Eg.: compulsory or on request.
	public static final ATCReportingCode COMPULSORY = new ATCReportingCode("COMPULSORY"); // Compulsory.
	public static final ATCReportingCode ON_REQUEST = new ATCReportingCode("ON_REQUEST"); // On request.
	public static final ATCReportingCode NO_REPORT = new ATCReportingCode("NO_REPORT"); // No report.
	
	private String value;
	
	public ATCReportingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ATCReportingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
