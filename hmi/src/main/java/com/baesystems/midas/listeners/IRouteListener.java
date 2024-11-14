package com.baesystems.midas.listeners;

import java.util.List;

import gov.nasa.worldwind.geom.Position;

public interface IRouteListener {
    public void routeUpdated(List<Position> routepoints);
}
