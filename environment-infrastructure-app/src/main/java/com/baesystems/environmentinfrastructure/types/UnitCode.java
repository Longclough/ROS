package com.baesystems.environmentinfrastructure.types;

public class UnitCode {
	// A unit providing particular ATS services.
	public static final UnitCode ACC = new UnitCode("ACC"); // Area control centre.
	public static final UnitCode ADSU = new UnitCode("ADSU"); // Automatic dependent surveillance unit.
	public static final UnitCode ADVC = new UnitCode("ADVC"); // Advisory centre.
	public static final UnitCode ALPS = new UnitCode("ALPS"); // Alerting post.
	public static final UnitCode AOF = new UnitCode("AOF"); // Aeronautical information services office.
	public static final UnitCode APP = new UnitCode("APP"); // Approach control office.
	public static final UnitCode APP_ARR = new UnitCode("APP_ARR"); // Arrivals approach control office.
	public static final UnitCode APP_DEP = new UnitCode("APP_DEP"); // Departures approach control office.
	public static final UnitCode ARO = new UnitCode("ARO"); // Aerodrome reporting office/ATS reporting office.
	public static final UnitCode ATCC = new UnitCode("ATCC"); // Air traffic control centre.
	public static final UnitCode ATFMU = new UnitCode("ATFMU"); // Air traffic flow management unit.
	public static final UnitCode ATMU = new UnitCode("ATMU"); // Air traffic management unit.
	public static final UnitCode ATSU = new UnitCode("ATSU"); // Air traffic services unit.
	public static final UnitCode BOF = new UnitCode("BOF"); // Briefing office (note: Note ICAO listed by nonetheless used.)
	public static final UnitCode BS = new UnitCode("BS"); // Commercial broadcasting station.
	public static final UnitCode COM = new UnitCode("COM"); // Communications office/centre.
	public static final UnitCode FCST = new UnitCode("FCST"); // Forecasting office.
	public static final UnitCode FIC = new UnitCode("FIC"); // Flight information centre.
	public static final UnitCode GCA = new UnitCode("GCA"); // Ground controlled approach systems office.
	public static final UnitCode MET = new UnitCode("MET"); // Meteorological office.
	public static final UnitCode MWO = new UnitCode("MWO"); // Meteorological watch office.
	public static final UnitCode NOF = new UnitCode("NOF"); // International NOTAM office.
	public static final UnitCode OAC = new UnitCode("OAC"); // Ocean control centre.
	public static final UnitCode PAR = new UnitCode("PAR"); // Precision approach radar centre.
	public static final UnitCode RAD = new UnitCode("RAD"); // Radar unit/office.
	public static final UnitCode RAFC = new UnitCode("RAFC"); // Regional area forecast centre.
	public static final UnitCode RCC = new UnitCode("RCC"); // Rescue co-ordination centre.
	public static final UnitCode RSC = new UnitCode("RSC"); // Rescue sub-centre.
	public static final UnitCode SAR = new UnitCode("SAR"); // Search and rescue centre.
	public static final UnitCode SMC = new UnitCode("SMC"); // Surface movement control office.
	public static final UnitCode SMR = new UnitCode("SMR"); // Surface movement radar office.
	public static final UnitCode SRA = new UnitCode("SRA"); // Surveillance radar approach office/centre.
	public static final UnitCode SSR = new UnitCode("SSR"); // Secondary surveillance radar office/centre.
	public static final UnitCode TAR = new UnitCode("TAR"); // Terminal area surveillance radar office/centre.
	public static final UnitCode TWR = new UnitCode("TWR"); // Aerodrome control tower.
	public static final UnitCode UAC = new UnitCode("UAC"); // Upper area control centre.
	public static final UnitCode UDF = new UnitCode("UDF"); // UHF direction finding station.
	public static final UnitCode UIC = new UnitCode("UIC"); // Upper information centre.
	public static final UnitCode VDF = new UnitCode("VDF"); // VHF direction finding station.
	public static final UnitCode WAFC = new UnitCode("WAFC"); // World area forecast centre.
	public static final UnitCode ARTCC = new UnitCode("ARTCC"); // Air route traffic control centre.
	public static final UnitCode FSS = new UnitCode("FSS"); // Flight service station.
	public static final UnitCode TRACON = new UnitCode("TRACON"); // Terminal radar approach control.
	public static final UnitCode MIL = new UnitCode("MIL"); // Military station/unit (or military office in general).
	public static final UnitCode MILOPS = new UnitCode("MILOPS"); // Planning/briefing office for military flight operations.
	
	private String value;
	
	public UnitCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UnitCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
