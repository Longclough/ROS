package com.baesystems.environmentinfrastructure.basictypes.position;

import java.io.Serializable;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;

//import com.vividsolutions.jts.geom.Coordinate;
//import com.vividsolutions.jts.geom.Geometry;
//import com.vividsolutions.jts.geom.GeometryFactory;
//import com.vividsolutions.jts.geom.LinearRing;
//import com.vividsolutions.jts.geom.Point;
//import com.vividsolutions.jts.geom.Polygon;



import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;
import com.baesystems.environmentinfrastructure.basictypes.angle.AngleUnit;

public class GeoPoint2D implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Latitude latitude;
	protected Longitude longitude;
	transient protected boolean positionSet = false;
	
	public Latitude getLatitude() { return latitude; }
	public void setLatitude(Latitude latitude) { this.latitude = latitude; positionSet = true; }
	public Longitude getLongitude() { return longitude; }
	public void setLongitude(Longitude longitude) { this.longitude = longitude; positionSet = true; }
	
	public GeoPoint2D() {
		latitude = new Latitude();
		longitude = new Longitude();
	}
	
	public GeoPoint2D(double latitude, double longitude, AngleUnit angleUnit) {
		this.latitude = new Latitude(latitude, angleUnit);
		this.longitude = new Longitude(longitude, angleUnit);
		positionSet = true;
	}
	
	public GeoPoint2D(Latitude latitude, Longitude longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		positionSet = true;
	}
	
	public GeoPoint2D(Angle latitude, Angle longitude) {
		this.latitude = new Latitude(latitude);
		this.longitude = new Longitude(longitude);
		positionSet = true;
	}
	
//	public GeoPoint2D(Coordinate coordinate) {
//		this.latitude = new Latitude(coordinate.y, AngleUnit.DEGREES);
//		this.longitude = new Longitude(coordinate.x, AngleUnit.DEGREES);
//		positionSet = true;
//	}
	
	public boolean isValid() {
		return positionSet;
	}
	
	public boolean equals(GeoPoint2D positionToCompare) {
		if(this.latitude.inDegrees() != positionToCompare.getLatitude().inDegrees())
			return false;
		else if(this.longitude.inDegrees() != positionToCompare.getLongitude().inDegrees())
			return false;
		else
			return true;
	}
	
	public Coordinate toCoordinate()
	{
		return new Coordinate(this.longitude.inDegrees(), this.latitude.inDegrees());
	}
//	
//	public static List<Coordinate> GeoPoint2DListToCoordinateList(List<GeoPoint2D> geoPoints)
//	{
//		List<Coordinate> coordinates = new ArrayList<Coordinate>();
//		for(GeoPoint2D geoPoint : geoPoints)
//		{
//			coordinates.add(geoPoint.toCoordinate());
//		}
//		return coordinates;
//	}
//	
//	public static Coordinate[] GeoPoint2DListToCoordinateArray(List<GeoPoint2D> geoPoints)
//	{
//		Coordinate[] coordinates = new Coordinate[geoPoints.size()];
//		for(int i=0; i<geoPoints.size(); i++)
//		{
//			coordinates[i] = geoPoints.get(i).toCoordinate();
//		}
//		
//		return coordinates;
//	}
//	
//	public static Coordinate[] GeoPoint2DListToCoordinateArrayRing(List<GeoPoint2D> geoPoints)
//	{
//		Coordinate[] coordinates = new Coordinate[geoPoints.size() + 1];
//		for(int i=0; i<geoPoints.size(); i++)
//		{
//			coordinates[i] = geoPoints.get(i).toCoordinate();
//		}
//		coordinates[geoPoints.size()] = coordinates[0];
//		
//		return coordinates;
//	}
	
	public String toString() {
		return new String(this.getLatitude().inDegrees() + " " + this.getLongitude().inDegrees());
	}
	
	public static boolean equals(GeoPoint2D coordinates1, GeoPoint2D coordinates2) {
		return (coordinates1.getLatitude().inDegrees() == coordinates2.getLatitude().inDegrees()) &&
				(coordinates1.getLongitude().inDegrees() == coordinates2.getLongitude().inDegrees());
	}
	public static GeoPoint2D getTopLeft(List<GeoPoint2D> positions) {
		double top = -90;
		double left = 180;
		for(GeoPoint2D position : positions) {
			if(position.getLongitude().inDegrees() < left) {
				left = position.getLongitude().inDegrees();
			}
			if(position.getLatitude().inDegrees() > top) {
				top = position.getLatitude().inDegrees();
			}
		}
		return new GeoPoint2D(top, left, AngleUnit.DEGREES);
	}
	public static GeoPoint2D getBottomRight(List<GeoPoint2D> positions) {
		double bottom = 90;
		double right = -180;
		for(GeoPoint2D position : positions) {
			if(position.getLongitude().inDegrees() > right) {
				right = position.getLongitude().inDegrees();
			}
			if(position.getLatitude().inDegrees() < bottom) {
				bottom = position.getLatitude().inDegrees();
			}
		}
		return new GeoPoint2D(bottom, right, AngleUnit.DEGREES);
	}
	
	public static boolean boundingBoxesOverlap(GeoPoint2D topLeft1, GeoPoint2D bottomRight1, GeoPoint2D topLeft2, GeoPoint2D bottomRight2) {
//	    return !(topLeft2.getLongitude().inDegrees() > bottomRight1.getLongitude().inDegrees()
//	            || bottomRight2.getLongitude().inDegrees() < topLeft1.getLongitude().inDegrees()
//	            || topLeft2.getLatitude().inDegrees() > bottomRight1.getLatitude().inDegrees()
//	            || bottomRight2.getLatitude().inDegrees() < topLeft1.getLatitude().inDegrees());
		
//		double width1 = Math.abs(bottomRight1.getLongitude().inDegrees() - topLeft1.getLongitude().inDegrees());
//		double width2 = Math.abs(bottomRight2.getLongitude().inDegrees() - topLeft2.getLongitude().inDegrees());
//		double height1 = Math.abs(topLeft1.getLatitude().inDegrees() - bottomRight1.getLatitude().inDegrees());
//		double height2 = Math.abs(topLeft2.getLatitude().inDegrees() - bottomRight2.getLatitude().inDegrees());
//		
//		return (Math.abs(topLeft1.getLongitude().inDegrees() - topLeft2.getLongitude().inDegrees()) * 2 < (width1 + width2)) &&
//		         (Math.abs(topLeft1.getLatitude().inDegrees() - topLeft2.getLatitude().inDegrees()) * 2 < (height1 + height2));

		// http://goanna.cs.rmit.edu.au/~gl/teaching/rtr&3dgp/notes/intersection.pdf
		if(topLeft1 != null && bottomRight1 != null && topLeft2 != null && bottomRight2 != null) {
			if(bottomRight1.getLatitude().inDegrees() > topLeft2.getLatitude().inDegrees() || bottomRight2.getLatitude().inDegrees() > topLeft1.getLatitude().inDegrees()) {
				return false;
			} else if(topLeft1.getLongitude().inDegrees() > bottomRight2.getLongitude().inDegrees() || topLeft2.getLongitude().inDegrees() > bottomRight1.getLongitude().inDegrees()) {
				return false;
			} else { 
				return true;
			}
		} else {
			return false;
		}
	}
	
