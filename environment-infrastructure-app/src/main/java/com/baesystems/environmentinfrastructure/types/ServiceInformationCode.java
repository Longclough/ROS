package com.baesystems.environmentinfrastructure.types;

public class ServiceInformationCode {
	// A list of codes used to designate information provision services.
	public static final ServiceInformationCode AFIS = new ServiceInformationCode("AFIS"); // Aerodrome flight information service, as defined in the ICAO Annex 11.
	public static final ServiceInformationCode AIS = new ServiceInformationCode("AIS"); // Aeronautical information service, as defined in the ICAO Annex 15.
	public static final ServiceInformationCode ATIS = new ServiceInformationCode("ATIS"); // Automated terminal information service, as defined in the ICAO Annex 11.
	public static final ServiceInformationCode BRIEFING = new ServiceInformationCode("BRIEFING"); // Pre-flight and post-flight briefing service. 
	public static final ServiceInformationCode FIS = new ServiceInformationCode("FIS"); // A service provided for the purpose of giving advice and information useful for the safe and efficient conduct of flights.
	public static final ServiceInformationCode OFIS_VHF = new ServiceInformationCode("OFIS_VHF"); // VHF operational flight information service (OFIS) broadcasts, as defined by the ICAO Annex 11.
	public static final ServiceInformationCode OFIS_HF = new ServiceInformationCode("OFIS_HF"); // HF operational flight information service (OFIS) broadcasts, as defined by the ICAO Annex 11.
	public static final ServiceInformationCode NOTAM = new ServiceInformationCode("NOTAM"); // Provision of NOTAM service, as defined by ICAO Annex 15.
	public static final ServiceInformationCode INFO = new ServiceInformationCode("INFO"); // Limited ad-hoc information provision, about a specific activity at a particular location.
	public static final ServiceInformationCode RAF = new ServiceInformationCode("RAF"); // Regional area forecasting service.
	public static final ServiceInformationCode METAR = new ServiceInformationCode("METAR"); // Aviation routine weather report
	public static final ServiceInformationCode SIGMET = new ServiceInformationCode("SIGMET"); // Information issued by a meteorological watch office concerning the occurrence or expected occurrence of specified en-route weather phenomena which may affect the safety of aircraft operations.
	public static final ServiceInformationCode TWEB = new ServiceInformationCode("TWEB"); // Transcribed weather broadcast service.
	public static final ServiceInformationCode TAF = new ServiceInformationCode("TAF"); // Terminal area meteorological forecast service.
	public static final ServiceInformationCode VOLMET = new ServiceInformationCode("VOLMET"); // Meteorological information for aircraft in flight broadcast service.
	public static final ServiceInformationCode ALTIMETER = new ServiceInformationCode("ALTIMETER"); // Altimeter setting information provision service.
	public static final ServiceInformationCode ASOS = new ServiceInformationCode("ASOS"); // Automated Surface Observation System 
	public static final ServiceInformationCode AWOS = new ServiceInformationCode("AWOS"); // Automated Weather Observation Service
	
	private String value;
	
	public ServiceInformationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ServiceInformationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
