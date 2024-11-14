/*
 * Copyright (C) 2012 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration.
 * All Rights Reserved.
 */
package com.baesystems.midas;

import gov.nasa.worldwind.*;
import gov.nasa.worldwind.event.*;
import gov.nasa.worldwind.geom.*;
import gov.nasa.worldwind.globes.Globe;
import gov.nasa.worldwind.util.Logging;

import java.awt.*;

import com.baesystems.midas.symbols.IDeletable;
import com.baesystems.midas.symbols.IDraggable;

/**
 * @author Patrick Murris
 * @version $Id: BasicDragger.java 1171 2013-02-11 21:45:02Z dcollins $
 */
public class Dragger implements SelectListener {
    private final WorldWindow wwd;
    private boolean dragging = false;
    private boolean useTerrain = true;
    private boolean deleteModeActive = false;

    public boolean isDeleteModeActive() {
        return deleteModeActive;
    }

    public void setDeleteModeActive(boolean bool) {
        deleteModeActive = bool;
    }

    private Point dragRefCursorPoint;
    private Vec4 dragRefObjectPoint;
    private double dragRefAltitude;

    public Dragger(WorldWindow wwd) {
        if (wwd == null) {
            String msg = Logging.getMessage("nullValue.WorldWindow");
            Logging.logger().severe(msg);
            throw new IllegalArgumentException(msg);
        }

        this.wwd = wwd;
    }

    public Dragger(WorldWindow wwd, boolean useTerrain) {
        if (wwd == null) {
            String msg = Logging.getMessage("nullValue.WorldWindow");
            Logging.logger().severe(msg);
            throw new IllegalArgumentException(msg);
        }

        this.wwd = wwd;
        this.setUseTerrain(useTerrain);
    }

    public boolean isUseTerrain() {
        return useTerrain;
    }

    public void setUseTerrain(boolean useTerrain) {
        this.useTerrain = useTerrain;
    }

    public boolean isDragging() {
        return this.dragging;
    }

    public void selected(SelectEvent event) {
        if (event == null) {
            String msg = Logging.getMessage("nullValue.EventIsNull");
            Logging.logger().severe(msg);
            throw new IllegalArgumentException(msg);
        }

        if (deleteModeActive) {
            handleSelectEventInDeleteMode(event);
        } else {
            handleSelectEventInDragMode(event);
        }
    }

    private void handleSelectEventInDragMode(SelectEvent event) {
        if (event.getEventAction().equals(SelectEvent.ROLLOVER)) {
            if (isDragging()) {
                return;
            }
            java.lang.Object topObject = event.getTopObject();
            if (!(topObject instanceof IDraggable)) {
                CursorManager.getInstance().unhover();
            } else {
                CursorManager.getInstance().hover();
            }
        } else if (event.getEventAction().equals(SelectEvent.DRAG_END)) {
            drop((DragSelectEvent) event);
        } else if (event.getEventAction().equals(SelectEvent.DRAG)) {
            drag((DragSelectEvent) event);
        }
    }

    private void handleSelectEventInDeleteMode(SelectEvent event) {
        java.lang.Object topObject = event.getTopObject();
        if (event.getEventAction().equals(SelectEvent.ROLLOVER)) {            
            if (!(topObject instanceof IDeletable)) {
                CursorManager.getInstance().unhover();
            } else {
                CursorManager.getInstance().hover();
            }
        } else if (event.getEventAction().equals(SelectEvent.LEFT_CLICK)) {
            if (!(topObject instanceof IDeletable)) {
                return;
            }

            IDeletable deletable = (IDeletable) topObject;
            deletable.delete();
        }
    }

    private void drop(DragSelectEvent dragEvent) {
        CursorManager.getInstance().endDrag();
        this.dragging = false;
        dragEvent.consume();

        java.lang.Object topObject = dragEvent.getTopObject();

        if (!(topObject instanceof IDraggable))
            return;

        IDraggable draggable = (IDraggable) topObject;
        draggable.drop();
    }

    private void drag(DragSelectEvent dragEvent) {
        java.lang.Object topObject = dragEvent.getTopObject();
        if (topObject == null)
            return;

        if (!(topObject instanceof IDraggable))
            return;

        IDraggable dragObject = (IDraggable) topObject;
        View view = wwd.getView();
        Globe globe = wwd.getModel().getGlobe();

        // Compute dragged object ref-point in model coordinates.
        // Use the Icon and Annotation logic of elevation as offset above ground when
        // below max elevation.
        Position refPos = dragObject.getReferencePosition();
        if (refPos == null)
            return;

        Vec4 refPoint = globe.computePointFromPosition(refPos);

        if (!this.isDragging()) // Dragging started
        {
            CursorManager.getInstance().startDrag();
            dragObject.startDrag();
            // Save initial reference points for object and cursor in screen coordinates
            // Note: y is inverted for the object point.
            this.dragRefObjectPoint = view.project(refPoint);
            // Save cursor position
            this.dragRefCursorPoint = dragEvent.getPreviousPickPoint();
            // Save start altitude
            this.dragRefAltitude = globe.computePositionFromPoint(refPoint).getElevation();
        }

        // Compute screen-coord delta since drag started.
        int dx = dragEvent.getPickPoint().x - this.dragRefCursorPoint.x;
        int dy = dragEvent.getPickPoint().y - this.dragRefCursorPoint.y;

        // Find intersection of screen coord (refObjectPoint + delta) with globe.
        double x = this.dragRefObjectPoint.x + dx;
        double y = dragEvent.getMouseEvent().getComponent().getSize().height - this.dragRefObjectPoint.y + dy - 1;
        Line ray = view.computeRayFromScreenPoint(x, y);
        Position pickPos = null;
        // Use intersection with sphere at reference altitude.
        Intersection[] inters = globe.intersect(ray, this.dragRefAltitude);
        if (inters != null)
            pickPos = globe.computePositionFromPoint(inters[0].getIntersectionPoint());

        if (pickPos != null) {
            // Intersection with globe. Move reference point to the intersection point,
            // but maintain current altitude.
            Position p = new Position(pickPos, dragObject.getReferencePosition().getElevation());
            dragObject.moveTo(p);
        }
        this.dragging = true;
        dragEvent.consume();
    }
}