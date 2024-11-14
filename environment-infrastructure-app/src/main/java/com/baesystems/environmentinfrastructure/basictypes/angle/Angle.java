package com.baesystems.environmentinfrastructure.basictypes.angle;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Angle implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final Angle Angle0 = new Angle(0, AngleUnit.DEGREES);
	public static final Angle Angle90 = new Angle(90, AngleUnit.DEGREES);
	public static final Angle Angle180 = new Angle(180, AngleUnit.DEGREES);
	
	private double angleInDegrees;
	
	public double inDegrees() { return angleInDegrees; }
	public double inRadians() { return angleInDegrees * Math.PI / 180; }
	
	public double getAngleInDegrees() { return angleInDegrees; }
	public void setAngleInDegrees(double angleInDegrees) { this.angleInDegrees = angleInDegrees; }
	
	private transient boolean angleSet = false;
	
	public Angle() {
		angleInDegrees = 0;
	}
	
	public Angle(double value, AngleUnit unit)
	{
		switch(unit)
		{
			case RADIANS:
				angleInDegrees = value * 180 / Math.PI;
				angleSet = true;
				break;
			case DEGREES:
				angleInDegrees = value;
				angleSet = true;
				break;
		}
	}
	
	public boolean isValid() {
		return angleSet;
	}
	
	public Angle subtract(Angle angle) {
		return new Angle (this.inDegrees() - angle.inDegrees(), AngleUnit.DEGREES);
	}
	
	public Angle add(Angle angle) {
		return new Angle (this.inDegrees() + angle.inDegrees(), AngleUnit.DEGREES);
	}
	
	public Angle getRecip()
	{
		return this.subtract(Angle180);
	}
	
	public Angle getNormalized() {
        if (angleInDegrees >= 180.0)
        {
            double div = (angleInDegrees + 180.0) / 360.0;
            div = Math.floor(Math.abs(div)) * Math.signum(div); // Math.Truncate in c#
            return new Angle(angleInDegrees - (div * 360.0), AngleUnit.DEGREES);
        }
        else if (angleInDegrees < -180.0)
        {
            double div = (-angleInDegrees + 180.0) / 360.0;
            div = Math.floor(Math.abs(div)) * Math.signum(div); // Math.Truncate in c#
            return new Angle(angleInDegrees + (div * 360.0), AngleUnit.DEGREES);
        }
        return this;
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(angleInDegrees) + "�";
	}
	
	public static Angle fromDegrees(double angleInDegrees) {
		return new Angle(angleInDegrees, AngleUnit.DEGREES);
	}
	
	public Angle make0To360() {
		if (angleInDegrees < 0) {
			return Angle.fromDegrees(360 + angleInDegrees);
		} else if (angleInDegrees > 360) {
			return Angle.fromDegrees(angleInDegrees - 360);
		} else {
			return this;
		}
	}
	
	public static boolean angleChangeIsLessThan(Angle fromAngle, Angle toAngle, Angle lessThan) {
		Angle deltaAngle = fromAngle.subtract(toAngle);
		if(deltaAngle.inDegrees() < 0) {
			deltaAngle = deltaAngle.make0To360();
		}
		if(deltaAngle.inDegrees() > 180) {
			deltaAngle = Angle.fromDegrees(360).subtract(deltaAngle);
		}
		
		if(Math.abs(deltaAngle.inDegrees()) < lessThan.inDegrees()) {
//			System.out.println("TRUE " + fromAngle + " " + toAngle + " " + deltaAngle);
			return true;
		} else {
//			System.out.println("FALSE " + fromAngle + " " + toAngle + " " + deltaAngle);
			return false;
		}	
	}
	
	public boolean equals(Angle angle) {
		return this.inDegrees() == angle.inDegrees();
	}
}
