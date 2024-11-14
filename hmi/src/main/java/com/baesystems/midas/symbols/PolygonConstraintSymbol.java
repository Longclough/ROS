package com.baesystems.midas.symbols;

import java.util.List;

import com.baesystems.midas.ConstraintKind;
import com.baesystems.midas.controllers.ConstraintController;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.Renderable;
import gov.nasa.worldwind.render.SurfacePolygon;

public class PolygonConstraintSymbol implements ISymbol {

    private Renderable clamped;
    private RenderableLayer layer;

    public PolygonConstraintSymbol(RenderableLayer layer, ConstraintKind kind,
            List<Position> positions) {

        this.layer = layer;
        
        SurfacePolygon surfacePolygon = new SurfacePolygon(positions);
        surfacePolygon.setAttributes(ConstraintController.getShapeAttributes(kind));
        surfacePolygon.setHighlightAttributes(surfacePolygon.getAttributes());
        this.clamped = surfacePolygon;

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
