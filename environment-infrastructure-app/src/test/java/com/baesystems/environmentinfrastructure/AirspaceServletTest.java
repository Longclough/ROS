package com.baesystems.environmentinfrastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.WKTReader;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.baesystems.environmentinfrastructure.airspace.AirspaceClassification;
import com.baesystems.environmentinfrastructure.airspace.AirspaceTimeSlice;
import com.baesystems.environmentinfrastructure.airspace.AirspaceVolume;
import com.baesystems.environmentinfrastructure.airspace.OperationsType;
import com.baesystems.environmentinfrastructure.basictypes.distance.Height;
import com.baesystems.environmentinfrastructure.basictypes.time.TimeData;
import com.baesystems.environmentinfrastructure.db.AirspaceDao;
import com.baesystems.environmentinfrastructure.types.AirspaceCode;

public class AirspaceServletTest extends Mockito {

    @Mock
    private AirspaceDao database;

    @InjectMocks
    private Airspace airspace;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRequest() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        WKTReader wktReader = new WKTReader();
        TimeData timeData = new TimeData(0l, new Date(), new Date(), "", null, new Date(), new Date());
        AirspaceTimeSlice airspaceTimeSlice = new AirspaceTimeSlice(timeData, null, Collections.emptyList(), AirspaceClassification.B, OperationsType.CIVIL, "designator", true, "localType", "name", AirspaceCode.A, Height.fromMMSL(0));
        Polygon horizontalProjection = (Polygon) wktReader.read(
                "POLYGON((-3.1187686629275024 53.5839194907546, -3.1197930039982644 53.98548093094448, -2.9042069960017356 53.98548093094448, -2.9052313370724976 53.5839194907546, -3.1187686629275024 53.5839194907546))");
        List<AirspaceVolume> airspaces = new ArrayList<>();
        airspaces.add(new AirspaceVolume(airspaceTimeSlice, Collections.emptyList(), null, null, horizontalProjection,
                Height.fromFtMSL(0), Height.fromFtMSL(1000), Height.fromFtMSL(0), Height.fromFtMSL(1000), null));
        airspaces.add(new AirspaceVolume(airspaceTimeSlice, Collections.emptyList(), null, null, horizontalProjection,
                Height.fromFtMSL(0), Height.fromFtMSL(1000), Height.fromFtMSL(0), Height.fromFtMSL(1000), null));
        airspaces.add(new AirspaceVolume(airspaceTimeSlice, Collections.emptyList(), null, null, horizontalProjection,
                Height.fromFtMSL(0), Height.fromFtMSL(1000), Height.fromFtMSL(0), Height.fromFtMSL(1000), null));

        when(request.getParameter("bounds")).thenReturn(
                "POLYGON((-3.1187686629275024 53.5839194907546, -3.1197930039982644 53.98548093094448, -2.9042069960017356 53.98548093094448, -2.9052313370724976 53.5839194907546, -3.1187686629275024 53.5839194907546))");
        when(database.getAirspaceVolumes(any())).thenReturn(airspaces);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        airspace.doGet(request, response);

