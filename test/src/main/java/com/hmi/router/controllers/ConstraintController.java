package com.hmi.router.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hmi.router.ConstraintKind;
import com.hmi.router.Application.AppFrame;
import com.hmi.router.listeners.ConstraintsListeners;
import com.hmi.router.listeners.IConstraintsListener;
import com.hmi.router.listeners.ILifecycleListener;
import com.hmi.router.listeners.LifecycleListeners;
import com.hmi.router.symbols.CircleConstraintSymbol;
import com.hmi.router.symbols.CylinderConstraintSymbol;
import com.hmi.router.symbols.ExtrudedPolygonConstraintSymbol;
import com.hmi.router.symbols.ISymbol;
import com.hmi.router.symbols.PolygonConstraintSymbol;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.airspaces.AirspaceAttributes;
import gov.nasa.worldwind.render.airspaces.BasicAirspaceAttributes;
import gov.nasa.worldwind.render.BasicShapeAttributes;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.ShapeAttributes;

public class ConstraintController implements IConstraintsListener, ILifecycleListener {

    private static final AirspaceAttributes KEEP_IN_AIRSPACE_ATTRIBUTES = new BasicAirspaceAttributes();
    private static final AirspaceAttributes KEEP_OUT_AIRSPACE_ATTRIBUTES = new BasicAirspaceAttributes();
    private static final ShapeAttributes KEEP_IN_SHAPE_ATTRIBUTES;
    private static final ShapeAttributes KEEP_OUT_SHAPE_ATTRIBUTES;

    static {
        KEEP_IN_AIRSPACE_ATTRIBUTES.setDrawInterior(false);
        KEEP_IN_AIRSPACE_ATTRIBUTES.setDrawOutline(true);
        KEEP_IN_AIRSPACE_ATTRIBUTES.setOutlineMaterial(Material.GREEN);
        KEEP_IN_AIRSPACE_ATTRIBUTES.setInteriorMaterial(Material.GREEN);
        KEEP_IN_AIRSPACE_ATTRIBUTES.setInteriorOpacity(0.2);

        KEEP_OUT_AIRSPACE_ATTRIBUTES.setDrawInterior(true);
        KEEP_OUT_AIRSPACE_ATTRIBUTES.setDrawOutline(true);
        KEEP_OUT_AIRSPACE_ATTRIBUTES.setOutlineMaterial(Material.RED);
        KEEP_OUT_AIRSPACE_ATTRIBUTES.setInteriorMaterial(Material.RED);
        KEEP_OUT_AIRSPACE_ATTRIBUTES.setInteriorOpacity(0.2);

        KEEP_IN_SHAPE_ATTRIBUTES = toShapeAttributes(KEEP_IN_AIRSPACE_ATTRIBUTES);
        KEEP_OUT_SHAPE_ATTRIBUTES = toShapeAttributes(KEEP_OUT_AIRSPACE_ATTRIBUTES);
    }

    RenderableLayer layer;

    Map<Integer, ISymbol> symbols = new HashMap<>();

    public ConstraintController(AppFrame appFrame) {
        layer = appFrame.createLayer("Constraints");
        ConstraintsListeners.getInstance().registerListener(this);
        LifecycleListeners.getInstance().registerListener(this);
    }

    private static ShapeAttributes toShapeAttributes(AirspaceAttributes attributes) {
        ShapeAttributes shapeAttributes = new BasicShapeAttributes();
        shapeAttributes.setInteriorMaterial(attributes.getInteriorMaterial());
        shapeAttributes.setOutlineMaterial(attributes.getOutlineMaterial());
        shapeAttributes.setOutlineOpacity(attributes.getOutlineOpacity());
        shapeAttributes.setInteriorOpacity(attributes.getInteriorOpacity());
        shapeAttributes.setDrawInterior(attributes.isDrawInterior());
        shapeAttributes.setDrawOutline(attributes.isDrawOutline());
        return shapeAttributes;
    }

    public void createExtrudedPolygon(int constraintId, List<Position> positions, double lowerBound, double upperBound,
            ConstraintKind kind) {
        deleteConstraint(constraintId);
        symbols.put(constraintId, new ExtrudedPolygonConstraintSymbol(layer, kind, positions,
                lowerBound, upperBound));
    }

    public void createCylinder(int constraintId, Position centre, double radius, double lowerBound, double upperBound,
            ConstraintKind kind) {
        deleteConstraint(constraintId);
        symbols.put(constraintId, new CylinderConstraintSymbol(layer, kind, centre, radius, lowerBound, upperBound));
    }

    public void createCircle(int constraintId, Position centre, double radius,
            ConstraintKind kind) {
        deleteConstraint(constraintId);
        symbols.put(constraintId, new CircleConstraintSymbol(layer, kind, centre, radius));
    }

    public void createPolygon(int constraintId, List<Position> positions,
            ConstraintKind kind) {
        deleteConstraint(constraintId);
        symbols.put(constraintId, new PolygonConstraintSymbol(layer, kind, positions));
    }

    public static AirspaceAttributes getAirspaceAttributes(ConstraintKind kind) {
        return ConstraintKind.KEEP_IN.equals(kind) ? KEEP_IN_AIRSPACE_ATTRIBUTES : KEEP_OUT_AIRSPACE_ATTRIBUTES;
    }

    public static ShapeAttributes getShapeAttributes(ConstraintKind kind) {
        return ConstraintKind.KEEP_IN.equals(kind) ? KEEP_IN_SHAPE_ATTRIBUTES : KEEP_OUT_SHAPE_ATTRIBUTES;
    }

    @Override
    public void reset() {
        for (ISymbol symbol : this.symbols.values()) {
            symbol.dispose();
        }
        this.symbols.clear();
    }

    @Override
    public void deleteConstraint(int constraintId) {
        ISymbol symbol = symbols.get(constraintId);
        if (symbol != null) {
            symbols.remove(constraintId);
            symbol.dispose();
        }
    }
}