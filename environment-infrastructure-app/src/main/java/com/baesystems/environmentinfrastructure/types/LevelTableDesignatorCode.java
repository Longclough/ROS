package com.baesystems.environmentinfrastructure.types;

public class LevelTableDesignatorCode {
	// A code identifying the table of discreet cruising levels.For example, ICAO IFR, ICAO VFR, ICAO RVSM, etc..
	public static final LevelTableDesignatorCode IFR = new LevelTableDesignatorCode("IFR"); // ICAO IFR
	public static final LevelTableDesignatorCode IFR_METRES = new LevelTableDesignatorCode("IFR_METRES"); // ICAO IFR in meters.
	public static final LevelTableDesignatorCode VFR = new LevelTableDesignatorCode("VFR"); // ICAO VFR
	public static final LevelTableDesignatorCode VFR_METRES = new LevelTableDesignatorCode("VFR_METRES"); // ICAO VFR in meters
	public static final LevelTableDesignatorCode IFR_RVSM = new LevelTableDesignatorCode("IFR_RVSM"); // ICAO IFR in areas with RVSM
	public static final LevelTableDesignatorCode IFR_METRES_RVSM = new LevelTableDesignatorCode("IFR_METRES_RVSM"); // ICAO IFR in meters in areas with RVSM
	public static final LevelTableDesignatorCode VFR_RVMS = new LevelTableDesignatorCode("VFR_RVMS"); // ICAO VFR in areas with RVSM.
	public static final LevelTableDesignatorCode VFR_METRES_RVSM = new LevelTableDesignatorCode("VFR_METRES_RVSM"); // ICAO VFR in meters in areas with RVSM.
	
	private String value;
	
	public LevelTableDesignatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LevelTableDesignatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
