package com.baesystems.midas.symbols;

import java.util.ArrayList;
import java.util.List;

import com.baesystems.midas.ClampToGround;
import com.baesystems.midas.listeners.IObjectListener;

import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.BasicShapeAttributes;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.Path;
import gov.nasa.worldwind.render.ShapeAttributes;

/**
 * @author graham.lund
 *
 */
public final class VehicleSymbol implements ISymbol, IObjectListener {

	private static final ShapeAttributes STICK_ATTRIBUES = makeStickAttributes();

	private VehicleIcon icon = null;
    private Path stick = new Path();

	private RenderableLayer layer;

	public VehicleSymbol(RenderableLayer layer, com.baesystems.midas.Object object) {
		this.layer = layer;

		icon = new VehicleIcon(object);
		icon.setHeading(Angle.ZERO);
		icon.setPitch(Angle.ZERO);
		icon.setRoll(Angle.ZERO);		
		layer.addRenderable(icon);

		stick.setAttributes(STICK_ATTRIBUES);

		positionUpdated(object.getPosition());

		object.addObjectListener(this);

		ClampToGround.getInstance().register(this);
	}

	private static ShapeAttributes makeStickAttributes() {
		ShapeAttributes attr = new BasicShapeAttributes();
		attr.setOutlineMaterial(Material.WHITE);
		attr.setOutlineOpacity(0.25);
		return attr;
	}

	@Override
	public void positionUpdated(Position position) {
		icon.setPosition(position);

		List<Position> positions = new ArrayList<>();
		positions.add(position);
		positions.add(new Position(position, 0));
		stick.setPositions(positions);
	}

	@Override
	public void headingUpdated(Angle heading) {
		icon.setHeading(heading);
	}

	@Override
	public void setClampToGround(boolean clampToGround) {
		if(clampToGround) {
			layer.removeRenderable(stick);
		} else {
			layer.addRenderable(stick);
		}
	}

	@Override
    public void dispose() {
        layer.removeRenderable(icon);
        layer.removeRenderable(stick);
    }

	@Override
	public void statusChanged(boolean isProblem, String status) {
		// ignore
	}
}
