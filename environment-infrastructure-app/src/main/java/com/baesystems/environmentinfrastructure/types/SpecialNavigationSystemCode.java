package com.baesystems.environmentinfrastructure.types;

public class SpecialNavigationSystemCode {
	// A code indicating a type of special navigation system.For example, LORAN, DECCA, GNSS, etc.
	public static final SpecialNavigationSystemCode LORANA = new SpecialNavigationSystemCode("LORANA"); // Long range (area) navigation system A
	public static final SpecialNavigationSystemCode LORANC = new SpecialNavigationSystemCode("LORANC"); // Long range (area) navigation system C.
	public static final SpecialNavigationSystemCode LORAND = new SpecialNavigationSystemCode("LORAND"); // Long range (area) navigation system D.
	public static final SpecialNavigationSystemCode DECCA = new SpecialNavigationSystemCode("DECCA"); // Short and medium range (area) navigation system DECCA.
	public static final SpecialNavigationSystemCode GNSS = new SpecialNavigationSystemCode("GNSS"); // Global navigation satellite system.
	
	private String value;
	
	public SpecialNavigationSystemCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SpecialNavigationSystemCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
