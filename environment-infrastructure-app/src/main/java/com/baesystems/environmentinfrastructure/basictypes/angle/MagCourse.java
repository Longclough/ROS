package com.baesystems.environmentinfrastructure.basictypes.angle;

public class MagCourse extends Course {
	
	public MagCourse(Angle angle, Angle magneticVariation) {
		super(angle, CourseType.MAG_BRG, magneticVariation);
	}

}
