package com.baesystems.environmentinfrastructure.geospatial;

import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;

public class Ellipsoid
 {
     private final double a;
     private final double b;
     private final double mFlattening;
     private final double mInverseFlattening;
     private final double e2;
     // private final double ep2;

     public double getSemiMajorAxis() {
         return a;
     }

     public double getSemiMinorAxis() {
         return b;
     }

     public double getFlattening() {
         return mFlattening;
     }

     public double getInverseFlattening() {
         return mInverseFlattening;
     }

     public double getEccentricity() {
         return Math.sqrt(e2);
     }

     protected Ellipsoid(double semiMajor, double semiMinor, double flattening, double inverseFlattening)
     {
         a = semiMajor;
         b = semiMinor;
         mFlattening = flattening;
         mInverseFlattening = inverseFlattening;

         e2 = mFlattening * (2 - mFlattening);
         // ep2 = (a * a - b * b) / (b * b);
     }

     static public Ellipsoid FromAAndInverseF(double semiMajor, double inverseFlattening)
     {
         double f = 1.0 / inverseFlattening;
         double b = (1.0 - f) * semiMajor;

         return new Ellipsoid(semiMajor, b, f, inverseFlattening);
     }

     static public Ellipsoid FromAAndF(double semiMajor, double flattening)
     {
         double inverseF = 1.0 / flattening;
         double b = (1.0 - flattening) * semiMajor;

         return new Ellipsoid(semiMajor, b, flattening, inverseF);
     }
     
     static public final Ellipsoid WGS84 = FromAAndInverseF(6378137.0, 298.257223563);
     static public final Ellipsoid GRS80 = FromAAndInverseF(6378137.0, 298.257222101);
     static public final Ellipsoid GRS67 = FromAAndInverseF(6378160.0, 298.25);
     static public final Ellipsoid ANS = FromAAndInverseF(6378160.0, 298.25);
     static public final Ellipsoid WGS72 = FromAAndInverseF(6378135.0, 298.26);
     static public final Ellipsoid Clarke1858 = FromAAndInverseF(6378293.645, 294.26);
     static public final Ellipsoid Clarke1880 = FromAAndInverseF(6378249.145, 293.465);
     static public final Ellipsoid Sphere = FromAAndF(6371000, 0.0);

     // Get the Meridional Radius
     public double RM(Angle latitude)
     {
         double sinLat = Math.sin(latitude.inRadians());
         return a * (1.0 - e2) / Math.pow(1.0 - e2 * sinLat * sinLat, 1.5);
     }

     // Get the Normal Radius
     public double RN(Angle latitude)
     {
         double sinLat = Math.sin(latitude.inRadians());
         return a / Math.sqrt(1.0 - e2 * sinLat * sinLat);
     }
 }