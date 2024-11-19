package com.hmi.router.listeners;

import com.hmi.router.Status;

public class StatusListeners extends Listeners<IStatusListener> implements IStatusListener {
    private static StatusListeners instance;

    public static StatusListeners getInstance() {
        if (instance == null) {
            instance = new StatusListeners();
        }
        return instance;
    }

    @Override
    public void statusUpdated(Status status) {
        for (IStatusListener listener : listeners) {
            listener.statusUpdated(status);
        }
    }
}
