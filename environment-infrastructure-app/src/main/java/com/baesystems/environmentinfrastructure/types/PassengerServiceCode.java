package com.baesystems.environmentinfrastructure.types;

public class PassengerServiceCode {
	// A code indicating a type of service provided to passengers at the airport.
	public static final PassengerServiceCode CUST = new PassengerServiceCode("CUST"); // Customs and immigration service.
	public static final PassengerServiceCode SAN = new PassengerServiceCode("SAN"); // Health and sanitation service.
	public static final PassengerServiceCode SECUR = new PassengerServiceCode("SECUR"); // Security service.
	public static final PassengerServiceCode VET = new PassengerServiceCode("VET"); // Veterinary service.
	public static final PassengerServiceCode HOTEL = new PassengerServiceCode("HOTEL"); // Hotel reservations/bookings.
	public static final PassengerServiceCode TRANSPORT = new PassengerServiceCode("TRANSPORT"); // Transport facilities and information.
	public static final PassengerServiceCode REST = new PassengerServiceCode("REST"); // Restaurant/cafe/bar facility.
	public static final PassengerServiceCode INFO = new PassengerServiceCode("INFO"); // Tourist information.
	public static final PassengerServiceCode BANK = new PassengerServiceCode("BANK"); // Banking/currency exchange facilities.
	public static final PassengerServiceCode POST = new PassengerServiceCode("POST"); // Letter/parcel post.
	public static final PassengerServiceCode MEDIC = new PassengerServiceCode("MEDIC"); // Medical facilities.
	
	private String value;
	
	public PassengerServiceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof PassengerServiceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
