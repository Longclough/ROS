package com.hmi.router.listeners;

public class LifecycleListeners extends Listeners<ILifecycleListener> implements ILifecycleListener {
    private static LifecycleListeners instance;

    public static LifecycleListeners getInstance() {
        if (instance == null) {
            instance = new LifecycleListeners();
        }
        return instance;
    }

    @Override
    public void reset() {
        for (ILifecycleListener listener : listeners) {
            listener.reset();
        }
    }
}
