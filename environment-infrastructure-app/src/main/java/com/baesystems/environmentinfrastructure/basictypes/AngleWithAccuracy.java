package com.baesystems.environmentinfrastructure.basictypes;

import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;

public class AngleWithAccuracy {
	private Angle angle;
	private Angle accuracy;

	public Angle getAngle() {
		return angle;
	}
	public Angle getAccuracy() {
		return accuracy;
	}
	
	public AngleWithAccuracy(Angle angle, Angle accuracy) {
		this.angle = angle;
		this.accuracy = accuracy;
	}
	
	public String toString() {
		if(accuracy != null) {
			return angle + " (accuracy: " + accuracy + ")";
		} else {
			return angle.toString();
		}
	}
}
