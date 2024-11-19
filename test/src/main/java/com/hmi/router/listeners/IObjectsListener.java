package com.hmi.router.listeners;

import java.util.List;

import com.hmi.router.ObjectType;

import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;

public interface IObjectsListener {

    void objectCreated(int objectId, ObjectType type, Position position);

    void routeUpdated(int objectId, List<Position> routepoints);

    void objectMoved(int objectId, Position position, Angle heading);

    void objectDeleted(int objectId);

    void routepointCaptured(int objectId);

    void statusChanged(int objectId, boolean isProblem, String status);

}
