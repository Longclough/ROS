package com.baesystems.environmentinfrastructure.basictypes.position;

import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;
import com.baesystems.environmentinfrastructure.basictypes.angle.AngleUnit;

public class Latitude extends Angle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Latitude() {
		super();
	}
	
	public Latitude(double value, AngleUnit unit) {
		super(value, unit);
	}

	public Latitude(Angle latitude) {
		super(latitude.getAngleInDegrees(), AngleUnit.DEGREES);
	}

}