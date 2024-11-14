package com.baesystems.environmentinfrastructure;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.JSONArray;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import com.baesystems.environmentinfrastructure.airspace.AirspaceVolume;
import com.baesystems.environmentinfrastructure.application.Logger;
import com.baesystems.environmentinfrastructure.db.AirspaceDao;
import com.baesystems.environmentinfrastructure.loader.aixm.AIXMLoader;
import com.baesystems.environmentinfrastructure.loader.aixm.datasource.AIXMDataSource;

/**
 * Servlet implementation class Airspace
 */
@WebServlet("/airspace")
public class Airspace extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final GeometryFactory GF = new GeometryFactory(new PrecisionModel(), 4326);
	private static final WKTReader READER = new WKTReader(GF);

	private final AirspaceDao database;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Airspace() {
		super();
		database = new AirspaceDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Airspace(AirspaceDao database) {
		super();
		this.database = database;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String wkt = request.getParameter("bounds");

		if (wkt == null) {
			sendError(response, HttpServletResponse.SC_BAD_REQUEST, "No bounds parameter specified");
			return;
		}

		Logger.log("Using bounds: " + wkt);
		Geometry bounds = null;
		try {
			bounds = READER.read(wkt);
		} catch (ParseException e) {
			sendError(response, HttpServletResponse.SC_BAD_REQUEST,
					"Invalid bounds parameter specified, must be WKT: " + wkt, e);
			return;
		}

		try {
			List<AirspaceVolume> airspaceVolumes = database.getAirspaceVolumes(bounds);

			JSONObject root = new JSONObject();
			root.put("type", "FeatureCollection");
			JSONArray features = new JSONArray();
			for (AirspaceVolume airspaceVolume : airspaceVolumes) {
				features.put(airspaceVolume.toJSON());
			}
			root.put("features", features);

			response.getWriter().append(root.toString());
		} catch (Exception e) {
			sendError(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					"Error getting airspace", e);
		}
	}

	private void sendError(HttpServletResponse response, int statusCode, String message) {
		sendError(response, statusCode, message, null);
	}

	private void sendError(HttpServletResponse response, int statusCode, String message, Exception exception) {
		try {
			response.sendError(statusCode,
					message + (exception != null ? (System.lineSeparator() + exception.getMessage()) : ""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String source = request.getParameter("source");
		Logger.log("Loading " + source);
		try {
			URL url = new URL(source);
			new AIXMLoader(new AIXMDataSource(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
