package com.baesystems.environmentinfrastructure.types;

public class GuidanceLineCode {
	// A code indicating the type of guidance line.
	public static final GuidanceLineCode RWY = new GuidanceLineCode("RWY"); // Taxi line on a runway surface, leading between the runway and other airport surfaces.
	public static final GuidanceLineCode TWY = new GuidanceLineCode("TWY"); // Taxi line on a taxiway surface, leading between the taxiway and other airport surfaces.
	public static final GuidanceLineCode APRON = new GuidanceLineCode("APRON"); // Taxi line on the apron surface.
	public static final GuidanceLineCode GATE_TLANE = new GuidanceLineCode("GATE_TLANE"); // Taxi line on the apron surface, leading to a gate/stand.
	public static final GuidanceLineCode LI_TLANE = new GuidanceLineCode("LI_TLANE"); // Lead-in taxi line.
	public static final GuidanceLineCode LO_TLANE = new GuidanceLineCode("LO_TLANE"); // Lead-out taxi line.
	public static final GuidanceLineCode AIR_TLANE = new GuidanceLineCode("AIR_TLANE"); // A virtual taxi line in the air, used by helicopters.
	
	private String value;
	
	public GuidanceLineCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof GuidanceLineCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
