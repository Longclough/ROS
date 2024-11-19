package com.hmi.router.symbols;

import java.util.List;

import com.hmi.router.ClampToGround;
import com.hmi.router.ConstraintKind;
import com.hmi.router.controllers.ConstraintController;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.Renderable;
import gov.nasa.worldwind.render.SurfacePolygon;
import gov.nasa.worldwind.render.airspaces.Curtain;
import gov.nasa.worldwind.render.airspaces.Polygon;

public class ExtrudedPolygonConstraintSymbol implements ISymbol {

    private Renderable clamped;
    private Renderable unclamped;
    private RenderableLayer layer;

    public ExtrudedPolygonConstraintSymbol(RenderableLayer layer, ConstraintKind kind, 
            List<Position> positions, double lowerBound, double upperBound) {
        this.layer = layer;
        if (ConstraintKind.KEEP_IN.equals(kind)) {
            Curtain curtain = new Curtain(positions);
            curtain.setAltitudes(lowerBound, upperBound);
            curtain.setAttributes(ConstraintController.getAirspaceAttributes(kind));            
            this.unclamped = curtain;
        } else {
            Polygon polygon = new Polygon(positions);
            polygon.setAltitudes(lowerBound, upperBound);
            polygon.setAttributes(ConstraintController.getAirspaceAttributes(kind));
            this.unclamped = polygon;
        }

        SurfacePolygon surfacePolygon = new SurfacePolygon(positions);
        surfacePolygon.setAttributes(ConstraintController.getShapeAttributes(kind));
        surfacePolygon.setHighlightAttributes(surfacePolygon.getAttributes());
        this.clamped = surfacePolygon;

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
