package com.hmi.router;

import gov.nasa.worldwind.geom.Position;

public class Waypoint {
    private int id;
    private Position position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
