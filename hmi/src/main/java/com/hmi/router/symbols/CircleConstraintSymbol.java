package com.hmi.router.symbols;

import com.hmi.router.ConstraintKind;
import com.hmi.router.controllers.ConstraintController;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.Renderable;
import gov.nasa.worldwind.render.SurfaceCircle;

public class CircleConstraintSymbol implements ISymbol {

    private Renderable clamped;
    private RenderableLayer layer;

    public CircleConstraintSymbol(RenderableLayer layer, ConstraintKind kind, Position centre, double radius) {
        this.layer = layer;
        SurfaceCircle circle = new SurfaceCircle(centre, radius);
        circle.setAttributes(ConstraintController.getShapeAttributes(kind));
        circle.setHighlightAttributes(circle.getAttributes());
        clamped = circle;

        layer.addRenderable(clamped);
    }

    @Override
    public void setClampToGround(boolean clampToGround) {
        // do nothing
    }

    @Override
    public void dispose() {
        layer.removeRenderable(clamped);
        clamped = null;
    }
}
