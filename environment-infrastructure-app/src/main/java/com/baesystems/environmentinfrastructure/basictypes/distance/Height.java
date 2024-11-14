package com.baesystems.environmentinfrastructure.basictypes.distance;

public class Height extends Distance {

	private static final long serialVersionUID = 1L;
	public static Height sfc  = new Height(0, DistanceUnit.METRES, AltitudeReference.SFC);
	public static Height zero = new Height(0, DistanceUnit.METRES, AltitudeReference.MSL);
	public static Height max  = new Height(99999, DistanceUnit.METRES, AltitudeReference.MSL);
	private AltitudeReference reference;
	
	public Height() {
		super();
	}
	
	public Height(double value, DistanceUnit unit, AltitudeReference reference) {
		super(value, unit);
		this.reference = reference;
	}

	public Height(Height value) {
		super(value.inMetres(), DistanceUnit.METRES);
	}
	
	public Height(Distance value, AltitudeReference reference) {
		super(value.inMetres(), DistanceUnit.METRES);
		this.reference = reference;
	}

	public boolean isValid() {
		return distanceSet;
	}
	
	public AltitudeReference getReference() {
		return reference;
	}
	
	public double getMAMSL() {
		return inMetres();
	}
	
	public double getFtAMSL() {
		return inFeet();
	}
	
	public double getMRelative() {
		return inMetres(); //rel conversion
	}


	public static Height fromMMSL(double m) {
		return fromM(m, AltitudeReference.MSL);
	}
	
	public static Height fromM(double m, AltitudeReference ref) {
		return new Height(m, DistanceUnit.METRES, ref);
	}

	public static Height fromFtQFE(double ft) {
		return fromFt(ft, AltitudeReference.QFE);
	}
	
	public static Height fromFtMSL(double ft) {
		return fromFt(ft, AltitudeReference.MSL);
	}
	
	public static Height fromFt(double ft, AltitudeReference ref) {
		return new Height(ft, DistanceUnit.FEET, ref);
	}
	
	public Height add(Height height) {
		return Height.fromMMSL(this.getMAMSL() + height.getMAMSL());
	}
	
	public Height subtract(Height height) {
		return Height.fromMMSL(this.getMAMSL() - height.getMAMSL());
	}
	
	public Height multiply(double multiplier) {
		return Height.fromMMSL(this.getMAMSL() * multiplier);
	}

	public static boolean bandsOverlap(Height upperLimit1, Height lowerLimit1, Height upperLimit2, Height lowerLimit2) {
		if(lowerLimit1.inMetres() > upperLimit2.inMetres() || lowerLimit2.inMetres() > upperLimit1.inMetres()) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean equals(Object object) {
		if(object instanceof Height) {
			Height otherHeight = (Height) object;
			return otherHeight.getMAMSL() == this.getMAMSL();
		} else {
			return false;
		}
	}
	
	public String toString() {
		return getFtAMSL() + "ft";
	}
}
