package com.baesystems.environmentinfrastructure.geospatial;

import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;
import com.baesystems.environmentinfrastructure.basictypes.angle.ArcDirection;
import com.baesystems.environmentinfrastructure.basictypes.angle.BearingType;
import com.baesystems.environmentinfrastructure.basictypes.distance.Distance;
import com.baesystems.environmentinfrastructure.basictypes.position.GeoPoint2D;

public class Sector {

	private ArcDirection arcDirection;
	private BearingType angleType;
	private Angle fromAngle;
	private Angle toAngle;
	private Distance innerDistance;
	private Distance outerDistance;
	private GeoPoint2D centre;
	
	public ArcDirection getArcDirection() {
		return arcDirection;
	}

	public BearingType getAngleType() {
		return angleType;
	}

	public Angle getFromAngle() {
		return fromAngle;
	}

	public Angle getToAngle() {
		return toAngle;
	}

	public Distance getInnerDistance() {
		return innerDistance;
	}

	public Distance getOuterDistance() {
		return outerDistance;
	}
	
	public GeoPoint2D getCentre() {
		return centre;
	}

	public Sector(ArcDirection arcDirection, BearingType angleType, Angle fromAngle, Angle toAngle, Distance innerDistance, Distance outerDistance, GeoPoint2D centre) {
		this.arcDirection = arcDirection;
		this.angleType = angleType;
		this.fromAngle = fromAngle;
		this.toAngle = toAngle;
		this.innerDistance = innerDistance;
		this.outerDistance = outerDistance;
		this.centre = centre;
	}
}
