package com.baesystems.midas.symbols;

import java.util.ArrayList;
import java.util.List;

import com.baesystems.midas.ClampToGround;
import com.baesystems.midas.Object;
import com.baesystems.midas.listeners.IRouteListener;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.BasicShapeAttributes;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.Offset;
import gov.nasa.worldwind.render.Path;
import gov.nasa.worldwind.render.PointPlacemark;
import gov.nasa.worldwind.render.PointPlacemarkAttributes;
import gov.nasa.worldwind.render.ShapeAttributes;
import gov.nasa.worldwindx.examples.util.DirectedPath;

/**
 * @author graham.lund
 *
 */
public final class RouteSymbol implements IRouteListener, ISymbol
{
	private static final ShapeAttributes STICK_ATTRIBUTES = makeStickAttributes();
	private static final ShapeAttributes ROUTE_ATTRIBUTES = makeRouteAttributes();
	
	private static final PointPlacemarkAttributes ROUTEPOINT_ATTRIBUTES = makeRoutepointAttributes("resources/routepoint.png");
	private static final PointPlacemarkAttributes CURRENT_ROUTEPOINT_ATTRIBUTES = makeRoutepointAttributes("resources/current_routepoint.png");

    private DirectedPath route = new DirectedPath();	
    private List<Path> sticks = new ArrayList<>();
    private List<PointPlacemark> points = new ArrayList<>();
	private RenderableLayer layer;
	
	public RouteSymbol(RenderableLayer layer, Object object) {
		this.layer = layer;
        route.setAttributes(ROUTE_ATTRIBUTES);
        route.setFollowTerrain(true);
        layer.addRenderable(route);

		object.addRouteListener(this);

		ClampToGround.getInstance().register(this);
	}

	private static PointPlacemarkAttributes makeRoutepointAttributes(final String icon) {
		PointPlacemarkAttributes attr = new PointPlacemarkAttributes();
		attr.setImageAddress(icon);
		attr.setImageOffset(Offset.fromFraction(0.5, 0.5));
		return attr;
	}

	private static ShapeAttributes makeRouteAttributes() {
		ShapeAttributes attr = new BasicShapeAttributes();
        attr.setOutlineMaterial(Material.MAGENTA);
		return attr;
	}

	private static ShapeAttributes makeStickAttributes() {
		ShapeAttributes attr = new BasicShapeAttributes();
        attr.setOutlineMaterial(Material.MAGENTA);
		attr.setOutlineOpacity(0.25);
		return attr;
	}

	@Override
	public void routeUpdated(List<Position> routepoints) {
		for(PointPlacemark point : points) {
			layer.removeRenderable(point);
		}
		points.clear();

		for(Path stick : sticks) {
			layer.removeRenderable(stick);
		}
		sticks.clear();

		for(Position routepoint : routepoints) {
			Path stick = new Path();
			stick.setAttributes(STICK_ATTRIBUTES);
			List<Position> positions = new ArrayList<>();
			positions.add(routepoint);
			positions.add(new Position(routepoint, 0));
			stick.setPositions(positions);
			sticks.add(stick);
	
			PointPlacemark point = new PointPlacemark(routepoint);
			point.setAttributes(routepoints.indexOf(routepoint) == 1 ? CURRENT_ROUTEPOINT_ATTRIBUTES : ROUTEPOINT_ATTRIBUTES);
			points.add(point);
		}

		route.setPositions(routepoints);

		setClampToGround(ClampToGround.getInstance().isClampToGround());
	}

	@Override
	public void setClampToGround(boolean clampToGround) {
		for(Path stick : sticks) {
			if(clampToGround) {
				layer.removeRenderable(stick);
			} else {
				layer.addRenderable(stick);
			}
		}
		for(PointPlacemark point : points) {
			point.setAltitudeMode(clampToGround ? WorldWind.CLAMP_TO_GROUND : WorldWind.ABSOLUTE);
		}
		route.setAltitudeMode(clampToGround ? WorldWind.CLAMP_TO_GROUND : WorldWind.ABSOLUTE);
	}

	@Override
    public void dispose() {
        layer.removeRenderable(route);
		for(Path stick : sticks) {
			layer.removeRenderable(stick);
		}
		for(PointPlacemark point : points) {
			layer.removeRenderable(point);
		}
		route = null;
		points.clear();
		sticks.clear();
    }
}
