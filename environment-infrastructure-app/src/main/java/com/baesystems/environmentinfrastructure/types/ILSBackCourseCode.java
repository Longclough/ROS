package com.baesystems.environmentinfrastructure.types;

public class ILSBackCourseCode {
	// A code indicating the usability of the localizer signal in the back-course sector.
	public static final ILSBackCourseCode YES = new ILSBackCourseCode("YES"); // Yes.
	public static final ILSBackCourseCode NO = new ILSBackCourseCode("NO"); // No.
	public static final ILSBackCourseCode RSTR = new ILSBackCourseCode("RSTR"); // Restricted.
	
	private String value;
	
	public ILSBackCourseCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ILSBackCourseCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
