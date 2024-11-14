package com.baesystems.environmentinfrastructure.types;

import java.util.Objects;

public class AirspaceCode {
	// A coded list of values that indicates a type of airspace.
	public static final AirspaceCode NAS = new AirspaceCode("NAS"); // National Airspace System.[note: The airspace within which a State provides Air Traffic Services is usually composed of:1) the territories over which the State has jurisdiction;2) those portions of the airspace over the high seas or in airspace of undetermined sovereignty where the provision of ATS are provided as determined by regional agreements. It can usually be determined by the UNION of FIRs (including, where appropriate, NO-FIRs) of the UNION of NAS-P. .] 
	public static final AirspaceCode FIR = new AirspaceCode("FIR"); // Flight information region.  Airspace of defined dimensions within which flight information service and alerting service are provided.Description:ICAO Recognized.Might, for example, be used if service provided by more than one unit.
	public static final AirspaceCode FIR_P = new AirspaceCode("FIR_P"); // Part of an FIR.
	public static final AirspaceCode UIR = new AirspaceCode("UIR"); // Upper flight information region.  An upper airspace of defined dimensions within which flight information service and alerting service are provided.Description:Non-ICAO Recognized.Each state determines its definition for upper airspace.
	public static final AirspaceCode UIR_P = new AirspaceCode("UIR_P"); // Part of a UIR.[note: Might, for example, be used if more than one unites provide service in different parts of a UIR .] 
	public static final AirspaceCode CTA = new AirspaceCode("CTA"); // Control area.  A controlled airspace extending upwards from a specified limit above the earth.Description:ICAO Recognized.
	public static final AirspaceCode CTA_P = new AirspaceCode("CTA_P"); // Part of a CTA.
	public static final AirspaceCode OCA_P = new AirspaceCode("OCA_P"); // Part of an OCA.
	public static final AirspaceCode OCA = new AirspaceCode("OCA"); // Oceanic control area.  A Control Area extending upwards in the upper airspace.Description:Non-ICAO Recognized.
	public static final AirspaceCode UTA = new AirspaceCode("UTA"); // Upper control area.  A Control Area extending upwards in the upper airspace.Description:Non-ICAO Recognized.
	public static final AirspaceCode UTA_P = new AirspaceCode("UTA_P"); // Part of a UTA.
	public static final AirspaceCode TMA = new AirspaceCode("TMA"); // Terminal control area.  Control area normally established at the confluence of ATS routes in the vicinity of one or more major aerodromes.Description:Non-ICAO Recognized.Mainly used in Europe under the Flexible Use of Airspace concept.
	public static final AirspaceCode TMA_P = new AirspaceCode("TMA_P"); // Part of a TMA.
	public static final AirspaceCode CTR = new AirspaceCode("CTR"); // Control zone.  A controlled airspace extending upwards from the surface of the earth to a specified upper limit.Description:ICAO Recognized.
	public static final AirspaceCode CTR_P = new AirspaceCode("CTR_P"); // Part of a CTR.
	public static final AirspaceCode OTA = new AirspaceCode("OTA"); // Oceanic transition area.
	public static final AirspaceCode SECTOR = new AirspaceCode("SECTOR"); // Control sector.  A subdivision of a designated control area within which responsibility is assigned to one controller or to a small group of controllers.Description:ICAO Recognized.
	public static final AirspaceCode SECTOR_C = new AirspaceCode("SECTOR_C"); // Temporary consolidated (collapsed) sector.
	public static final AirspaceCode TSA = new AirspaceCode("TSA"); // Temporary segregated area (FUA).  Airspace of pre-defined dimensions within which activities require the reservation of airspace for the exclusive use of specific users during a predetermined period of time.Description:(NATO) An area in which there are special restrictive measures employed to prevent or minimize interference between friendly forces. An area under military jurisdiction in which special security measures are employed to prevent unauthorized entry.
	public static final AirspaceCode CBA = new AirspaceCode("CBA"); // Cross border area (FUA).  Airspace of defined dimensions, above the land areas or territorial waters of more than one state.Description:Non-ICAO Recognized.Mainly used in Europe under the Flexible Use of Airspace concept.
	public static final AirspaceCode RCA = new AirspaceCode("RCA"); // Reduced co-ordination area (FUA).  Portion of airspace of defined dimensions within which general aviation traffic is permitted "off-route" without requiring general aviation traffic controllers to initiate co-ordination with OAT controllers.Description:Non-ICAO Recognized.Mainly used in Europe under the Flexible Use of Airspace concept.
	public static final AirspaceCode RAS = new AirspaceCode("RAS"); // Regulated airspace (not otherwise covered).
	public static final AirspaceCode AWY = new AirspaceCode("AWY"); // Airway (corridor).  A control area or portion thereof established in the form of a corridor.
	public static final AirspaceCode MTR = new AirspaceCode("MTR"); // Military Training Route buffer.  A control area or portion thereof, established in the form of a corridor around a military training route in order to protect it from other traffic.
	public static final AirspaceCode P = new AirspaceCode("P"); // Prohibited area.  Airspace of defined dimensions, above the land areas or territorial waters of a State, within which the flight of aircraft is prohibited.Description:ICAO Recognized.
	public static final AirspaceCode R = new AirspaceCode("R"); // Restricted area.  Airspace of defined dimensions, above the land areas or territorial waters of a State, within which the flight of aircraft is restricted in accordance with certain specified conditions.Description:ICAO Recognized.
	public static final AirspaceCode D = new AirspaceCode("D"); // Danger area.  Airspace of defined dimensions within which activities dangerous to the flight of aircraft may exist at specified times.Description:ICAO Recognized.
	public static final AirspaceCode ADIZ = new AirspaceCode("ADIZ"); // Air Defence Identification Zone.  Special designated airspace of defined dimensions within which aircraft are required to comply with special identification and/or reporting procedures additional to those related to the provision of air traffic services (ATS).Description:ICAO Recognized.
	public static final AirspaceCode NO_FIR = new AirspaceCode("NO_FIR"); // Airspace for which not even an FIR is defined.[note: There are parts in the world for which there is neither an FIR nor any other airspace-type is defined. These airspaces will be marked as NO-FIR .]  
	public static final AirspaceCode PART = new AirspaceCode("PART"); // Part of an airspace (used in airspace aggregation).
	public static final AirspaceCode CLASS = new AirspaceCode("CLASS"); // Airspace having a specified class.
	public static final AirspaceCode POLITICAL = new AirspaceCode("POLITICAL"); // Political/administrative area.
	public static final AirspaceCode D_OTHER = new AirspaceCode("D_OTHER"); // Activities of dangerous nature (other than a danger area).
	public static final AirspaceCode TRA = new AirspaceCode("TRA"); // Temporary reserved area (FUA).  Airspace of pre-defined dimensions within which activities require the reservation of airspace during a predetermined period of time.Description:Non-ICAO Recognized.Mainly used in Europe under the Flexible Use of Airspace concept.
	public static final AirspaceCode A = new AirspaceCode("A"); // Alert area. Airspace which may contain a high volume of pilot training activities or unusual type of aerial activity, neither of which is hazardous to aircraft.Description:Non-ICAO Recognized.Mainly used in contiguous United States and its territories. 
	public static final AirspaceCode W = new AirspaceCode("W"); // Warning area.  A non-regulatory airspace of defined dimensions designated over international waters that contains activity which may be hazardous to aircraft not participating in the activity. The purpose of such warning areas is to warn non participating pilots of the potential danger.Description:Non-ICAO Recognized.Mainly used in contiguous United States and its territories.
	public static final AirspaceCode PROTECT = new AirspaceCode("PROTECT"); // Airspace protected from specific air traffic.
	public static final AirspaceCode AMA = new AirspaceCode("AMA"); // Minimum altitude area.  The lowest altitude to be used under instrument meteorological conditions (IMC) which will provide a minimum vertical clearance of 300 m (1 000 ft) or in designated mountainous terrain 600 m (2 000 ft) above all obstacles located in the area specified.Description:ICAO Recognized.Published by many States as rectangles of 1 x 1 degree on the ENR 6 charts. Note - In the exact calculation 984 feet can be used as an equivalent to 300 metres. 
	public static final AirspaceCode ASR = new AirspaceCode("ASR"); // Altimeter setting region.  Airspace of defined dimensions within which standardized altimeter setting procedures apply.Description:Non-ICAO Recognized.For example, during flight the altimeter shall be set to the current altimeter setting of the nearest station along the route of flight.
	public static final AirspaceCode ADV = new AirspaceCode("ADV"); // Advisory Area.  An area of defined dimensions within which air traffic advisory service is available.Description:ICAO Recognized.Air traffic control service provides a much more complete service than air traffic advisory service; advisory areas and routes are therefore not established within controlled airspace, but air traffic advisory service may be provided below and above. 
	public static final AirspaceCode UADV = new AirspaceCode("UADV"); // Upper Advisory Area.  An area of defined dimensions in upper airspace within which air traffic advisory service is available.Description:ICAO Recognized.Air traffic control service provides a much more complete service than air traffic advisory service; advisory areas and routes are therefore not established within controlled airspace, but air traffic advisory service may be provided below and above. 
	public static final AirspaceCode ATZ = new AirspaceCode("ATZ"); // Airport Traffic Zone.  Airspace of defined dimensions established around an airport for the protection of airport traffic.Description:ICAO Recognized.
	public static final AirspaceCode ATZ_P = new AirspaceCode("ATZ_P"); // Part of an airport traffic zone
	public static final AirspaceCode HTZ = new AirspaceCode("HTZ"); // Helicopter traffic zone
	public static final AirspaceCode NAS_P = new AirspaceCode("NAS_P"); // A part of a national airspace system
	
	private String value;
	
	public AirspaceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirspaceCode other = (AirspaceCode) obj;
		return Objects.equals(value, other.value);
	}
}
