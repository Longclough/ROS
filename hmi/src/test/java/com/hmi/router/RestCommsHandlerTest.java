package com.hmi.router;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.hmi.router.listeners.ObjectsListeners;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;

public class RestCommsHandlerTest {
    
    @Mock
    RoutesApi routesApi;
   
    @Spy
    ObjectsListeners objectsListeners = ObjectsListeners.getInstance();

    @InjectMocks
    RestCommsHandler commsHandler;
    private static AtomicInteger waypointId = new AtomicInteger(1);

    @Captor
    private ArgumentCaptor<ArrayList<Waypoint>> waypointListCaptor;

    public RestCommsHandlerTest() {
        
    }

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenObjectTypeIsVehicle_whenCreatingAnObject_thenObjectCreated() {
        Position position = Position.fromDegrees(52, -2, 1000);
        ObjectType waypointType = ObjectType.get("VEHICLE");

        commsHandler.createObject(waypointType, position);
        Mockito.verify(objectsListeners).objectCreated(0, waypointType, position);
    }

    @Test
    public void givenObjectTypeIsWaypoint_whenCreatingAnObject_thenObjectCreated() {
        Position position = Position.fromDegrees(52, -2, 1000);
        ObjectType vehicleType = ObjectType.get("VEHICLE");
        ObjectType waypointType = ObjectType.get("WAYPOINT");

        commsHandler.createObject(vehicleType, position);
        commsHandler.createObject(waypointType, position);
        Mockito.verify(objectsListeners).objectCreated(0, vehicleType, position);
        Mockito.verify(objectsListeners).objectCreated(waypointId.get(), waypointType, position);
    }

    @Test 
    public void whenPlanIsCalled_thenRouteIsCalculated() {
        commsHandler.plan();

        Mockito.verify(routesApi).calculateRoute(any(), any());
    }

    @Test
    public void givenObjectIsAVehicle_whenSetObjectPositionIsCalled_thenObjectIsMovedAndRouteCalculated() {
        Integer vehicleId = 0;
        Position position = Position.fromDegrees(52, -2, 1000);

        commsHandler.setObjectPosition(vehicleId, position);

        Mockito.verify(objectsListeners).objectMoved(vehicleId, position, Angle.ZERO);

        Mockito.verify(routesApi).calculateRoute(position, Collections.emptyList());
    }

    @Test
    public void givenObjectIsAWaypoint_whenSetObjectPositionIsCalled_thenObjectIsMovedAndRouteCalculated() {
        Position position = Position.fromDegrees(52, -2, 1000);
        
        Waypoint waypoint = new Waypoint();
        waypoint.setId(waypointId.get());
        waypoint.setPosition(position);

        commsHandler.setObjectPosition(waypoint.getId(), position);
        
        Mockito.verify(objectsListeners).objectMoved(waypoint.getId(), waypoint.getPosition(), Angle.ZERO);

        verify(routesApi).calculateRoute(ArgumentMatchers.isNull(), waypointListCaptor.capture());

        List<Waypoint> waypoints = waypointListCaptor.getValue();
        assert waypoints.size() == 1;
        assert waypoints.get(0).getPosition() == waypoint.getPosition();
        assert waypoints.get(0).getId() == waypoint.getId();
    }

}