        verify(request, atLeast(1)).getParameter("bounds");
        writer.flush();
        JSONObject json = new JSONObject(stringWriter.toString());
        JSONArray features = json.getJSONArray("features");
        assertEquals(airspaces.size(), features.length());
        for (int i = 0; i < features.length(); i++) {
            checkFeature(features.getJSONObject(i), airspaces.get(i), airspaceTimeSlice);
        }
    }

    private void checkFeature(JSONObject feature, AirspaceVolume airspaceVolume, AirspaceTimeSlice airspaceTimeSlice) {
        assertEquals("Feature", feature.getString("type"));

        JSONObject geometry = feature.getJSONObject("geometry");
        assertEquals("Polygon", geometry.getString("type"));
        JSONArray rings = geometry.getJSONArray("coordinates");
        JSONArray coordinates = rings.getJSONArray(0);
        Coordinate[] expectedCoordinates = airspaceVolume.getHorizontalProjection().getCoordinates();
        assertEquals(expectedCoordinates.length, coordinates.length());
        for (int i = 0; i < coordinates.length(); i++) {
            JSONArray coordinate = coordinates.getJSONArray(i);
            assertEquals(expectedCoordinates[i].x, coordinate.getDouble(0));
            assertEquals(expectedCoordinates[i].y, coordinate.getDouble(1));
        }

        JSONObject properties = feature.getJSONObject("properties");
        for (String key : properties.keySet()) {
            if ("annotation".equals(key)) {
                JSONArray annotations = properties.getJSONArray(key);
                assertEquals(airspaceVolume.getAnnotation().size(), annotations.length());
                for (int i = 0; i < annotations.length(); i++) {
                    assertEquals(airspaceVolume.getAnnotation().get(i), annotations.getString(i));
                }
            } else if ("airspaceTimeSlice".equals(key)) {
                JSONObject jsonAirspaceTimeSlice = properties.getJSONObject(key);
                checkAirspaceTimeSlice(jsonAirspaceTimeSlice, airspaceTimeSlice);
            } else if ("upperLimit".equals(key)) {
                assertEquals(airspaceVolume.getUpperLimit().getMAMSL(), properties.getDouble(key));
            } else if ("lowerLimit".equals(key)) {
                assertEquals(airspaceVolume.getLowerLimit().getMAMSL(), properties.getDouble(key));
            } else {
                fail("Unknown airspaceVolume property key:" + key);
            }
        }
    }

    private void checkAirspaceTimeSlice(JSONObject json, AirspaceTimeSlice airspaceTimeSlice) {
        for (String key : json.keySet()) {
            if ("annotation".equals(key)) {
                JSONArray annotations = json.getJSONArray(key);
                assertEquals(airspaceTimeSlice.getAnnotation().size(), annotations.length());
                for (int i = 0; i < annotations.length(); i++) {
                    assertEquals(airspaceTimeSlice.getAnnotation().get(i), annotations.getString(i));
                }
            } else if ("classification".equals(key)) {
                assertEquals(airspaceTimeSlice.getClassification().toString(), json.getString(key));
            } else if ("controlType".equals(key)) {
                assertEquals(airspaceTimeSlice.getControlType().toString(), json.getString(key));
            } else if ("designator".equals(key)) {
                assertEquals(airspaceTimeSlice.getDesignator().toString(), json.getString(key));
            } else if ("designatorICAO".equals(key)) {
                assertEquals(airspaceTimeSlice.getDesignatorICAO(), json.getBoolean(key));
            } else if ("localType".equals(key)) {
                assertEquals(airspaceTimeSlice.getLocalType().toString(), json.getString(key));
            } else if ("name".equals(key)) {
                assertEquals(airspaceTimeSlice.getName(), json.getString(key));
            } else if ("type".equals(key)) {
                assertEquals(airspaceTimeSlice.getType().toString(), json.getString(key));
            } else if ("upperLowerSeparation".equals(key)) {
                assertEquals(airspaceTimeSlice.getUpperLowerSeparation().getMAMSL(), json.getDouble(key));
            } else {                
                fail("Unknown airspaceTimeSlice property key:" + key);
            }
        }
    }

    @Test
    public void testRequestNoBounds() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("bounds")).thenReturn(null);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        airspace.doGet(request, response);

        verify(request, atLeast(1)).getParameter("bounds");
        writer.flush();
        verify(response).sendError(eq(HttpServletResponse.SC_BAD_REQUEST), anyString());
    }

    @Test
    public void testRequestInvalidBounds() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("bounds")).thenReturn(
                "POGYLON((-3.1187686629275024 53.5839194907546, -3.1197930039982644 53.98548093094448, -2.9042069960017356 53.98548093094448, -2.9052313370724976 53.5839194907546, -3.1187686629275024 53.5839194907546))");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        airspace.doGet(request, response);

        verify(request, atLeast(1)).getParameter("bounds");
        writer.flush();
        verify(response).sendError(eq(HttpServletResponse.SC_BAD_REQUEST), anyString());
    }
}