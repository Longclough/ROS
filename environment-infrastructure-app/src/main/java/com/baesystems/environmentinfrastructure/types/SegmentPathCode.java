package com.baesystems.environmentinfrastructure.types;

public class SegmentPathCode {
	// A code that defines a specific type of flight path and a specific type of termination of that flight path. Although we agree with the ARINC idea that procedures should be designed with the aim to permit FMS equipped aircraft to fly tracks instead of procedural headings, for the time being we must allow all representation of these procedures (especially reversal procedures) as they are published by the States. This is the explanation of the differences between the allowable values for attributes in this domain and the ARINC leg types.
	public static final SegmentPathCode AF = new SegmentPathCode("AF"); // (ARINC) constant DME arc to a fix.
	public static final SegmentPathCode HF = new SegmentPathCode("HF"); // (ARINC) hold pattern terminating at a fix after one circuit.
	public static final SegmentPathCode HA = new SegmentPathCode("HA"); // (ARINC) hold pattern term. at fix after reach. an altitude.
	public static final SegmentPathCode HM = new SegmentPathCode("HM"); // (ARINC) holding pattern terminating manually.
	public static final SegmentPathCode IF = new SegmentPathCode("IF"); // (ARINC) initial fix.
	public static final SegmentPathCode PI = new SegmentPathCode("PI"); // (ARINC) procedure turn followed by a course to a fix (CF).
	public static final SegmentPathCode PT = new SegmentPathCode("PT"); // (non ARINC) timed outbound leg to a procedure turn.
	public static final SegmentPathCode TF = new SegmentPathCode("TF"); // (ARINC) track between two fixes.
	public static final SegmentPathCode CA = new SegmentPathCode("CA"); // (ARINC) course to an altitude.
	public static final SegmentPathCode CD = new SegmentPathCode("CD"); // (ARINC) course to a DME distance.
	public static final SegmentPathCode CI = new SegmentPathCode("CI"); // (ARINC) course to next leg followed by course oriented leg.
	public static final SegmentPathCode CR = new SegmentPathCode("CR"); // (ARINC) course to a radial termination.
	public static final SegmentPathCode CF = new SegmentPathCode("CF"); // (ARINC) course to a fix.
	public static final SegmentPathCode DF = new SegmentPathCode("DF"); // (ARINC) Computed track direct to a fix.
	public static final SegmentPathCode FA = new SegmentPathCode("FA"); // (ARINC) course from a fix to an altitude.
	public static final SegmentPathCode FC = new SegmentPathCode("FC"); // (ARINC) course from a fix to a distance.
	public static final SegmentPathCode FT = new SegmentPathCode("FT"); // (non ARINC) course from a fix during a specified time.
	public static final SegmentPathCode FM = new SegmentPathCode("FM"); // (ARINC) course from a fix to a manual termination.
	public static final SegmentPathCode VM = new SegmentPathCode("VM"); // (ARINC) heading to a manual termination.
	public static final SegmentPathCode FD = new SegmentPathCode("FD"); // (ARINC) course from a fix to a DME distance.
	public static final SegmentPathCode VR = new SegmentPathCode("VR"); // (ARINC) heading to a radial termination.
	public static final SegmentPathCode VD = new SegmentPathCode("VD"); // (ARINC) heading to a DME distance.
	public static final SegmentPathCode VI = new SegmentPathCode("VI"); // (ARINC) heading to next leg.
	public static final SegmentPathCode VA = new SegmentPathCode("VA"); // (ARINC) heading to an altitude (position unspecified).
	public static final SegmentPathCode RF = new SegmentPathCode("RF"); // (ARINC) constant radius to a fix.
	
	private String value;
	
	public SegmentPathCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SegmentPathCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
