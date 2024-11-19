package com.hmi.router;

/**
 * Constant and calculations related to the WGS-84 geodetic system
 *
 * @author sandy.hamilton
 *
 */
public final class Wgs84
{
	// Constant for the WGS84 value of Semi-major axis radius
	public static final double A0 = 6378137.0;

	// Constant for the WGS84 value of Semi-minor axis radius
	public static final double B0 = 6356752.314245;

	// Constant for the WGS84 value of eccentricity
	public static final double E0 = 0.0818191908426;

	public static final double E2 = E0 * E0;

	// Constant for the WGS reciprocal value of Earth Flattening
	public static final double F0 = 298.257223563;

	/**
	 * Method to calculate the Earth radius of curvature in the East-West direction
	 *
	 * @param latitude
	 *            - the latitude at which the radius is to be calculated
	 * @return
	 */
	public static double getEastRadius(final double latitude)
	{
		final double sinLat = Math.sin(latitude);
		return A0 * Math.cos(latitude) / Math.sqrt(1.0 - E2 * sinLat * sinLat);
	}

	/**
	 * Method to calculate the Earth radius of curvature in the North-South direction
	 *
	 * @param latitude
	 *            - the latitude at which the radius is to be calculated
	 * @return
	 */
	public static double getNorthRadius(final double latitude)
	{
		final double sinLat = Math.sin(latitude);
		return A0 * (1.0 - E2) / Math.pow(1.0 - E2 * sinLat * sinLat, 1.5);
	}

	/***********************************************************************************/

	/**
	 * The constructor
	 */
	private Wgs84()
	{
		super();
	}
}