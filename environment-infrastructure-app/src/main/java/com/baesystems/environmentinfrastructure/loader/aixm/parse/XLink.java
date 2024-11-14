package com.baesystems.environmentinfrastructure.loader.aixm.parse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import aero.aixm.schema._5.AirportHeliportPropertyType;
import aero.aixm.schema._5.AirspacePropertyType;

import com.baesystems.environmentinfrastructure.airspace.Airspace;
import com.baesystems.environmentinfrastructure.db.AirspaceDao;
import com.baesystems.environmentinfrastructure.loader.aixm.AIXMParseException;

public class XLink {	

	private static AirspaceDao database = new AirspaceDao();

	private XLink() {}
	
	public static boolean refsEqual(String href, String uid) {
		return tidyRef(href).equals(uid); // was ends with
	}
	
	public static String tidyRef(String href) {
		if(href.contains("\'")) {
			String tidy = href.substring(href.indexOf("\'") + 1, href.lastIndexOf("\'"));
			return tidy.toLowerCase();
		} else if (href.contains(".")) {
			String tidy = href.substring(href.lastIndexOf(".") + 1);
			return tidy.toLowerCase();
		} else if (href.contains(":")) {
			String tidy = href.substring(href.lastIndexOf(":") + 1);
			return tidy.toLowerCase();
		} else if (href.contains("#")) {
			String tidy = href.substring(href.lastIndexOf("#") + 1);
			return tidy.toLowerCase();
		} else {
			return href.toLowerCase();
		}
	}
	
	public static String getAirportHref(List<JAXBElement<?>> rest) {
		for(JAXBElement<?> element : rest) {
			Object value = element.getValue();
			if(value instanceof AirportHeliportPropertyType) {
				String href = ((AirportHeliportPropertyType) value).getHref();
				return tidyRef(href);
			}
		}
		return "";
	}
	
	public static Airspace getAirspace(JAXBElement<AirspacePropertyType> airspaceProperty) throws AIXMParseException {
		if(airspaceProperty != null && airspaceProperty.getValue() != null) {
			return getAirspace(airspaceProperty.getValue());
		}
		return null;
	}
	
	public static List<Airspace> getAirspace(List<AirspacePropertyType> airspaceProperties) {
		List<Airspace> airspaces = new ArrayList<>();
		for(AirspacePropertyType airspaceProperty : airspaceProperties) {
			try {
				airspaces.add(getAirspace(airspaceProperty));
			} catch (AIXMParseException e) {
				e.printMessage();
			}
		}
		return airspaces;
	}

	public static Airspace getAirspace(AirspacePropertyType airspaceProperty) throws AIXMParseException {
		String airspaceRef = tidyRef(airspaceProperty.getHref());
		Airspace airspace = database.getAirspace(airspaceRef);
		if(airspace == null) {
			throw new AIXMParseException("Couldn't find airspace: " + airspaceRef);
		}
		return airspace;
	}
}
