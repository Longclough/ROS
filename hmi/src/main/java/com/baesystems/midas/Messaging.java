package com.baesystems.midas;

import gov.nasa.worldwind.geom.Position;

public class Messaging implements ICommsHandler {

    private static Messaging instance;

    public static Messaging getInstance() {
        if (instance == null) {
            instance = new Messaging();
        }
        return instance;
    }

    private ICommsHandler commsHandler;

    public Messaging() {
    }

    public void setCommsHandler(ICommsHandler commsHandler) {
        this.commsHandler = commsHandler;
    }

    @Override
    public void createObject(ObjectType type, Position position) {
        commsHandler.createObject(type, position);
    }

    @Override
    public void deleteObject(int objectId) {
        commsHandler.deleteObject(objectId);
    }

    @Override
    public void plan() {
        commsHandler.plan();
    }

    @Override
    public void setObjectPosition(int objectId, Position position) {
        commsHandler.setObjectPosition(objectId, position);
    }

    @Override
    public void setRate(int rate) {
        commsHandler.setRate(rate);
    }

    @Override
    public void selectOption(String group, String option) {
        commsHandler.selectOption(group, option);
    }

    public ICommsHandler getCommsHandler() {
        return commsHandler;
    }

    public void kill() {
        commsHandler.kill();
    }
}
