package com.baesystems.environmentinfrastructure.types;

public class SpecialNavigationStationCode {
	// A code indicating the type of service provided by a station in a special navigation system chain, depending on the type of the system.
	public static final SpecialNavigationStationCode MASTER = new SpecialNavigationStationCode("MASTER"); // Master station of a LORAN or DECCA chain.
	public static final SpecialNavigationStationCode SLAVE = new SpecialNavigationStationCode("SLAVE"); // LORAN slave.
	public static final SpecialNavigationStationCode RED_SLAVE = new SpecialNavigationStationCode("RED_SLAVE"); // Red slave station of a DECCA chain.
	public static final SpecialNavigationStationCode GREEN_SLAVE = new SpecialNavigationStationCode("GREEN_SLAVE"); // Green slave station of a DECCA chain.
	public static final SpecialNavigationStationCode PURPLE_SLAVE = new SpecialNavigationStationCode("PURPLE_SLAVE"); // Purple slave station of a DECCA chain.
	
	private String value;
	
	public SpecialNavigationStationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SpecialNavigationStationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
