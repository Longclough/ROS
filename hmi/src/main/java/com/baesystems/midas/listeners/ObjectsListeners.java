package com.baesystems.midas.listeners;

import java.util.List;

import javax.swing.SwingUtilities;

import com.baesystems.midas.ObjectType;

import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;

public class ObjectsListeners extends Listeners<IObjectsListener> implements IObjectsListener {
    private static ObjectsListeners instance;

    public static ObjectsListeners getInstance() {
        if (instance == null) {
            instance = new ObjectsListeners();
        }
        return instance;
    }

    @Override
    public void objectCreated(int objectId, ObjectType type, Position position) {
        for (IObjectsListener listener : listeners) {
            listener.objectCreated(objectId, type, position);
        }
    }

    @Override
    public void routeUpdated(int objectId, List<Position> routepoints) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (IObjectsListener listener : listeners) {
                    listener.routeUpdated(objectId, routepoints);
                }
            }
        });
    }

    @Override
    public void objectMoved(int objectId, Position position, Angle heading) {
        for (IObjectsListener listener : listeners) {
            listener.objectMoved(objectId, position, heading);
        }
    }

    @Override
    public void routepointCaptured(int objectId) {
        for (IObjectsListener listener : listeners) {
            listener.routepointCaptured(objectId);
        }
    }

    @Override
    public void objectDeleted(int objectId) {
        for (IObjectsListener listener : listeners) {
            listener.objectDeleted(objectId);
        }
    }

    @Override
    public void statusChanged(int objectId, boolean isProblem, String status) {
        for (IObjectsListener listener : listeners) {
            listener.statusChanged(objectId, isProblem, status);
        }
    }
}
