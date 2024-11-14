package com.baesystems.environmentinfrastructure.basictypes.position;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;

//import com.vividsolutions.jts.geom.Coordinate;
//import com.vividsolutions.jts.geom.Geometry;
//import com.vividsolutions.jts.geom.LineString;
//import com.vividsolutions.jts.geom.MultiPolygon;
//import com.vividsolutions.jts.geom.Point;
//import com.vividsolutions.jts.geom.Polygon;






import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;
import com.baesystems.environmentinfrastructure.basictypes.angle.AngleUnit;
import com.baesystems.environmentinfrastructure.basictypes.distance.AltitudeReference;
import com.baesystems.environmentinfrastructure.basictypes.distance.DistanceUnit;
import com.baesystems.environmentinfrastructure.basictypes.distance.Height;

public class GeoPoint3D extends GeoPoint2D {
	
	private static final long serialVersionUID = 1L;
	private Height altitude;
	
	public Height getAltitude() { return altitude; }
	public void setAltitude(Height altitude) { this.altitude = altitude; }
	public GeoPoint2D getCoordinates() { return new GeoPoint2D(latitude, longitude); }
	public void setCoordinates(GeoPoint2D coordinates) {
		this.latitude = coordinates.getLatitude();
		this.longitude = coordinates.getLongitude();
	}
	
	public GeoPoint3D() {
		super();
		altitude = new Height();
	}
	
	public GeoPoint3D(double latitude, double longitude, double altitude, AngleUnit angleUnit, DistanceUnit heightUnit)
	{
		super(latitude, longitude, angleUnit);
		this.altitude = new Height(altitude, heightUnit, AltitudeReference.MSL);
		positionSet = true;
	}

	public GeoPoint3D(Angle latitude, Angle longitude, double altitude, DistanceUnit heightUnit)
	{
		super(latitude, longitude);
		this.altitude = new Height(altitude, heightUnit, AltitudeReference.MSL);
		positionSet = true;
	}

	public GeoPoint3D(Angle latitude, Angle longitude, Height altitude)
	{
		super(latitude, longitude);
		this.altitude = altitude;
		positionSet = true;
	}
	
	public GeoPoint3D(GeoPoint2D coordinates, Height altitude)
	{
		super(coordinates.getLatitude(), coordinates.getLongitude());
		this.altitude = altitude;
		positionSet = true;
	}
	
	public GeoPoint3D(GeoPoint2D coordinates, double altitude, DistanceUnit heightUnit)
	{
		super(coordinates.getLatitude(), coordinates.getLongitude());
    	if(Double.isNaN(altitude)) {
    		System.out.println("Altitude is NaN!");
    		altitude = 0;
    	}
		this.altitude = new Height(altitude, heightUnit, AltitudeReference.MSL);
		positionSet = true;
	}
	
	public GeoPoint3D atMSL() {
		return new GeoPoint3D(this, Height.zero);
	}
	
//	public GeoPoint3D(Point point) {
//		super(Angle.fromDegrees(point.getY()), Angle.fromDegrees(point.getX()));
//		this.altitude = new Height(0, DistanceUnit.METRES);
//		positionSet = true;
//	}
//	
	public GeoPoint3D(Coordinate coordinate) {
		super(Angle.fromDegrees(coordinate.y), Angle.fromDegrees(coordinate.x));
		this.altitude = new Height(coordinate.z, DistanceUnit.METRES, AltitudeReference.MSL);
		positionSet = true;
	}	
	
	public String toString() {
		return new String(super.toString() + " " + this.getAltitude().inMetres());
	}
	
	public static boolean isValid(List<GeoPoint3D> points) {

		if(points.size() == 0)
		{
			return false;
		}
		
		for(GeoPoint3D point : points)
		{
			if(!point.isValid())
			{
				return false;
			}
		}
		
		return true;
	}
	
//	public Coordinate toCoordinate()
//	{
//		return new Coordinate(this.longitude.inDegrees(), this.latitude.inDegrees(), this.altitude.inMetres());
//	}
//	
//	public static List<Coordinate> GeoPoint3DListToCoordinateList(List<GeoPoint3D> geoPoints)
//	{
//		List<Coordinate> coordinates = new ArrayList<Coordinate>();
//		for(GeoPoint3D geoPoint : geoPoints)
//		{
//			coordinates.add(geoPoint.toCoordinate());
//		}
//		return coordinates;
//	}
//	
//	public static Coordinate[] GeoPoint3DListToCoordinateArray(List<GeoPoint3D> geoPoints) {
//		Coordinate[] coordinates = new Coordinate[geoPoints.size()];
//		for(int i=0; i<geoPoints.size(); i++)
//		{
//			coordinates[i] = geoPoints.get(i).toCoordinate();
//		}
//		
//		return coordinates;
//	}
//	
//	public static Coordinate[] GeoPoint3DListToCoordinateArrayRing(List<GeoPoint3D> geoPoints) {
//		Coordinate[] coordinates = new Coordinate[geoPoints.size() + 1];
//		for(int i=0; i<geoPoints.size(); i++)
//		{
//			coordinates[i] = geoPoints.get(i).toCoordinate();
//		}
//		coordinates[geoPoints.size()] = coordinates[0];
//		
//		return coordinates;
//	}
	
