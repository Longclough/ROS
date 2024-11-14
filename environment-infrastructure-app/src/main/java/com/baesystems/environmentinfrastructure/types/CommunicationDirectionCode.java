package com.baesystems.environmentinfrastructure.types;

public class CommunicationDirectionCode {
	// A coded indicator for the directionality of a communication channel.
	public static final CommunicationDirectionCode UPLINK = new CommunicationDirectionCode("UPLINK"); // Channel carries Ground-to-air traffic only.
	public static final CommunicationDirectionCode DOWNLINK = new CommunicationDirectionCode("DOWNLINK"); // Channel carries Air-to-Ground traffic only.
	public static final CommunicationDirectionCode BIDIRECTIONAL = new CommunicationDirectionCode("BIDIRECTIONAL"); // Channel carries traffic both ways.
	public static final CommunicationDirectionCode UPCAST = new CommunicationDirectionCode("UPCAST"); // Broadcast from ground to aircraft.
	public static final CommunicationDirectionCode DOWNCAST = new CommunicationDirectionCode("DOWNCAST"); // Broadcast from aircraft.
	
	private String value;
	
	public CommunicationDirectionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof CommunicationDirectionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
