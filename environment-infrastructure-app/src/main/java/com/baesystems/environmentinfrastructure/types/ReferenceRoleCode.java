package com.baesystems.environmentinfrastructure.types;

public class ReferenceRoleCode {
	// A list describing the valid Point Reference makeups for use by navigation receivers.
	public static final ReferenceRoleCode INTERSECTION = new ReferenceRoleCode("INTERSECTION"); // An intersection is where two or more "things" cross.  An intersection will be the intersection of two angle indications or two distance indications (DME/DME fix).  The indications must reference different navaids.
	public static final ReferenceRoleCode RECNAV = new ReferenceRoleCode("RECNAV"); // The recommended navaid providing information for the segment.  Used for ARINC leg types that need navaid information other then what is supplied by standard angle and distance indications.
	public static final ReferenceRoleCode ATD = new ReferenceRoleCode("ATD"); // Along Track Distance.  Defined the distance along the guidance course to/from another significant point.
	public static final ReferenceRoleCode RAD_DME = new ReferenceRoleCode("RAD_DME"); // Defined by a bearing (angle indication) and a distance (distance Indication) from a navaid.
	
	private String value;
	
	public ReferenceRoleCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ReferenceRoleCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
