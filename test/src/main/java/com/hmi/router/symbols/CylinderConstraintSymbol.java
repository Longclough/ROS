package com.hmi.router.symbols;

import com.hmi.router.ClampToGround;
import com.hmi.router.ConstraintKind;
import com.hmi.router.controllers.ConstraintController;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.Renderable;
import gov.nasa.worldwind.render.SurfaceCircle;
import gov.nasa.worldwind.render.airspaces.CappedCylinder;

public class CylinderConstraintSymbol implements ISymbol {

    private Renderable clamped;
    private Renderable unclamped;
    private RenderableLayer layer;

    public CylinderConstraintSymbol(RenderableLayer layer, ConstraintKind kind, Position centre, double radius,
            double lowerBound, double upperBound) {
        this.layer = layer;
        
        CappedCylinder cylinder = new CappedCylinder(centre, radius);
        cylinder.setAltitudes(lowerBound, upperBound);
        cylinder.setAttributes(ConstraintController.getAirspaceAttributes(kind));
        unclamped = cylinder;

        SurfaceCircle circle = new SurfaceCircle(centre, radius);
        circle.setAttributes(ConstraintController.getShapeAttributes(kind));
        circle.setHighlightAttributes(circle.getAttributes());
        clamped = circle;

        ClampToGround.getInstance().register(this);

        layer.addRenderable(clamped);
    }

    @Override
    public void setClampToGround(boolean clampToGround) {
        if(clampToGround) {       
            layer.removeRenderable(unclamped);
        } else {
            layer.addRenderable(unclamped);
        }
    }

    @Override
    public void dispose() {
        layer.removeRenderable(clamped);
        layer.removeRenderable(unclamped);
        clamped = null;
        unclamped = null;
    }
}
