// This is the outcome of a three dimensional geodetic calculation.  It represents
// the path a between two GeoPoint3Ds for a specified reference ellipsoid.
//
// This code is derived from Version 1.1.1 of Gavaghan.Geodesy. 
// See http://www.gavaghan.org/blog/free-source-code/geodesy-library-vincentys-formula/
// Gavaghan.Geodesy source code is made freely available for use and modification
// without restriction. 

package com.baesystems.environmentinfrastructure.geospatial;

import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;
import com.baesystems.environmentinfrastructure.basictypes.distance.Distance;
import com.baesystems.environmentinfrastructure.basictypes.distance.DistanceUnit;

/// <summary>
/// This is the outcome of a three dimensional geodetic calculation.  It represents
/// the path a between two GeoPoint3Ds for a specified reference ellipsoid.
/// </summary>

public class GeodeticMeasurement
{
    /// <summary>The average geodetic curve.</summary>
    private final GeodeticCurve mCurve;

    /// <summary>The elevation change, in meters, going from the starting to the ending point.</summary>
    private final double mElevationChange;

    /// <summary>The distance travelled, in meters, going from one point to the next.</summary>
    private final double mP2P;

    /// <summary>
    /// Creates a new instance of GeodeticMeasurement.
    /// </summary>
    /// <param name="averageCurve">the geodetic curve as measured at the average elevation between two points</param>
    /// <param name="elevationChange">the change in elevation, in meters, going from the starting point to the ending point</param>
    public GeodeticMeasurement(GeodeticCurve averageCurve, double elevationChange)
    {
        double ellDist = averageCurve.getEllipsoidalDistance();

        mCurve = averageCurve;
        mElevationChange = elevationChange;
        mP2P = Math.sqrt(ellDist * ellDist + mElevationChange * mElevationChange);
    }

    /// <summary>
    /// Get the average geodetic curve.  This is the geodetic curve as measured
    /// at the average elevation between two points.
    /// </summary>
    public GeodeticCurve getAverageCurve() {
        return mCurve;
    }

    /// <summary>
    /// Get the ellipsoidal distance (in meters).  This is the length of the average geodetic
    /// curve.  For actual point-to-point distance, use PointToPointDistance property.
    /// </summary>
    public double getEllipsoidalDistance() {
        return mCurve.getEllipsoidalDistance();
    }

    /// <summary>
    /// Get the azimuth.  This is angle from north from start to end.
    /// </summary>
    public Angle getAzimuth() {
        return mCurve.getAzimuth();
    }

    /// <summary>
    /// Get the reverse azimuth.  This is angle from north from end to start.
    /// </summary>
    public Angle getReverseAzimuth() {
        return mCurve.getReverseAzimuth();
    }

    /// <summary>
    /// Get the elevation change, in meters, going from the starting to the ending point.
    /// </summary>
    public double getElevationChange() {
        return mElevationChange;
    }

    /// <summary>
    /// Get the distance travelled, in meters, going from one point to the next.
    /// </summary>
    public Distance getPointToPointDistance() {
        return new Distance(mP2P, DistanceUnit.METRES);
    }

    /// <summary>
    /// Get the GeodeticMeasurement as a string
    /// </summary>
    /// <returns></returns>
    public String ToString()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(mCurve.ToString());
        builder.append(";elev12=");
        builder.append(mElevationChange);
        builder.append(";p2p=");
        builder.append(mP2P);

        return builder.toString();
    }
}