package com.baesystems.environmentinfrastructure.types;

public class ApronElementCode {
	// A code indicating the type of Apron.
	public static final ApronElementCode NORMAL = new ApronElementCode("NORMAL"); // The default type.
	public static final ApronElementCode PARKING = new ApronElementCode("PARKING"); // Parking Stand Area (from AMDB)
	public static final ApronElementCode RAMP = new ApronElementCode("RAMP"); // Access pavement between maintenance hangers opening to the apron and the apron edge. (AirMAT)
	public static final ApronElementCode CARGO = new ApronElementCode("CARGO"); // Cargo Loading Area used for loading and unloading cargo. (AirMAT)
	public static final ApronElementCode FUEL = new ApronElementCode("FUEL"); // Area used for aircraft fuelling. (AirMAT)
	public static final ApronElementCode HARDSTAND = new ApronElementCode("HARDSTAND"); // Area for parking a single aircraft more temporary than a parking area (AirMAT)
	public static final ApronElementCode MAINT = new ApronElementCode("MAINT"); // Area used for aircraft maintenance. (AirMAT)
	public static final ApronElementCode MILITARY = new ApronElementCode("MILITARY"); // Apron used by military (AirMAT)
	public static final ApronElementCode LOADING = new ApronElementCode("LOADING"); // Passenger loading area used for loading/unloading of passengers (AirMAT)
	public static final ApronElementCode TAXILANE = new ApronElementCode("TAXILANE"); // Area where plane is still under terminal control (airline dispatched) as opposed to tower control. (AirMAT)
	public static final ApronElementCode TURNAROUND = new ApronElementCode("TURNAROUND"); // Area for aircraft to turn around (AirMAT)
	public static final ApronElementCode TEMPORARY = new ApronElementCode("TEMPORARY"); // Temporary
	public static final ApronElementCode STAIRS = new ApronElementCode("STAIRS"); // Stairs
	
	private String value;
	
	public ApronElementCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ApronElementCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
