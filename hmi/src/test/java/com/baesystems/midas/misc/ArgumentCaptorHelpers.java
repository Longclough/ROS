package com.baesystems.midas.misc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.mockito.ArgumentCaptor;

import com.baesystems.midas.Waypoint;

public class ArgumentCaptorHelpers {

  private ArgumentCaptorHelpers() {
  }

  @SuppressWarnings("unchecked")
  public static ArgumentCaptor<List<Waypoint>> getWaypointListArgumentCaptor() {
    ArgumentCaptor<List<Waypoint>> propertiesCaptor = ArgumentCaptor.forClass(List.<Waypoint>of().getClass());
    return propertiesCaptor;
  }

  public static void assertWaypointListArgumentContains(ArgumentCaptor<List<Waypoint>> captor, List<Waypoint> expectedValues) {
    var properties = captor.getValue();
    assertEquals(properties.size(), expectedValues.size());

    for (int i = 0; i < properties.size(); i++) {
        var waypoint = properties.get(i);
        var expectedWaypoint = expectedValues.get(i);
        assertEquals(waypoint.getId(), expectedWaypoint.getId());
        assertEquals(waypoint.getPosition(), expectedWaypoint.getPosition());
    }
  }
}