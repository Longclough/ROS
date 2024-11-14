package com.baesystems.environmentinfrastructure.types;

public class VisualDockingGuidanceCode {
	// A coded list of values that indicate types of systems used at aircraft stands in order to help the pilot align and position the aircraft.
	public static final VisualDockingGuidanceCode AGNIS  = new VisualDockingGuidanceCode("AGNIS "); // Azimuth Guidance for Nose-In Stand, providing centreline guidance only by using two coloured lights mounted side by side.
	public static final VisualDockingGuidanceCode PAPA = new VisualDockingGuidanceCode("PAPA"); // Parallax Aircraft Parking Aid consisting of a large grey/black box that uses the effect of perspective in order to indicate the relative position of the aircraft along the centreline.
	public static final VisualDockingGuidanceCode SAFE_GATE = new VisualDockingGuidanceCode("SAFE_GATE"); // A type of A-VDGS that uses an aircraft symbol on a display indicating the relative position along the centreline.
	public static final VisualDockingGuidanceCode SAFE_DOC = new VisualDockingGuidanceCode("SAFE_DOC"); // Safe dock allows aircraft to park up to an accuracy of 10 cm using lasers to attain the aircraft's position.
	public static final VisualDockingGuidanceCode APIS = new VisualDockingGuidanceCode("APIS"); // Aircraft Positioning and Information System that shows azimuth information using a series of parallel and black bars which kink at their midpoint.
	public static final VisualDockingGuidanceCode A_VDGS = new VisualDockingGuidanceCode("A_VDGS"); // (Generic) Advanced Visual Docking Guidance System that features electronic displays which perform the functions of an AGNIS/PAPA installation, although with much greater accuracy.  They may also provide collision avoidance from static objects.
	public static final VisualDockingGuidanceCode AGNIS_STOP  = new VisualDockingGuidanceCode("AGNIS_STOP "); // AGNIS system complemented with a simple stop light, on the side of the AGNIS display.
	public static final VisualDockingGuidanceCode AGNIS_PAPA = new VisualDockingGuidanceCode("AGNIS_PAPA"); // Combined AGNIS and PAPA device.
	
	private String value;
	
	public VisualDockingGuidanceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof VisualDockingGuidanceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
