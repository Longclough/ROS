package com.baesystems.midas;

import java.util.ArrayList;
import java.util.List;

import com.baesystems.midas.listeners.IObjectListener;
import com.baesystems.midas.listeners.IRouteListener;

import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;

public class Object {

    private int id;
    private Position position;
    private ObjectType type;

    private List<Position> routepoints = new ArrayList<>();
    private List<IObjectListener> objectListeners = new ArrayList<>();
    private List<IRouteListener> routeListeners = new ArrayList<>();

    public Object(int id, ObjectType type, Position position) {
        this.id = id;
        this.type = type;
        System.out.println("object of type " + this.type + " created with id " + id);

        this.position = position;
    }

    public void routeUpdated(List<Position> routepoints) {         
        this.routepoints = routepoints;
        for(IRouteListener routeListener : routeListeners) {
            routeListener.routeUpdated(routepoints);
        }
    }

    public void deleted() {         
        Messaging.getInstance().deleteObject(id);
    }

    public void notifyPosition(Position position) {
        Messaging.getInstance().setObjectPosition(id, position);
    }

    public ObjectType getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        for(IObjectListener objectListener : objectListeners) {
            objectListener.positionUpdated(position);
        }
    }

    public void setHeading(Angle heading) {
        for(IObjectListener objectListener : objectListeners) {
            objectListener.headingUpdated(heading);
        }
    }

    public void addObjectListener(IObjectListener objectListener) {
        this.objectListeners.add(objectListener);
    }

    public void addRouteListener(IRouteListener routeListener) {
        this.routeListeners.add(routeListener);
    }

    public void routepointCaptured() {
        routepoints.remove(0);
        for(IRouteListener routeListener : routeListeners) {
            routeListener.routeUpdated(routepoints);
        }
    }

    public void statusChanged(boolean isProblem, String status) {        
        for(IObjectListener objectListener : objectListeners) {
            objectListener.statusChanged(isProblem, status);
        }
    }

    public String getName() {
        return type.getName() + " " + id;
    }
}
