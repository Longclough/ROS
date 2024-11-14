package com.baesystems.midas;

import gov.nasa.worldwind.geom.Position;

/**
 * Utilities to convert between coordinate systems
 *
 * @author sandy.hamilton
 *
 */
public final class Coordinates
{
	/**
	 * @author graham.lund
	 *
	 */
	public interface IGeoid
	{
		/**
		 * @param coordinate
		 * @return
		 */
		double getOffset(final Position coordinate);
	}

	/***********************************************************************************/

	private static final double RESOLUTION = 1.5 * Math.pow(10, -10);

	private static IGeoid GEOID = null;

	/***********************************************************************************/

	/**
	 * Method to perform a full conversion from Cartesian to Geodetic
	 *
	 * @param cartesian
	 *            - cartesian position to be converted
	 * @param origin
	 *            - the origin of the cartesian coordinate set
	 * @return
	 */
	public static Position cartesianToGeodetic(final Cartesian cartesian, final Position origin)
	{
		return ecefToGeo(nedToEcef(cartesian, origin));
	}

	/**
	 * Method providing conversion from ECEF to geodetic coordinates (makes use of Bowring's iterative method)
	 *
	 * @param cartesian
	 *            - ECEF cartesian position to be converted
	 * @return
	 */
	private static Position ecefToGeo(final Cartesian cartesian)
	{
		final double f = 1.0 / Wgs84.F0;
		final double longitude = Math.atan2(cartesian.e, cartesian.n);

		final double s = Math.sqrt(cartesian.n * cartesian.n + cartesian.e * cartesian.e);
		double beta = Math.atan(cartesian.d / ((1.0 - f) * s));
		double sinBeta = Math.sin(beta);
		double cosBeta = Math.cos(beta);

		double latitude = Math
		            .atan((cartesian.d + Wgs84.E2 * (1.0 - f) / (1 - Wgs84.E2) * Wgs84.A0 * sinBeta * sinBeta * sinBeta)
		                        / (s - Wgs84.E2 * Wgs84.A0 * cosBeta * cosBeta * cosBeta));

		double previous;
		do
		{
			previous = latitude;

			beta = Math.atan((1.0 - f) * Math.sin(previous) / Math.cos(previous));

			sinBeta = Math.sin(beta);
			cosBeta = Math.cos(beta);

			latitude = Math.atan(
			            (cartesian.d + Wgs84.E2 * (1.0 - f) / (1 - Wgs84.E2) * Wgs84.A0 * sinBeta * sinBeta * sinBeta)
			                        / (s - Wgs84.E2 * Wgs84.A0 * cosBeta * cosBeta * cosBeta));

		} while (Math.abs(latitude - previous) > RESOLUTION);

		final double sinLat = Math.sin(latitude);

		final double r = Wgs84.A0 / Math.sqrt(1 - Wgs84.E2 * sinLat * sinLat);

		double altitude = s * Math.cos(latitude) + (cartesian.d + Wgs84.E2 * r * sinLat) * sinLat - r;

		if (null != GEOID)
		{
			altitude -= 0; //GEOID.getOffset(Position.fromRadians(latitude, longitude));
		}

		return Position.fromRadians(latitude, longitude, altitude);
	}

	/**
	 * Method providing conversion from ECEF to Cartesian coordinates
	 *
	 * @param cartesian
	 *            - ECEF Cartesian position to be converted
	 * @param origin
	 *            - the origin of the Cartesian coordinate set
	 * @return
	 */
	private static Cartesian ecefToNed(final Cartesian cartesian, final Position origin)
	{
		final Cartesian originCart = geoToEcef(origin);

		final double deltaN = cartesian.n - originCart.n;
		final double deltaE = cartesian.e - originCart.e;
		final double deltaD = cartesian.d - originCart.d;

		final double cosLat = Math.cos(origin.latitude.radians);
		final double sinLat = Math.sin(origin.latitude.radians);
		final double cosLon = Math.cos(origin.longitude.radians);
		final double sinLon = Math.sin(origin.longitude.radians);

		return new Cartesian(-deltaN * sinLat * cosLon - deltaE * sinLat * sinLon + deltaD * cosLat,
		            -deltaN * sinLon + deltaE * cosLon,
		            -deltaN * cosLat * cosLon - deltaE * cosLat * sinLon - deltaD * sinLat);
	}

	/**
	 * Method to perform a full conversion from Geodetic to Cartesian
	 *
	 * @param geodetic
	 *            - geodetic position to be converted
	 * @param origin
	 *            - the origin of the cartesian coordinate set
	 * @return
	 */
	public static Cartesian geodeticToCartesian(final Position geodetic, final Position origin)
	{
		return ecefToNed(geoToEcef(geodetic), origin);
	}

	/**
	 * Method providing conversion from Geodetic to ECEF coordinates
	 *
	 * @param geodetic
	 *            - geodetic position to be converted
	 * @return
	 */
	private static Cartesian geoToEcef(final Position geodetic)
	{
		final double latitude = geodetic.latitude.radians;
		final double longitude = geodetic.longitude.radians;

		double altitude;
		try
		{
			altitude = null != GEOID ? geodetic.elevation + GEOID.getOffset(geodetic) : geodetic.elevation;
		}
		catch (final Exception e)
		{
			altitude = geodetic.elevation;
		}

		final double cosLat = Math.cos(latitude);
		final double sinLat = Math.sin(latitude);
		final double cosLon = Math.cos(longitude);
		final double sinLon = Math.sin(longitude);

		final double r = Wgs84.A0 / Math.sqrt(1.0 - Wgs84.E2 * sinLat * sinLat);

		return new Cartesian((r + altitude) * cosLat * cosLon, (r + altitude) * cosLat * sinLon,
		            (r * (1 - Wgs84.E2) + altitude) * sinLat);
	}

	/**
	 * Method providing conversion from Cartesian to ECEF coordinates
	 *
	 * @param cartesian
	 *            - Cartesian position to be converted
	 * @param origin
	 *            - the origin of the Cartesian coordinate set
	 * @return
	 */
	private static Cartesian nedToEcef(final Cartesian cartesian, final Position origin)
	{
		final Cartesian originCart = geoToEcef(origin);

		final double cosLat = Math.cos(origin.latitude.radians);
		final double sinLat = Math.sin(origin.latitude.radians);
		final double cosLon = Math.cos(origin.longitude.radians);
		final double sinLon = Math.sin(origin.longitude.radians);

		final Cartesian cart = new Cartesian(
		            originCart.n - cartesian.n * sinLat * cosLon - cartesian.e * sinLon - cartesian.d * cosLat * cosLon,
		            originCart.e - cartesian.n * sinLat * sinLon + cartesian.e * cosLon - cartesian.d * cosLat * sinLon,
		            originCart.d + cartesian.n * cosLat - cartesian.d * sinLat);

		return cart;
	}

	/**
	 * Calculate position at a range/bearing from an origin
	 *
	 * @param origin
	 * @param range
	 * @param bearing
	 *            in radians
	 * @return
	 */
	public static Position positionAtRangeBearing(final Position origin, final double range, final double bearing)
	{
		final double dn = range * Math.cos(bearing);
		final double de = range * Math.sin(bearing);

		return cartesianToGeodetic(new Cartesian(dn, de, 0), origin);
	}

	/**
	 * @param egm96
	 */
	public static void setEGM96(final IGeoid egm96)
	{
		Coordinates.GEOID = egm96;
	}

	/***********************************************************************************/

	/**
	 * Constructor
	 */
	private Coordinates()
	{
		super();
	}
}