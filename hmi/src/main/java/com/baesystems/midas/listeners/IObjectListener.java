package com.baesystems.midas.listeners;

import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;

public interface IObjectListener {
	public void positionUpdated(Position position);
	public void headingUpdated(Angle heading);
	public void statusChanged(boolean isProblem, String status);
}