//	public static GeoPoint2D getTopLeft(List<? extends GeoPoint2D> points) {
//		return getTopLeft(getPolygonGeometry(points));
//	}
//	
//	public static GeoPoint2D getBottomRight(List<? extends GeoPoint2D> points) {
//		return getBottomRight(getPolygonGeometry(points));
//	}
//	
//	private static Geometry getPolygonGeometry(List<? extends GeoPoint2D> points) {
//		GeometryFactory geometryFactory = new GeometryFactory();
//		List<Coordinate> coordinates = new ArrayList<Coordinate>();
//
//		for(GeoPoint2D p : points) 
//		{
//			coordinates.add(p.toCoordinate());
//		}
//		coordinates.add(coordinates.get(0));
//		
//		Coordinate[] coordinatesArray = (Coordinate[])coordinates.toArray(new Coordinate[coordinates.size()]);
//		LinearRing linearRing = geometryFactory.createLinearRing(coordinatesArray);
//		Geometry geometry = geometryFactory.createPolygon(linearRing, null);	
//		return geometry;
//	}
//	
//	public static GeoPoint2D getBottomRight(Geometry geometry) {
//		Geometry envelope = geometry.getEnvelope();
//		
//		// If this Geometry is the empty geometry, returns an empty Point. 
//		// If the Geometry is a point, returns a non-empty Point. 
//		// Otherwise, returns a Polygon whose points are (minx, miny), (maxx, miny), (maxx, maxy), (minx, maxy), (minx, miny). 
//		
//		if(envelope instanceof Polygon)
//		{
//			double maxLong = -180;
//			double minLat = 90;
//			for(Coordinate coordinate : envelope.getCoordinates())
//			{
//				if(coordinate.x > maxLong) {
//					maxLong = coordinate.x;
//				}
//				if(coordinate.y < minLat) {
//					minLat = coordinate.y;
//				}
//			}
//			return new GeoPoint2D(minLat, maxLong, AngleUnit.DEGREES);
//		}
//		else if (envelope instanceof Point)
//		{
//			return new GeoPoint2D(((Point) envelope).getCoordinate());
//		}
//		else
//		{
//			return new GeoPoint2D(new Coordinate(0,0));
//		}
//	}
//	
//	public static GeoPoint2D getTopLeft(Geometry geometry) {
//		Geometry envelope = geometry.getEnvelope();
//		
//		// If this Geometry is the empty geometry, returns an empty Point. 
//		// If the Geometry is a point, returns a non-empty Point. 
//		// Otherwise, returns a Polygon whose points are (minx, miny), (maxx, miny), (maxx, maxy), (minx, maxy), (minx, miny). Alledgedly, but they don't seem to be in this order...
//		
//		if(envelope instanceof Polygon)
//		{
//			double minLong = 180;
//			double maxLat = -90;
//			for(Coordinate coordinate : envelope.getCoordinates())
//			{
//				if(coordinate.x < minLong) {
//					minLong = coordinate.x;
//				}
//				if(coordinate.y > maxLat) {
//					maxLat = coordinate.y;
//				}
//			}
//			return new GeoPoint2D(maxLat, minLong, AngleUnit.DEGREES);
//		}
//		else if (envelope instanceof Point)
//		{
//			return new GeoPoint2D(((Point) envelope).getCoordinate());
//		}
//		else
//		{
//			return new GeoPoint2D(new Coordinate(0,0));
//		}
//	}
}
