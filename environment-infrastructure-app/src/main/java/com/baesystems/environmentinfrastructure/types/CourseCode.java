package com.baesystems.environmentinfrastructure.types;

public class CourseCode {
	// A code indicating the type of course to be observed.For example, true track, magnetic track, heading, VOR radial, true bearing, magnetic bearing.
	public static final CourseCode TRUE_TRACK = new CourseCode("TRUE_TRACK"); // True track.
	public static final CourseCode MAG_TRACK = new CourseCode("MAG_TRACK"); // Magnetic track.
	public static final CourseCode TRUE_BRG = new CourseCode("TRUE_BRG"); // True bearing.
	public static final CourseCode MAG_BRG = new CourseCode("MAG_BRG"); // Magnetic bearing.
	public static final CourseCode HDG = new CourseCode("HDG"); // Heading.
	public static final CourseCode RDL = new CourseCode("RDL"); // VOR radial.
	
	private String value;
	
	public CourseCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof CourseCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
