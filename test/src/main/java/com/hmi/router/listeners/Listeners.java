package com.hmi.router.listeners;

import java.util.ArrayList;
import java.util.List;

public abstract class Listeners<T> {

    protected List<T> listeners = new ArrayList<>();

    public void registerListener(T listener) {
        listeners.add(listener);
    }
}
