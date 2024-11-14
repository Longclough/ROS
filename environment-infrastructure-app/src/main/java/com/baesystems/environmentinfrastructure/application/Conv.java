package com.baesystems.environmentinfrastructure.application;

import java.util.ArrayList;
import java.util.List;

import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;
import com.baesystems.environmentinfrastructure.basictypes.angle.AngleUnit;
import com.baesystems.environmentinfrastructure.basictypes.distance.DistanceUnit;
import com.baesystems.environmentinfrastructure.basictypes.distance.Height;
import com.baesystems.environmentinfrastructure.basictypes.position.GeoPoint2D;
import com.baesystems.environmentinfrastructure.basictypes.position.GeoPoint3D;
import com.baesystems.environmentinfrastructure.geospatial.Ellipsoid;
import com.baesystems.environmentinfrastructure.geospatial.GeodeticCalculator;

public class Conv {

	private static GeodeticCalculator gc = new GeodeticCalculator();

	public static List<GeoPoint3D> makePointsFrom2DPosList(String posList, double alt) {
    	List<GeoPoint3D> points = new ArrayList<GeoPoint3D>();
    	String[] posArray = posList.split(" ");
    	for(int k = 0; k < posArray.length - 1; k = k + 2)
    	{
    		points.add(new GeoPoint3D(Double.parseDouble(posArray[k]), Double.parseDouble(posArray[k+1]), alt, AngleUnit.DEGREES, DistanceUnit.METRES));
    	}
    	return points;
    }
    
	public static List<GeoPoint3D> makeInclinedPointsFrom2DPosList(String posList, Height startAlt, Angle inclination, Height minEndAlt, Height maxEndAlt) {
    	List<GeoPoint3D> points = new ArrayList<GeoPoint3D>();
    	String[] posArray = posList.split(" ");
  	
    	double alt = startAlt.getMAMSL();
    	boolean okToAdd = true;
    	for(int k = 0; k < posArray.length - 1; k = k + 2)
    	{
        	GeoPoint3D latLon = new GeoPoint3D(Double.parseDouble(posArray[k]), Double.parseDouble(posArray[k+1]), 0, AngleUnit.DEGREES, DistanceUnit.METRES);
    		if(points.size() > 0)
    		{
    			GeoPoint3D lastLatLon = points.get(points.size()-1).atMSL();
    			okToAdd = !GeoPoint2D.equals(latLon, lastLatLon);
    			if(okToAdd) {
    				double deltaAlt = (Math.tan(inclination.inRadians()) * gc.CalculateGeodeticMeasurement(Ellipsoid.WGS84, latLon, lastLatLon).getPointToPointDistance().inMetres());
	    			alt = points.get(points.size()-1).getAltitude().getMAMSL() + deltaAlt;
	    			if(alt > maxEndAlt.getMAMSL()) {
	    				alt = maxEndAlt.getMAMSL();
	    			}
    			}
    			else {
    			}
    		}
    		
    		if(okToAdd)
    		{
    			points.add(new GeoPoint3D(latLon, alt, DistanceUnit.METRES));
    		}
    	}
    	
    	return points;
    }
    
	public static List<GeoPoint3D> makePointsFrom3DPosList(String posList) {
    	List<GeoPoint3D> points = new ArrayList<GeoPoint3D>();
    	String[] posArray = posList.split(" ");
    	for(int k = 0; k < posArray.length - 2; k = k + 3)
    	{
    		points.add(new GeoPoint3D(Double.parseDouble(posArray[k]), Double.parseDouble(posArray[k+1]), Double.parseDouble(posArray[k+2]), AngleUnit.DEGREES, DistanceUnit.METRES));
    	}
    	return points;
    }
    
    public static GeoPoint3D makePointFrom3DString(String pos) {
    	String[] posArray = pos.split(" ");
    	return new GeoPoint3D(Double.parseDouble(posArray[0]), Double.parseDouble(posArray[1]), Double.parseDouble(posArray[2]), AngleUnit.DEGREES, DistanceUnit.METRES);
    }
}
