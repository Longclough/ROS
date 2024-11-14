package com.baesystems.environmentinfrastructure.basictypes;

import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;

public class MagneticVariation {
	private AngleWithAccuracy angle;
	private Double change;
	private Integer year;
	
	public AngleWithAccuracy getAngle() {
		return angle;
	}
	
	public Double getChange() {
		return change;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public MagneticVariation(Angle angle, Angle accuracy, Integer year) {
		this.angle = new AngleWithAccuracy(angle, accuracy);
		this.change = 0.0;
		this.year = year;
	}
	
	public MagneticVariation(Angle angle, Angle accuracy, Double change, Integer year) {
		this.angle = new AngleWithAccuracy(angle, accuracy);
		this.change = change;
		this.year = year;
	}
	
	public String toString() {
		return angle + " (" + change + " " + year + ")";
	}
}
