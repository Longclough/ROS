package com.baesystems.environmentinfrastructure.basictypes.angle;

public class Bearing {
	private Angle angle;
	private BearingType reference;
	private Angle magneticVariation;
	
	public Angle getTrueBearing() {
		// magneticBearing = trueBearing + magneticVariation
		// magneticVariation > 0 for west variation
		if(reference == BearingType.TRUE) {
			return angle;
		} else {
			return angle.subtract(magneticVariation);
		}
	}
	
	public Angle getMagneticBearing() throws Exception {
		if(reference == BearingType.MAG) {
			return angle;
		} else {
			throw new Exception("Not a magnetic bearing");
		}
	}

	public BearingType getReference() {
		return reference;
	}
	
	public Bearing(Angle angle, BearingType reference, Angle magneticVariation) throws Exception {
		this.angle = angle;
		this.reference = reference;
		this.magneticVariation = magneticVariation;
		if(reference == BearingType.MAG && magneticVariation == null) {
			throw new Exception("No magnetic variation set for magnetic bearing");
		}
	}
	
	public String toString() {
		if(reference == BearingType.TRUE) {
			return angle + "T";
		} else {
			return angle + "M";
		}
	}
}
