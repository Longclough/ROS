/*
 * The purpose of this class is to notify the ObjectsListeners class
 * when certain events have taken place, such as, objects being created, 
 * moved or deleted, and planning/replanning a route when each of these 
 * events occurs.
 */
package com.baesystems.midas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import com.baesystems.midas.listeners.ObjectsListeners;

import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;

public class RestCommsHandler implements ICommsHandler {

    private static final int VEHICLE_ID = 0;
    private static AtomicInteger waypointId = new AtomicInteger(1);
    private static Map<Integer, Waypoint> waypoints = new TreeMap<>();

    private Position vehPosition;
    private RoutesApi routesApi;
    private ObjectsListeners objectsListeners;

    public RestCommsHandler() {
        this.routesApi = new RoutesApi(this);
        this.objectsListeners = ObjectsListeners.getInstance();
    }

    @Override
    public void createObject(ObjectType type, Position position) {
        // this method is only assigning a valid id to the given object types
        // and notifying the hmi of object creation,
        // sending the request to the simulator is the long term solution
        int id = -1;
        if (type == ObjectType.get("VEHICLE")) {
            vehPosition = position;
            id = VEHICLE_ID;
        } else if (type == ObjectType.get("WAYPOINT")) {
            Waypoint waypoint = new Waypoint();
            waypoint.setId(waypointId.get());
            waypoint.setPosition(position);
            waypoints.put(waypointId.get(), waypoint);

            id = waypointId.getAndIncrement();
        }
        objectsListeners.objectCreated(id, type, position);
        plan();
        // TODO Later - Notify the sim of vehicle creation
    }

    @Override
    public void plan() {
        try {
            List<Waypoint> waypointList = new ArrayList<>(waypoints.values());
            routesApi.calculateRoute(vehPosition, waypointList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void routeUpdated(List<Position> routepoints) {
        objectsListeners.routeUpdated(VEHICLE_ID, routepoints);
    }

    @Override
    public void setObjectPosition(int objectId, Position position) {
        if (objectId == VEHICLE_ID) {
            vehPosition = position;
        } else if (waypoints.containsKey(objectId)) {
            waypoints.get(objectId).setPosition(position);
        }
        objectsListeners.objectMoved(objectId, position, Angle.ZERO);
        plan();
        // TODO Later - Notify the sim of vehicle position changes
    }

    @Override
    public void setRate(int rate) {
        // TODO Later - Notify the sim
        throw new UnsupportedOperationException("Unimplemented method 'setRate'");
    }

    @Override
    public void selectOption(String group, String option) {
        throw new UnsupportedOperationException("Unimplemented method 'selectOption'");
    }

    @Override
    public void deleteObject(int objectId) {
        waypoints.remove(objectId);
        objectsListeners.objectDeleted(objectId);
        plan();
    }

    @Override
    public void kill() {
        routesApi.kill();
    }
}
