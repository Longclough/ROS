package com.baesystems.environmentinfrastructure.types;

public class AltitudeUseCode {
	// A code indicating, in situations where both an upper and a lower altitude may be specified, how the altitude information should be interpreted.
	public static final AltitudeUseCode ABOVE_LOWER = new AltitudeUseCode("ABOVE_LOWER"); // At or above the lower altitude.
	public static final AltitudeUseCode BELOW_UPPER = new AltitudeUseCode("BELOW_UPPER"); // At or below the higher altitude.
	public static final AltitudeUseCode AT_LOWER = new AltitudeUseCode("AT_LOWER"); // At the lower altitude.
	public static final AltitudeUseCode BETWEEN = new AltitudeUseCode("BETWEEN"); // Between the lower and the upper altitude.
	public static final AltitudeUseCode RECOMMENDED = new AltitudeUseCode("RECOMMENDED"); // Lower altitude is recommended.
	public static final AltitudeUseCode EXPECT_LOWER = new AltitudeUseCode("EXPECT_LOWER"); // Expect lower altitude by ATC.
	public static final AltitudeUseCode AS_ASSIGNED = new AltitudeUseCode("AS_ASSIGNED"); // To be assigned at the time of operations (for example, by ATC)
	
	private String value;
	
	public AltitudeUseCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AltitudeUseCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
