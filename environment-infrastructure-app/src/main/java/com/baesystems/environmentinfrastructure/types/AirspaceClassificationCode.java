package com.baesystems.environmentinfrastructure.types;

public class AirspaceClassificationCode {
	// A coded list of values that which determines the operating rules, flight requirements, and services provided in an airspace.  According to Annex 11, Appendix 4.
	public static final AirspaceClassificationCode A = new AirspaceClassificationCode("A"); // Class of Airspace per ICAO Annex 11. Appendix 4.  IFR flights only are permitted; all flights are provided with air traffic control service and are separated from each other.
	public static final AirspaceClassificationCode B = new AirspaceClassificationCode("B"); // Class of Airspace per ICAO Annex 11. Appendix 4.  IFR and VFR flights are permitted; all flights are provided with air traffic control service and are separated from each other.
	public static final AirspaceClassificationCode C = new AirspaceClassificationCode("C"); // Class of Airspace per ICAO Annex 11. Appendix 4.  IFR and VFR flights are permitted; all flights are provided with air traffic control service and IFR flights are separated from other IFR flights and from VFR flights.  VFR flights are separated from IFR flights and receive traffic information.
	public static final AirspaceClassificationCode D = new AirspaceClassificationCode("D"); // Class of Airspace per ICAO Annex 11. Appendix 4.  IFR and VFR flights are permitted and all flights are provided with air traffic control service, IFR flights are separated from other IFR flights and receive traffic information in respect of VFR flights, VFR flights receive traffic information in respect of all other flights.
	public static final AirspaceClassificationCode E = new AirspaceClassificationCode("E"); // Class of Airspace per ICAO Annex 11. Appendix 4.  IFR and VFR flights are permitted; IFR flights are provided with air traffic control service and are separated from other IFR flights.  All flights receive traffic information as far as is practical.  Class E shall not be used for control zones. 
	public static final AirspaceClassificationCode F = new AirspaceClassificationCode("F"); // Class of Airspace per ICAO Annex 11. Appendix 4.  IFR and VFR flights are permitted, all participating IFR flights receive an air traffic advisory service and all flights receive flight information service if requested.Description:Where air traffic advisory service is implemented, this is considered normally as a temporary measure only until such time as it can be replaced by air traffic control.
	public static final AirspaceClassificationCode G = new AirspaceClassificationCode("G"); // Class of Airspace per ICAO Annex 11. Appendix 4. IFR and VFR flights are permitted and receive flight information service if requested. 
	
	private String value;
	
	public AirspaceClassificationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirspaceClassificationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
