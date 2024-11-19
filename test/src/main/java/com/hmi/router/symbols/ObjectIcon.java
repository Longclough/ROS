package com.hmi.router.symbols;

import java.util.HashMap;
import java.util.Map;

import com.hmi.router.ClampToGround;
import com.hmi.router.ObjectType;
import com.hmi.router.listeners.IObjectListener;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.Offset;
import gov.nasa.worldwind.render.PointPlacemark;
import gov.nasa.worldwind.render.PointPlacemarkAttributes;

/**
 * @author anon
 *
 */
public final class ObjectIcon extends PointPlacemark implements IDraggable, IDeletable, ISymbol, IObjectListener
{
	private static final Map<ObjectType, PointPlacemarkAttributes> attrs = new HashMap<>();
	private static final Map<ObjectType, PointPlacemarkAttributes> pAttrs = new HashMap<>();
	private static final Map<ObjectType, PointPlacemarkAttributes> hAttrs = new HashMap<>();

	private static final String RESOURCES = "resources/";

	static {
		for(ObjectType objectType : ObjectType.values()) {
			PointPlacemarkAttributes attr = new PointPlacemarkAttributes();
			attr.setImageAddress(RESOURCES + objectType.toString() + ".png");
			attr.setImageOffset(Offset.fromFraction(0.5, 0.5));
			attrs.put(objectType, attr);
			PointPlacemarkAttributes pAttr = new PointPlacemarkAttributes();
			pAttr.setImageAddress(RESOURCES + objectType.toString() + "_problem.png");
			pAttr.setImageOffset(Offset.fromFraction(0.5, 0.5));
			pAttrs.put(objectType, pAttr);
			PointPlacemarkAttributes hAttr = new PointPlacemarkAttributes();
			hAttr.setImageAddress(RESOURCES + objectType.toString() + "_highlighted.png");
			hAttr.setImageOffset(Offset.fromFraction(0.5, 0.5));
			hAttrs.put(objectType, hAttr);
		}
	}

	private com.hmi.router.Object object;
	private boolean dragging = false;
	private RenderableLayer layer;	

	public ObjectIcon(RenderableLayer layer, com.hmi.router.Object object) {
		super(object.getPosition());

		this.layer = layer;

		this.object = object;

		this.setHighlightAttributes(hAttrs.get(object.getType()));

		statusChanged(false, "");

		layer.addRenderable(this);

		object.addObjectListener(this);

		ClampToGround.getInstance().register(this);
	}

	@Override
	public void drop() {
		this.dragging = false;
		object.notifyPosition(this.getReferencePosition());
	}

	@Override
	public void delete() {
		object.deleted();
	}

	@Override
	public void positionUpdated(Position position) {
		if(!this.dragging) {
			this.setPosition(position);
		}
	}

	@Override
	public void headingUpdated(Angle heading) {
		// Not used
	}

	@Override
	public void setClampToGround(boolean clampToGround) {
		this.setAltitudeMode(clampToGround ? WorldWind.CLAMP_TO_GROUND : WorldWind.ABSOLUTE);
	}

	@Override
	public void startDrag() {
		this.dragging = true;
	}

	@Override
    public void dispose() {
        layer.removeRenderable(this);
    }

	@Override
	public void statusChanged(boolean isProblem, String status) {
		this.setAttributes(isProblem ? pAttrs.get(object.getType()) : attrs.get(object.getType()));
		this.setValue(AVKey.DISPLAY_NAME, object.getName() + System.lineSeparator() + status.split(":")[0]);
	}
}
