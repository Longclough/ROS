package com.baesystems.environmentinfrastructure.types;

public class CourseQualityILSCode {
	// A coded value indicating the signal quality of the ILS course structure based on the location the precision signal is usable to, according to ICAO Annex 10, Volume I, Chapter 3.
	public static final CourseQualityILSCode A = new CourseQualityILSCode("A"); // Usable up to a point on the ILS glide path measured along the extended runway centre line in the approach direction to a distance of 7.5km (4NM) from the threshold.
	public static final CourseQualityILSCode B = new CourseQualityILSCode("B"); // Usable up to a point on the ILS glide path measured along the extended runway centre line in the approach direction to a distance of 1050m (3500ft) from the threshold.
	public static final CourseQualityILSCode C = new CourseQualityILSCode("C"); // Usable up to a point through which the downward extended straight portion of the nominal ILS glide path passes at a height of 30m (100ft) above the horizontal plane containing the threshold.
	public static final CourseQualityILSCode D = new CourseQualityILSCode("D"); // Usable up to a point 4m (12ft) above the runway centre line and 600m (2000ft) from the stop end of the runway in the direction of the threshold.
	public static final CourseQualityILSCode E = new CourseQualityILSCode("E"); // Usable up to a point at a specified height located above the intersection of the runway centre line and the threshold and through which the downward extended straight portion of the ILS glide path passes.
	public static final CourseQualityILSCode T = new CourseQualityILSCode("T"); // Usable up to a point 4m (12ft) above the runway centre line and 900m (3000ft) from the threshold in the direction of the localizer.
	
	private String value;
	
	public CourseQualityILSCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof CourseQualityILSCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
