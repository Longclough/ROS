package com.baesystems.environmentinfrastructure.basictypes.position;

import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;
import com.baesystems.environmentinfrastructure.basictypes.angle.AngleUnit;

public class Longitude extends Angle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Longitude() {
		super();
	}
	
	public Longitude(double value, AngleUnit unit) {
		super(value, unit);
	}
	
	public Longitude(Angle longitude) {
		super(longitude.getAngleInDegrees(), AngleUnit.DEGREES);
	}

}