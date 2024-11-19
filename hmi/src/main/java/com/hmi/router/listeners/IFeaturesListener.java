package com.hmi.router.listeners;

import java.io.File;
import java.util.List;

import gov.nasa.worldwind.geom.Position;

public interface IFeaturesListener {

    void kmlCreated(File file);

    void geojsonCreated(String features, String style, String name);

    void imageCreated(File file, List<Position> bounds);

    void shpCreated(File file, String style);

}
