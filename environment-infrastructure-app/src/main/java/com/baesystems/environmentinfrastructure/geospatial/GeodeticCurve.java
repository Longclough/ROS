//This is the outcome of a geodetic calculation.  It represents the path and
//ellipsoidal distance between two GeoPoint2D for a specified reference.
//
//This code is derived from Version 1.1.1 of Gavaghan.Geodesy. 
//See http://www.gavaghan.org/blog/free-source-code/geodesy-library-vincentys-formula/
//Gavaghan.Geodesy source code is made freely available for use and modification
//without restriction. 

package com.baesystems.environmentinfrastructure.geospatial;

import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;

 /// <summary>
 /// This is the outcome of a geodetic calculation.  It represents the path and
 /// ellipsoidal distance between two GeoPoint2D for a specified reference
 /// ellipsoid.
 /// </summary>
 public class GeodeticCurve
 {
     /// <summary>Ellipsoidal distance (in meters).</summary>
     private double mEllipsoidalDistance;

     /// <summary>Azimuth (degrees from north).</summary>
     private Angle mAzimuth;

     /// <summary>Reverse azimuth (degrees from north).</summary>
     private Angle mReverseAzimuth;

     /// <summary>
     /// Create a new GeodeticCurve.
     /// </summary>
     /// <param name="ellipsoidalDistance">ellipsoidal distance in meters</param>
     /// <param name="azimuth">azimuth in degrees</param>
     /// <param name="reverseAzimuth">reverse azimuth in degrees</param>
     public GeodeticCurve(double ellipsoidalDistance, Angle azimuth, Angle reverseAzimuth)
     {
         mEllipsoidalDistance = ellipsoidalDistance;
         mAzimuth = azimuth;
         mReverseAzimuth = reverseAzimuth;
     }

     /// <summary>Ellipsoidal distance (in meters).</summary>
     public double getEllipsoidalDistance() {
         return mEllipsoidalDistance;
     }

     /// <summary>
     /// Get the azimuth.  This is angle from north from start to end.
     /// </summary>
     public Angle getAzimuth() {
         return mAzimuth;
     }

     /// <summary>
     /// Get the reverse azimuth.  This is angle from north from end to start.
     /// </summary>
     public Angle getReverseAzimuth() { 
    	 return mReverseAzimuth;
     }

     /// <summary>
     /// Get curve as a string.
     /// </summary>
     /// <returns></returns>
     public String ToString()
     {
         StringBuilder builder = new StringBuilder();
         
         builder.append("s=");
         builder.append(mEllipsoidalDistance);
         builder.append(";a12=");
         builder.append(mAzimuth);
         builder.append(";a21=");
         builder.append(mReverseAzimuth);
         builder.append(";");

         return builder.toString();
     }
 }
