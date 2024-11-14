package com.baesystems.environmentinfrastructure.types;

public class UsageLimitationCode {
	// A code indicating whether a limitation is of type permission, interdiction or exclusive usage.
	public static final UsageLimitationCode PERMIT = new UsageLimitationCode("PERMIT"); // Permission.
	public static final UsageLimitationCode CONDITIONAL = new UsageLimitationCode("CONDITIONAL"); // Permission but with additional instructions. Failure to comply with the additional instructions invalidates the permission.
	public static final UsageLimitationCode FORBID = new UsageLimitationCode("FORBID"); // Interdiction.
	public static final UsageLimitationCode RESERV = new UsageLimitationCode("RESERV"); // Exclusive usage (reservation).
	
	private String value;
	
	public UsageLimitationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UsageLimitationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
