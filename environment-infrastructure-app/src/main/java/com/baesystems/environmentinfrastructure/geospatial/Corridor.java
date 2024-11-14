package com.baesystems.environmentinfrastructure.geospatial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.geom.GeometryFactory;

import com.baesystems.environmentinfrastructure.basictypes.angle.Angle;
import com.baesystems.environmentinfrastructure.basictypes.distance.Distance;
import com.baesystems.environmentinfrastructure.basictypes.distance.DistanceUnit;
import com.baesystems.environmentinfrastructure.basictypes.position.GeoPoint2D;
import com.baesystems.environmentinfrastructure.basictypes.position.GeoPoint3D;

public class Corridor {
	
	private static GeodeticCalculator gc = new GeodeticCalculator();
	private static GeometryFactory gf = new GeometryFactory(new PrecisionModel(), 4326);
	
	public static Polygon makeCorridor(LineString centreLine, Distance width) {
		List<Coordinate> coordinates = Arrays.asList(centreLine.getCoordinates());
		List<Coordinate> left = new ArrayList<>();
		List<Coordinate> right = new ArrayList<>();
		for(int i = 0; i < coordinates.size() - 2; i++) {
			GeoPoint3D previousPoint = null;
			if(i>0) {
				previousPoint = new GeoPoint3D(coordinates.get(i-1));
			}
			GeoPoint3D thisPoint = new GeoPoint3D(coordinates.get(i));
			GeoPoint3D nextPoint = null;
			if(i<coordinates.size() - 1) {
				nextPoint = new GeoPoint3D(coordinates.get(i+1));
			}
			Angle previousLegBearing = null;
			if(previousPoint != null) {
				previousLegBearing = gc.CalculateGeodeticMeasurement(Ellipsoid.WGS84, previousPoint, thisPoint).getAzimuth();
			}
			
			Angle nextLegBearing = null; 
			if(nextPoint != null) {
				nextLegBearing = gc.CalculateGeodeticMeasurement(Ellipsoid.WGS84, thisPoint, nextPoint).getAzimuth();
			}
			
			Distance halfWidth = new Distance(width.inMetres()/2, DistanceUnit.METRES);
			
			GeoPoint2D pointL;
			GeoPoint2D pointR;
			if(previousLegBearing == null) {
				pointL = gc.CalculateEndingCoordinates(Ellipsoid.WGS84, thisPoint, nextLegBearing.subtract(Angle.Angle90), halfWidth);
				pointR = gc.CalculateEndingCoordinates(Ellipsoid.WGS84, thisPoint, nextLegBearing.subtract(Angle.Angle90), halfWidth);
			} else if (nextLegBearing == null) {
				pointL = gc.CalculateEndingCoordinates(Ellipsoid.WGS84, thisPoint, previousLegBearing.add(Angle.Angle90), halfWidth);
				pointR = gc.CalculateEndingCoordinates(Ellipsoid.WGS84, thisPoint, previousLegBearing.add(Angle.Angle90), halfWidth);

			} else {
				Angle delta = nextLegBearing.subtract(previousLegBearing).make0To360();
				Angle halfDelta = Angle.fromDegrees(delta.inDegrees()/2);
				//if(delta.inDegrees() > 0 && delta.inDegrees() < 180) {
					Distance r = new Distance(halfWidth.inMetres()/Math.cos(halfDelta.inRadians()),DistanceUnit.METRES); 
					pointL = gc.CalculateEndingCoordinates(Ellipsoid.WGS84, thisPoint, nextLegBearing.subtract(Angle.Angle90).add(halfDelta), r);
					pointR = gc.CalculateEndingCoordinates(Ellipsoid.WGS84, thisPoint, nextLegBearing.add(Angle.Angle90).add(halfDelta), r);
				//} else
			}
			left.add(pointL.toCoordinate());
			right.add(0, pointR.toCoordinate());			
		}
		
		List<Coordinate> corridor = new ArrayList<>();
		corridor.addAll(left);
		corridor.addAll(right);
		
		Coordinate[] corridorCoordinates = new Coordinate[corridor.size()];
		return gf.createPolygon(corridor.toArray(corridorCoordinates));
	}
}
