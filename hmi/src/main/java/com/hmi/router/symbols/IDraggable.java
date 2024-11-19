package com.hmi.router.symbols;

import gov.nasa.worldwind.Movable;

public interface IDraggable extends Movable {
    void startDrag();
    void drop();
}
