package com.baesystems.midas.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;

import com.baesystems.midas.Application.AppFrame;
import com.baesystems.midas.listeners.FeaturesListeners;
import com.baesystems.midas.listeners.IFeaturesListener;
import com.baesystems.midas.listeners.ILifecycleListener;
import com.baesystems.midas.listeners.LifecycleListeners;

import gov.nasa.worldwind.formats.geojson.GeoJSONObject;
import gov.nasa.worldwind.formats.shapefile.ShapefileLayerFactory;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.ogc.kml.KMLRoot;
import gov.nasa.worldwind.ogc.kml.impl.KMLController;
import gov.nasa.worldwind.render.AbstractSurfaceShape;
import gov.nasa.worldwind.render.BasicShapeAttributes;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.Renderable;
import gov.nasa.worldwind.render.ShapeAttributes;
import gov.nasa.worldwind.render.SurfaceImage;
import gov.nasa.worldwindx.examples.GeoJSONLoader;
import gov.nasa.worldwind.formats.geojson.GeoJSONEventParser;
import gov.nasa.worldwind.formats.geojson.GeoJSONEventParserContext;

public class FeatureController implements IFeaturesListener, ILifecycleListener {

    private static final String DEFAULT = "default";

    private GeoJSONLoader geojsonLoader = new GeoJSONLoader();
    private ShapefileLayerFactory shpLoader = new ShapefileLayerFactory();
    private Map<String, ShapeAttributes> styles = new HashMap<>();
    private AppFrame appFrame;
    private List<Layer> layers = new ArrayList<>();

    public FeatureController(AppFrame appFrame) {
        this.appFrame = appFrame;

        ShapeAttributes shapeAttributes = new BasicShapeAttributes();
        shapeAttributes.setDrawInterior(true);
        shapeAttributes.setDrawOutline(true);
        shapeAttributes.setOutlineMaterial(Material.RED);
        shapeAttributes.setInteriorMaterial(Material.RED);
        shapeAttributes.setInteriorOpacity(0.2);

        ShapeAttributes terrainShapeAttributes = new BasicShapeAttributes();
        terrainShapeAttributes.setDrawInterior(true);
        terrainShapeAttributes.setDrawOutline(true);
        terrainShapeAttributes.setOutlineMaterial(Material.ORANGE);
        terrainShapeAttributes.setInteriorMaterial(Material.ORANGE);
        terrainShapeAttributes.setInteriorOpacity(0.2);

        ShapeAttributes airspaceShapeAttributes = new BasicShapeAttributes();
        airspaceShapeAttributes.setDrawInterior(true);
        airspaceShapeAttributes.setDrawOutline(true);
        airspaceShapeAttributes.setOutlineMaterial(Material.RED);
        airspaceShapeAttributes.setInteriorMaterial(Material.RED);
        airspaceShapeAttributes.setInteriorOpacity(0.2);

        ShapeAttributes weatherShapeAttributes = new BasicShapeAttributes();
        weatherShapeAttributes.setDrawInterior(true);
        weatherShapeAttributes.setDrawOutline(true);
        weatherShapeAttributes.setOutlineMaterial(Material.BLUE);
        weatherShapeAttributes.setInteriorMaterial(Material.BLUE);
        weatherShapeAttributes.setInteriorOpacity(0.2);

        styles.put(DEFAULT, shapeAttributes);
        styles.put("weather", weatherShapeAttributes);
        styles.put("terrain", terrainShapeAttributes);
        styles.put("airspace", airspaceShapeAttributes);

        FeaturesListeners.getInstance().registerListener(this);
        LifecycleListeners.getInstance().registerListener(this);
    }

    @Override
    public void kmlCreated(File file) {
        KMLRoot root;
        try {
            RenderableLayer layer = appFrame.createLayer(file.getName());
            layers.add(layer);

            root = new KMLRoot(file);
            root.parse();
            KMLController kmlController = new KMLController(root);
            layer.addRenderable(kmlController);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void geojsonCreated(String features, String style, String name) {
        try {

            ShapeAttributes attributes = styles.getOrDefault(style, styles.get(DEFAULT));

            RenderableLayer layer = appFrame.createLayer(name);
            layers.add(layer);

            JsonFactory factory = new JsonFactory();
            JsonParser jsonParser = factory.createJsonParser(features);
            GeoJSONEventParserContext ctx = new GeoJSONEventParserContext(jsonParser);

            if (!ctx.hasNext())
                return;

            GeoJSONEventParser rootParser = new GeoJSONEventParser();

            GeoJSONObject rootObject = (GeoJSONObject) rootParser.parse(ctx, ctx.nextEvent());
            
            geojsonLoader.addGeoJSONGeometryToLayer(rootObject, layer);
            for (Renderable renderable : ((RenderableLayer) layer).getRenderables()) {
                if (renderable instanceof AbstractSurfaceShape) {
                    AbstractSurfaceShape abstractSurfaceShape = (AbstractSurfaceShape) renderable;
                    abstractSurfaceShape.setAttributes(attributes);
                    abstractSurfaceShape.setHighlightAttributes(attributes);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void imageCreated(File file, List<Position> bounds) {
        RenderableLayer layer = appFrame.createLayer(file.getName());
        layers.add(layer);

        SurfaceImage image = new SurfaceImage(file, bounds);
        layer.addRenderable(image);
    }

    @Override
    public void reset() {
        for (Layer layer : layers) {
            appFrame.getWwd().getModel().getLayers().remove(layer);
        }
        layers.clear();
    }

    @Override
    public void shpCreated(File file, String style) {

        ShapeAttributes attributes = styles.getOrDefault(style, styles.get(DEFAULT));

        shpLoader.setNormalShapeAttributes(attributes);
        shpLoader.setHighlightShapeAttributes(attributes);
        Layer layer = (Layer) shpLoader.createFromShapefileSource(file);
        layer.setName(file.getName());
        layers.add(layer);
        appFrame.getWwd().getModel().getLayers().add(layer);

        appFrame.addLayer(layer);
    }
}
