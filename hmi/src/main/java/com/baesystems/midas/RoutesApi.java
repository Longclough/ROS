/*
 * The purpose of this class is to send a request to the RoutesApi 
 * to calculate a route and then convert the list of routepoints 
 * to a JSON object and return back to the RestCommsHandler.
 */
package com.baesystems.midas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baesystems.midas.listeners.ObjectsListeners;
import com.baesystems.midas.listeners.StatusListeners;

import gov.nasa.worldwind.geom.Position;

public class RoutesApi {

    private class RouteCalculation {

        private Position vehiclePosition;
        private List<Waypoint> waypoints;

        private RouteCalculation(Position vehiclePosition, List<Waypoint> waypoints) {
            this.vehiclePosition = vehiclePosition;
            this.waypoints = waypoints;
        }

        private void execute() {
            try {
                statusListeners.statusUpdated(Status.PLANNING);
                List<Position> routepoints = new ArrayList<>();
                String jsonString = encodeRequirementsAsJson(vehiclePosition, waypoints);
                URL url = new URL(AppProperties.getInstance().getRoutesBaseUrl() + "/calculate-route");
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                httpCon.setDoOutput(true);
                httpCon.setRequestMethod("POST");
                httpCon.setRequestProperty("Content-Type", "application/json");
                try (OutputStream os = httpCon.getOutputStream()) {
                    try (OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
                        osw.write(jsonString);
                        osw.flush();
                    }
                }
                httpCon.connect();

                if (httpCon.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader rd = new BufferedReader(
                            new InputStreamReader(httpCon.getInputStream(), StandardCharsets.UTF_8));
                    String data = rd.lines().collect(Collectors.joining());
                    JSONObject json = new JSONObject(data);
                    JSONArray routepointArray = json.getJSONArray("routepoint");
                    for (int i = 0; i < routepointArray.length(); i++) {
                        JSONObject routepoint = routepointArray.getJSONObject(i);
                        routepoints.add(Position.fromDegrees(routepoint.getDouble("latitude"),
                                routepoint.getDouble("longitude"), routepoint.getDouble("altitude")));
                    }
                    JSONObject achievability = json.getJSONObject("achievability");
                    for (Waypoint waypoint : waypoints) {
                        JSONObject waypointAchievability = achievability
                                .getJSONObject("r" + (waypoint.getId()));
                        List<String> problems = new ArrayList<>();
                        JSONArray problemsArray = waypointAchievability.getJSONArray("problems");
                        for (int i = 0; i < problemsArray.length(); i++) {
                            String problem = problemsArray.getJSONObject(i).getString("description");
                            problems.add(problem);
                        }
                        objectsListeners.statusChanged(waypoint.getId(),
                                !waypointAchievability.getBoolean("achievable"), String.join(",", problems));
                    }
                } else {
                    statusListeners.statusUpdated(Status.FAILED);
                }
                httpCon.disconnect();
                handler.routeUpdated(routepoints);
                statusListeners.statusUpdated(Status.PLANNED);
            } catch (Exception e) {
                e.printStackTrace();
                statusListeners.statusUpdated(Status.FAILED);
            }
        }

        private String encodeRequirementsAsJson(Position vehiclePosition, List<Waypoint> waypoints) {
            JSONObject fullJson = new JSONObject();
            JSONArray requirements = new JSONArray();
            fullJson.put("requirement", requirements);

            requirements.put(encodeRequirementAsJson(vehiclePosition, 0));
            for (Waypoint waypoint : waypoints) {
                requirements.put(encodeRequirementAsJson(waypoint.getPosition(), waypoint.getId()));
            }

            return fullJson.toString();
        }

        private JSONObject encodeRequirementAsJson(Position position, int objectId) {
            JSONObject requirement = new JSONObject();
            requirement.put("id", "r" + objectId);
            requirement.put("latitude", position.getLatitude().degrees);
            requirement.put("longitude", position.getLongitude().degrees);
            requirement.put("altitude", position.getAltitude());
            return requirement;
        }
    }

    boolean runFlag = true;
    StatusListeners statusListeners = StatusListeners.getInstance();
    ObjectsListeners objectsListeners = ObjectsListeners.getInstance();
    RestCommsHandler handler;
    BlockingQueue<RouteCalculation> queue = new LinkedBlockingQueue<>();
    Thread consumerThread = new Thread(new Runnable() {
        public void run() {
            while (runFlag) {
                try {
                    RouteCalculation calculation = queue.take();
                    calculation.execute();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    });

    public RoutesApi(RestCommsHandler handler) {
        this.handler = handler;
        consumerThread.start();
    }

    public void calculateRoute(Position vehiclePosition, List<Waypoint> wayoints) {
        try {
            queue.clear();
            queue.put(new RouteCalculation(vehiclePosition, wayoints));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void kill() {
        queue.clear();
        runFlag = false;
    }
}