	public static boolean equals(GeoPoint3D position1, GeoPoint3D position2) {
		return GeoPoint2D.equals(position1.getCoordinates(), position2.getCoordinates()) && 
				(position1.getAltitude().inMetres() == position2.getAltitude().inMetres());
	}
	
//	public static List<GeoPoint3D> GeoPoint3DListFromCoordinateList(List<Coordinate> coordinates) {
//		List<GeoPoint3D> points = new ArrayList<GeoPoint3D>();
//		for(Coordinate coordinate : coordinates)
//		{
//			points.add(new GeoPoint3D(coordinate));
//		}
//		return points;
//	}
	
	public static boolean positionsChanged(List<GeoPoint3D> positions1, List<GeoPoint3D> positions2) {

		if(positions1.size() != positions2.size())
		{
			return true;
		}
		else
		{
			for(int i = 0; i< positions1.size(); i++)
			{
				if(!positions1.get(i).equals(positions2.get(i)))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
//	public static List<GeoPoint3D> GeometryToGeoPoints(Geometry geometry)
//	{
//		List<GeoPoint3D> points = new ArrayList<GeoPoint3D>();
//		
//    	if(geometry instanceof Point) {
//    		points = new ArrayList<GeoPoint3D>();
//    		Coordinate coordinate = ((Point) geometry).getCoordinate();
//    		points.add(new GeoPoint3D(coordinate.y, coordinate.x, coordinate.z, AngleUnit.DEGREES, DistanceUnit.METRES));
//    		return points;
//    	}
//    	else
//    	{
//	    	if(geometry instanceof MultiPolygon) {
//	    		MultiPolygon multiPolygon = (MultiPolygon) geometry;
//	    		if(multiPolygon.getNumGeometries() > 0 && multiPolygon.getGeometryN(0) instanceof Polygon)
//	    		{
//	    			points = CoordinatesToGeoPoints(((Polygon) multiPolygon.getGeometryN(0)).getExteriorRing().getCoordinates());
//	    			points.remove(points.size()-1); // remove the end point from the ring (same as start point)
//	    		}
//	    		return points;
//	    	}
//	    	else if(geometry instanceof Polygon) {
//	    		points = CoordinatesToGeoPoints(((Polygon) geometry).getExteriorRing().getCoordinates());
//	    		points.remove(points.size()-1); // remove the end point from the ring (same as start point)
//	    		return points;
//	    	}
//	    	else if(geometry instanceof LineString) {
//	    		return CoordinatesToGeoPoints(((LineString) geometry).getCoordinates());
//	    	}
//    	}
//    	return points;
//	}
//	
//	public static GeoPoint3D GeometryToGeoPoint(Geometry geometry)
//	{
//		List<GeoPoint3D> points = GeometryToGeoPoints(geometry);
//		if(points.size() > 0)
//		{
//			return points.get(0);
//		}
//		else
//		{
//			return new GeoPoint3D();
//		}		
//	}
//	
//	public static List<GeoPoint3D> CoordinatesToGeoPoints(Coordinate[] coordinates)
//	{
//		List<GeoPoint3D> points = new ArrayList<GeoPoint3D>();
//    	for(Coordinate coordinate : coordinates)
//    	{
//    		points.add(new GeoPoint3D(coordinate.y, coordinate.x, coordinate.z, AngleUnit.DEGREES, DistanceUnit.METRES));
//    	}
//    	return points;
//	}
	
	public static List<GeoPoint3D> GeoPoint3DListFromGeoPoint2DList(List<GeoPoint2D> geoPoint2DList) {
		List<GeoPoint3D> geoPoint3DList = new ArrayList<GeoPoint3D>();
		for(GeoPoint2D geoPoint2D : geoPoint2DList) {
			geoPoint3DList.add(new GeoPoint3D(geoPoint2D, 0, DistanceUnit.METRES));
		}
		return geoPoint3DList;
	}
	
	public static List<GeoPoint2D> GeoPoint2DListFromGeoPoint3DList(List<GeoPoint3D> geoPoint3DList) {
		List<GeoPoint2D> geoPoint2DList = new ArrayList<GeoPoint2D>();
		for(GeoPoint3D geoPoint3D : geoPoint3DList) {
			geoPoint2DList.add(geoPoint3D.getCoordinates());
		}
		return geoPoint2DList;
	}
	
//	public static GeoPoint2D getTopLeft(List<GeoPoint3D> points) {
//		return GeoPoint2D.getTopLeft(GeoPoint2DListFromGeoPoint3DList(points));
//	}
//	
//	public static GeoPoint2D getBottomRight(List<GeoPoint3D> points) {
//		return GeoPoint2D.getBottomRight(GeoPoint2DListFromGeoPoint3DList(points));
//	}
	
}
