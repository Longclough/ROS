package com.baesystems.midas.listeners;

import java.util.List;

import com.baesystems.midas.ConstraintKind;

import gov.nasa.worldwind.geom.Position;

public class ConstraintsListeners extends Listeners<IConstraintsListener> implements IConstraintsListener {
    private static ConstraintsListeners instance;

    public static ConstraintsListeners getInstance() {
        if (instance == null) {
            instance = new ConstraintsListeners();
        }
        return instance;
    }

    @Override
    public void createExtrudedPolygon(int constraintId, List<Position> positions, double lowerBound, double upperBound,
            ConstraintKind kind) {
        for (IConstraintsListener listener : listeners) {
            listener.createExtrudedPolygon(constraintId, positions, lowerBound, upperBound, kind);
        }
    }

    @Override
    public void createPolygon(int constraintId, List<Position> positions, ConstraintKind kind) {
        for (IConstraintsListener listener : listeners) {
            listener.createPolygon(constraintId, positions, kind);
        }
    }

    @Override
    public void createCylinder(int constraintId, Position centre, double radius, double lowerBound, double upperBound,
            ConstraintKind kind) {
        for (IConstraintsListener listener : listeners) {
            listener.createCylinder(constraintId, centre, radius, lowerBound, upperBound, kind);
        }
    }

    @Override
    public void createCircle(int constraintId, Position centre, double radius, ConstraintKind kind) {
        for (IConstraintsListener listener : listeners) {
            listener.createCircle(constraintId, centre, radius, kind);
        }
    }

    @Override
    public void deleteConstraint(int constraintId) {
        for (IConstraintsListener listener : listeners) {
            listener.deleteConstraint(constraintId);
        }
    }
}
