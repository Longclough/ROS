package com.baesystems.environmentinfrastructure.types;

public class OxygenCode {
	// A code describing the type of oxygen supplies for aviation usage.
	public static final OxygenCode LPOX = new OxygenCode("LPOX"); // Low pressure oxygen servicing.
	public static final OxygenCode HPOX = new OxygenCode("HPOX"); // High pressure oxygen servicing.
	public static final OxygenCode LHOX = new OxygenCode("LHOX"); // Low and high pressure oxygen servicing.
	public static final OxygenCode LOX = new OxygenCode("LOX"); // Liquid oxygen servicing.
	public static final OxygenCode OXRB = new OxygenCode("OXRB"); // Oxygen replacement bottles.
	public static final OxygenCode HOXRB = new OxygenCode("HOXRB"); // High pressure oxygen replacement bottles.
	public static final OxygenCode LOXRB = new OxygenCode("LOXRB"); // Low pressure oxygen replacement bottles.
	public static final OxygenCode OX = new OxygenCode("OX"); // Indicates oxygen servicing when type of servicing is unspecified.
	
	private String value;
	
	public OxygenCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof OxygenCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
