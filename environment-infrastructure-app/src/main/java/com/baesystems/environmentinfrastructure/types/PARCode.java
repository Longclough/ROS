package com.baesystems.environmentinfrastructure.types;

public class PARCode {
	// Type of Precision Approach Radar equipment.
	public static final PARCode FPN16 = new PARCode("FPN16"); // Made by Raytheon. Range 15 miles. QKH1811 coaxial Magnetron. Similar to CPN-4 and MPN-11.
	public static final PARCode FPN62 = new PARCode("FPN62"); // Made by Raytheon. Range 15 miles. QKH1811 coaxial Magnetron. Known as Normal PAR.. The version produced for Britain is called Falconner. Replaced CPN-4 and FPN-16.
	public static final PARCode GPN22 = new PARCode("GPN22"); // Made by Raytheon. Derived from TPN-25. HIPAR = High  Performance Precision Approach Radar. 20 mile range on 1 metre target. Can track 6 targets at once.
	public static final PARCode GPN25 = new PARCode("GPN25"); // Made by Raytheon. Fixed base version of TPN-25. Part of TPN-19 Air Traffic Control System.
	public static final PARCode MPN14K = new PARCode("MPN14K"); // Made by ITT Gillfilan. Mobile ATC radar for military use. Comprises two Radars, a PAR with 2 x 80Kw Transmitters in I/J Band, and an approach Surveillance Radar with dual 1Mw Transmitters in
	public static final PARCode TPN19 = new PARCode("TPN19"); // Built by Raytheon.  Described in some sources as launching control, having two Radars; Surveillance and PAR.  TPN-24 and TPN-25.
	
	private String value;
	
	public PARCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof PARCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
