/* 
* The NASA Worldwind package is being used and is licensed under the Apache 2.0 License. 
* A copy of the license can be found at: 
* http://www.apache.org/licenses/LICENSE-2.0 
*/

package com.hmi.router;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hmi.router.controllers.ConstraintController;
import com.hmi.router.controllers.FeatureController;
import com.hmi.router.controllers.ObjectController;
import com.hmi.router.listeners.FeaturesListeners;
import com.hmi.router.listeners.ILifecycleListener;
import com.hmi.router.listeners.IOptionsListener;
import com.hmi.router.listeners.IStatusListener;
import com.hmi.router.listeners.LifecycleListeners;
import com.hmi.router.listeners.OptionsListeners;
import com.hmi.router.listeners.StatusListeners;

import gov.nasa.worldwind.Configuration;
import gov.nasa.worldwind.View;
import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.ViewInputAttributes;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.SurfaceImage;
import gov.nasa.worldwind.view.orbit.BasicOrbitView;
import gov.nasa.worldwindx.examples.ApplicationTemplate;
import gov.nasa.worldwindx.examples.util.ToolTipController;


public class Application extends ApplicationTemplate {

    private static final Logger LOGGER = LogManager.getLogger();

    public static class AppFrame extends ApplicationTemplate.AppFrame {

        private static final long TICK = 10;

        private Map<String, JComboBox<String>> optionGroups = new HashMap<>();

        private transient Map<ObjectType, JToggleButton> creationButtonMap = new HashMap<>();

        private transient Dragger dragger;

