package com.baesystems.midas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baesystems.midas.Object;
import com.baesystems.midas.ObjectType;
import com.baesystems.midas.Application.AppFrame;
import com.baesystems.midas.listeners.ILifecycleListener;
import com.baesystems.midas.listeners.IObjectsListener;
import com.baesystems.midas.listeners.LifecycleListeners;
import com.baesystems.midas.listeners.ObjectsListeners;
import com.baesystems.midas.symbols.ISymbol;
import com.baesystems.midas.symbols.ObjectIcon;
import com.baesystems.midas.symbols.RouteSymbol;
import com.baesystems.midas.symbols.VehicleSymbol;

import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;

public class ObjectController implements IObjectsListener, ILifecycleListener {

    private Map<Integer, Object> objects = new HashMap<>();

    private RenderableLayer layer;

    private Map<Integer, ISymbol> objectSymbols = new HashMap<>();
    private Map<Integer, ISymbol> routeSymbols = new HashMap<>();

    public ObjectController(AppFrame appFrame) {
        ObjectsListeners.getInstance().registerListener(this);        
        LifecycleListeners.getInstance().registerListener(this);   
        layer = appFrame.createLayer("Objects");
    }

    @Override
    public void routeUpdated(int objectId, List<Position> routepoints) {
        Object object = objects.get(objectId);
        if (object != null) {
            object.routeUpdated(routepoints);
        }
    }

    @Override
    public void objectCreated(int objectId, ObjectType type, Position position) {
        Object object = new Object(objectId, type, position);
        objects.put(objectId, object);

        if ("VEHICLE".equals(type.getName())) {
            objectSymbols.put(objectId, new VehicleSymbol(layer, object));
        } else {
            objectSymbols.put(objectId, new ObjectIcon(layer, object));
        }
        routeSymbols.put(objectId, new RouteSymbol(layer, object));
    }

    @Override
    public void objectMoved(int objectId, Position position, Angle heading) {
        Object object = objects.get(objectId);
        if (object != null) {
            object.setPosition(position);   
            object.setHeading(heading);
        }
    }

    @Override
    public void objectDeleted(int objectId) {
        ISymbol objectSymbol = objectSymbols.get(objectId);
        ISymbol routeSymbol = routeSymbols.get(objectId);
        if (objectSymbol != null && routeSymbol != null) {
            objects.remove(objectId);
            objectSymbol.dispose();
            routeSymbol.dispose();
        }
    }

    @Override
    public void routepointCaptured(int objectId) {
        Object object = objects.get(objectId);
        if (object != null) {
            object.routepointCaptured();
        }
    }

    @Override
    public void reset() {
        for(ISymbol symbol : this.objectSymbols.values()) {
            symbol.dispose();
        }
        this.objectSymbols.clear();
        this.objects.clear();    
    }

    @Override
    public void statusChanged(int objectId, boolean isProblem, String status) {
        Object object = objects.get(objectId);
        if (object != null) {
            object.statusChanged(isProblem, status);
        }
    }
}
