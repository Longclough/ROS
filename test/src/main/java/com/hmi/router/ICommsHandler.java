package com.hmi.router;

import gov.nasa.worldwind.geom.Position;

public interface ICommsHandler {

    void createObject(ObjectType type, Position position);

    void deleteObject(int objectId);

    void plan();

    void setObjectPosition(int objectId, Position position);

    void setRate(int rate);

    void selectOption(String group, String option);

    void kill();

}