        public AppFrame() {

            this.getControlPanel().add(this.makeControlPanel(), BorderLayout.SOUTH);

            this.getWwd().getSceneController().setDeepPickEnabled(true);

            //this.getWwd().getView().setEyePosition(Position.fromDegrees(53.742350388934085, -2.6979745427664668, 50));
            
            //Warton
            //this.getWwd().getView().setEyePosition(Position.fromDegrees(53.745793304041634, -2.894669081029672, 100));

            //W23
            this.getWwd().getView().setEyePosition(Position.fromDegrees(53.74552338772606,  -2.8945526636429477, 150));
            
            //Turns bing layer on
            //for (Layer layer : this.getWwd().getModel().getLayers())
            //{
            //    if(layer.getName().contains("Bing"))
            //    {
            //        layer.setEnabled(true);
            //    }
            //}
    
            for (Layer layer : this.getWwd().getModel().getLayers())
            {
 
                List<String> layers = List.of("Atmosphere", "Stars", "NASA Blue Marble Image", "Blue Marble May 2004", "i-cubed Landsat", "Place Names", "World Map", "Compass");

                for (String item : layers)
                {    
                    if(layer.getName().contains(item))
                        {
                            layer.setEnabled(false);
                        }
                }
                
            }

            //Creates room layer where the imageSource is the url to the image
            //createLayer("Room");
            //RenderableLayer roomlayer=createLayer("Room");
            //SurfaceImage roomimage=new SurfaceImage("n52_w003_1arc_v3.tif", new Sector(Angle.fromDegrees(53.74233215376856),Angle.fromDegrees(53.74243203331977),Angle.fromDegrees(-2.698095163834937),Angle.fromDegrees(-2.6979048032333046)));
            //roomlayer.addRenderable(roomimage);

            RenderableLayer w23layer=createLayer("W23");
            SurfaceImage w23image=new SurfaceImage("w23.tif", new Sector(Angle.fromDegrees(53.7459153),Angle.fromDegrees(53.7447775),Angle.fromDegrees( -2.8951043),Angle.fromDegrees( -2.8940975)));
            w23layer.addRenderable(w23image);

            dragger = new Dragger(this.getWwd());
            this.getWwd().addSelectListener(dragger);

            initialiseInputHandlers();

            
            BasicOrbitView view = (BasicOrbitView) getWwd().getView();
            view.setPitch(Angle.ZERO);
            //view.computePixelSizeAtDistance(1);

            initialiseClampToGround(view);

            new ObjectController(this);
            new ConstraintController(this);
            new FeatureController(this);

            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    Messaging.getInstance().kill();
                }
            });

            CursorManager.getInstance().initialise(this.getWwjPanel());

            this.layerPanel.update(this.getWwd());

            new ToolTipController(this.getWwd());

            initialiseRefresh();

            load();
        }

        private void initialiseInputHandlers() {
            ViewInputAttributes attrs = this.getWwd().getView().getViewInputHandler().getAttributes();
            attrs.getActionMap(ViewInputAttributes.DEVICE_MOUSE).getActionAttributes(ViewInputAttributes.VIEW_MOVE_TO)
                    .setMouseActionListener(null);

            this.getWwd().getInputHandler().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                        Position position = getWwd().getCurrentPosition();
                        System.out.println(position);
                        for (Entry<ObjectType, JToggleButton> entry : creationButtonMap.entrySet()) {
                            if (entry.getValue().isSelected()) {
                                double elevation = ObjectType.get("VEHICLE").equals(entry.getKey())
                                        || ObjectType.get("WAYPOINT").equals(entry.getKey()) ? 500
                                                : position.getElevation();
                                Messaging.getInstance().createObject(entry.getKey(), new Position(position, elevation));
                            }
                        }
                    }
                }
            });
        }

        private void initialiseRefresh() {
            TimerTask timerTask = new TimerTask() {

                @Override
                public void run() {
                    AppFrame.this.getWwd().redraw();
                }
            };

            Timer timer = new Timer();
            timer.schedule(timerTask, TICK, TICK);
        }

        public void initialiseClampToGround(View view) {
            ClampToGround clampToGround = ClampToGround.getInstance();
            clampToGround.setClampToGround(true);

            view.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (view.getPitch().degrees < 0.1) {
                        if (!clampToGround.isClampToGround()) {
                            clampToGround.setClampToGround(true);
                        }
                    } else {
                        if (clampToGround.isClampToGround()) {
                            clampToGround.setClampToGround(false);
                        }
                    }
                }
            });
        }

        private void load() {

            //Messaging.getInstance().createObject(ObjectType.get("VEHICLE"), Position.fromDegrees(53.742350388934085, -2.6979745427664668, 50));
            
            //Warton location
            Messaging.getInstance().createObject(ObjectType.get("VEHICLE"), Position.fromDegrees(53.74578428232344, -2.894796063871912, 10));
            
            try {          
                String geographyBaseUrl = AppProperties.getInstance().getGeographyBaseUrl();
                URL geographyUrl = new URL(geographyBaseUrl
                        + "/terrain?bounds=POLYGON((-4%2055,-4%2052,-1%2052,-1%2054,-4%2055))&aboveHeight=500");
                loadGeojson(geographyUrl, "terrain", "Terrain above 500m");

                String weatherBaseUrl = AppProperties.getInstance().getWeatherBaseUrl();
                URL weatherUrl = new URL(
                        weatherBaseUrl + "/get-bad-weather?bounds=POLYGON((-4%2055,-4%2052,-1%2052,-1%2054,-4%2055))");
                loadGeojson(weatherUrl, "weather", "Weather");      
                
                String envInfrastructureBaseUrl = AppProperties.getInstance().getEnvironmentInfrastructureBaseUrl();
                URL envInfrastructureUrl = new URL(envInfrastructureBaseUrl
                        + "/airspace?bounds=POLYGON((-4%2055,-4%2052,-1%2052,-1%2054,-4%2055))");
                loadGeojson(envInfrastructureUrl, "airspace", "Airspace");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        private void loadGeojson(URL url, String style, String name) {
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestMethod("GET");
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader rd = new BufferedReader(
                            new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                    String data = rd.lines().collect(Collectors.joining());
                    data = data.replace("\"annotation\":[],", ""); // to avoid parsing exception on empty list
                    FeaturesListeners.getInstance().geojsonCreated(data, style, name);
                } else {
                    LOGGER.error("Failed to connect to geojson source: {} at: {}, response code: {} message: {}", name,
                            url, conn.getResponseCode(), conn.getResponseMessage());
                }
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected JPanel makeControlPanel() {
            JPanel controlPanel = new JPanel();
            controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

            JPanel mapControlsPanel = new JPanel();
            mapControlsPanel.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(9, 9, 9, 9),
                    new TitledBorder("Map Controls")));

            JPanel modePanel = new JPanel();
            modePanel.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(9, 9, 9, 9),
                    new TitledBorder("Map Mode")));

            ButtonGroup buttonGroup = new ButtonGroup();

            JToggleButton panButton = createMapModeButton("Pan", "pan.png");
            panButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    CursorManager.getInstance().pan();
                }
            });
            panButton.setSelected(true);
            buttonGroup.add(panButton);
            modePanel.add(panButton);

            JToggleButton deleteButton = createMapModeButton("Delete", "DELETE.png");
            buttonGroup.add(deleteButton);
            modePanel.add(deleteButton);
            deleteButton.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ev) {
                    if (ev.getStateChange() == ItemEvent.SELECTED) {
                        CursorManager.getInstance().delete();
                    }
                    dragger.setDeleteModeActive(ev.getStateChange() == ItemEvent.SELECTED);
                }
            });

            for (ObjectType objectType : ObjectType.values()) {
                if (objectType.isCreatable()) {
                    JToggleButton button = createMapModeButton("Create " + objectType.toString().toLowerCase(),
                            objectType.toString() + ".png");
                    button.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            CursorManager.getInstance().create();
                        }
                    });
                    buttonGroup.add(button);
                    modePanel.add(button);
                    creationButtonMap.put(objectType, button);
                }
            }
            mapControlsPanel.add(modePanel);

            controlPanel.add(mapControlsPanel);

            JPanel systemPanel = new JPanel();
            systemPanel.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(9, 9, 9, 9),
                    new TitledBorder("System Controls")));

            JButton planButton = new JButton("Plan");
            planButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Messaging.getInstance().plan();
                }
            });
            systemPanel.add(planButton);

            JLabel statusLabel = new JLabel("Status:");
            systemPanel.add(statusLabel);

            JLabel statusValueLabel = new JLabel("...");
            systemPanel.add(statusValueLabel);

            controlPanel.add(systemPanel);

            JPanel simControlsPanel = new JPanel();
            simControlsPanel.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(9, 9, 9, 9),
                    new TitledBorder("Simulation Controls")));
            GridLayout gridLayout = new GridLayout(1, 2, 10, 10);
            simControlsPanel.setLayout(gridLayout);
            controlPanel.add(simControlsPanel);

            JLabel rateLabel = new JLabel("Rate");
            simControlsPanel.add(rateLabel);
            JSlider rateSlider = new JSlider();
            rateSlider.setMaximum(40);
            rateSlider.setMinimum(1);
            rateSlider.setValue(1);
            rateSlider.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider source = (JSlider) e.getSource();
                    if (!source.getValueIsAdjusting()) {
                        int rate = source.getValue();
                        Messaging.getInstance().setRate(rate);
                    }
                }
            });
            simControlsPanel.add(rateSlider);

            StatusListeners.getInstance().registerListener(new IStatusListener() {

                @Override
                public void statusUpdated(Status status) {
                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            planButton.setEnabled(status != Status.PLANNING);
                            statusValueLabel.setText(status.toString());
                        }
                    });

                }
            });

            OptionsListeners.getInstance().registerListener(new IOptionsListener() {

                @Override
                public void optionCreated(String group, String option) {
                    JComboBox<String> comboBox = optionGroups.computeIfAbsent(group, k -> {
                        gridLayout.setRows(gridLayout.getRows() + 1);
                        JComboBox<String> newComboBox = new JComboBox<>();
                        newComboBox.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Messaging.getInstance().selectOption(group, (String) newComboBox.getSelectedItem());
                            }
                        });
                        optionGroups.put(group, newComboBox);
                        simControlsPanel.add(new JLabel(group));
                        simControlsPanel.add(newComboBox);
                        return newComboBox;
                    });
                    comboBox.addItem(option);
                }
            });

            LifecycleListeners.getInstance().registerListener(new ILifecycleListener() {

                @Override
                public void reset() {
                    optionGroups.clear();
                    simControlsPanel.removeAll();
                }

            });

            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            return controlPanel;
        }

        private JToggleButton createMapModeButton(String tooltip, String icon) {
            JToggleButton button = new JToggleButton();
            button.setToolTipText(tooltip);
            button.setIcon(createIcon(icon));
            button.setSelected(false);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            return button;
        }

        private Icon createIcon(String file) {
            ImageIcon icon = new ImageIcon("resources/" + file);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(newimg);
        }

        public RenderableLayer createLayer(String name) {
            RenderableLayer layer = new RenderableLayer();
            layer.setName(name);
            addLayer(layer);
            return layer;
        }


        public void addLayer(Layer layer) {
            this.getWwd().getModel().getLayers().add(layer);
            this.layerPanel.update(this.getWwd());
        }

    }

    public static void main(String[] args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("offline")) {
                    WorldWind.setOfflineMode(true);
                }
            }
        }

        Configuration.setValue(AVKey.INITIAL_LATITUDE, 53.745);
        Configuration.setValue(AVKey.INITIAL_LONGITUDE, -2.883889);
        Configuration.setValue(AVKey.INITIAL_ALTITUDE, 200000);

        RestCommsHandler commsHandler = new RestCommsHandler();

        Messaging.getInstance().setCommsHandler(commsHandler);

        ApplicationTemplate.start("router Concept Development", AppFrame.class);
    }
}
