package com.baesystems.midas.listeners;

import java.util.List;

import com.baesystems.midas.ConstraintKind;

import gov.nasa.worldwind.geom.Position;

public interface IConstraintsListener {

    void createExtrudedPolygon(int constraintId, List<Position> positions, double lowerBound, double upperBound, ConstraintKind kind);

    void createPolygon(int constraintId, List<Position> positions, ConstraintKind kind);

    void createCylinder(int constraintId, Position centre, double radius, double lowerBound, double upperBound, ConstraintKind kind);

    void createCircle(int constraintId, Position centre, double radius, ConstraintKind kind);

    void deleteConstraint(int constraintId);
}
