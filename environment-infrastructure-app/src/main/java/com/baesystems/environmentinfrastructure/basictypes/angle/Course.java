package com.baesystems.environmentinfrastructure.basictypes.angle;

public class Course {
	
	private Angle angle;
	private Angle magneticVariation;
	private CourseType reference;
	
	public Angle getTrueTrack() {
		// magneticBearing = trueBearing + magneticVariation
		// magneticVariation > 0 for west variation
		if(reference == CourseType.TRUE_TRACK) {
			return angle;
		} else {
			return angle.subtract(magneticVariation);
		}
	}

	public CourseType getReference() {
		return reference;
	}
	
	public Course(Angle angle, CourseType reference, Angle magneticVariation) {
		this.angle = angle;
		this.reference = reference;
		this.magneticVariation = magneticVariation;
	}

	public Course getReciprocal() {
		return new Course(angle.getRecip(), reference, magneticVariation);
	}
	
	public String toString() {
		if(reference == CourseType.TRUE_TRACK) {
			return angle + "T";
		} else {
			return angle + "M (" + getTrueTrack() + "T)";
		}
	}
}
