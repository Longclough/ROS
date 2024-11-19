package com.hmi.router.listeners;

import java.io.File;
import java.util.List;

import gov.nasa.worldwind.geom.Position;

public class FeaturesListeners extends Listeners<IFeaturesListener> implements IFeaturesListener {
    private static FeaturesListeners instance;

    public static FeaturesListeners getInstance() {
        if (instance == null) {
            instance = new FeaturesListeners();
        }
        return instance;
    }

    @Override
    public void kmlCreated(File file) {
        for (IFeaturesListener listener : listeners) {
            listener.kmlCreated(file);
        }
    }

    @Override
    public void geojsonCreated(String features, String style, String name) {
        for (IFeaturesListener listener : listeners) {
            listener.geojsonCreated(features, style, name);
        }
    }

    @Override
    public void imageCreated(File file, List<Position> bounds) {
        for (IFeaturesListener listener : listeners) {
            listener.imageCreated(file, bounds);
        }
    }

    @Override
    public void shpCreated(File file, String style) {
        for (IFeaturesListener listener : listeners) {
            listener.shpCreated(file, style);
        }
    }
}
