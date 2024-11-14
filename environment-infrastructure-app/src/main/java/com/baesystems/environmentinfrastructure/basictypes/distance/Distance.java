package com.baesystems.environmentinfrastructure.basictypes.distance;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Distance implements Serializable{

	private static final long serialVersionUID = 1L;

	private double distanceInMetres;
	protected boolean distanceSet = false;
	
	private static final double NMToM = 1852;
    public static double ftToM = 0.3048;
	public static Distance zero = new Distance(0, DistanceUnit.METRES);
	
	public double inMetres() { return distanceInMetres; }
	public double inFeet() { return distanceInMetres / ftToM; }
	
	public double getDistanceInMetres() { return distanceInMetres; }
	public void setDistanceInMetres(double distanceInMetres) { this.distanceInMetres = distanceInMetres; }
	
	public Distance() {
		distanceInMetres = 0;
	}
	
	public Distance(double value, DistanceUnit unit) {

		switch(unit)
		{
			case METRES:
				initialiseFromMetres(value);
				break;
			case FEET:
				initialiseFromFeet(value);
				break;
			case NAUTICALMILES:
				initialiseFromNauticalMiles(value);
				break;
		}	
	}
	
	private void initialiseFromMetres(double value)
	{
		distanceInMetres = value;
		distanceSet = true;
	}
	
	private void initialiseFromFeet(double value)
	{
		distanceInMetres = value * ftToM;
		distanceSet = true;
	}
	
	private void initialiseFromNauticalMiles(double value)
	{
		distanceInMetres = value * NMToM;
		distanceSet = true;
	}
	
	public Distance(String distanceUnitString, String distanceString)
	{
		double value = Double.parseDouble(distanceString);
		String distanceUnitStringLowerCase = distanceUnitString.toLowerCase();
		
		if(distanceUnitStringLowerCase.matches("km"))
		{
			initialiseFromMetres(value * 1000);
		}
		else if(distanceUnitStringLowerCase.matches("nm") || distanceUnitStringLowerCase.matches("[nmi_i]"))
		{
			initialiseFromNauticalMiles(value);
		}
		else
		{
			initialiseFromMetres(value);
		}
	}
	
	public Distance add(Distance distance) {
		return new Distance (this.inMetres() + distance.inMetres(), DistanceUnit.METRES);
	}
	
	public Distance subtract(Distance distance) {
		return new Distance (this.inMetres() - distance.inMetres(), DistanceUnit.METRES);
	}
	
	public Distance multiply(double multiplier) {
		return new Distance (this.inMetres() * multiplier, DistanceUnit.METRES);
	}
	
	public boolean isValid() {
		return distanceSet && distanceInMetres > 0;
	}

	public Distance pow(double power) {
		return new Distance (Math.pow(this.inMetres(), power), DistanceUnit.METRES);
	}

	public boolean isGreaterThan(Distance distance) {
		return this.inMetres() > distance.inMetres();
	}
	
	public boolean isGreaterThanOrEqualTo(Distance distance) {
		return this.inMetres() >= distance.inMetres();
	}
	
	public boolean isLessThan(Distance distance) {
		return this.inMetres() < distance.inMetres();
	}
	
	public boolean isLessThanOrEqualTo(Distance distance) {
		return this.inMetres() <= distance.inMetres();
	}
	
	public static Distance invalid() {
		return new Distance(-1, DistanceUnit.METRES);
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(distanceInMetres) + "m";
	}
	
	public static Distance fromMetres(double metres) {
		return new Distance(metres, DistanceUnit.METRES);
	}
	
	public boolean equals(Distance distance) {
		return this.inMetres() == distance.inMetres();
	}
	
	public double inKM() {
		return inMetres() / 1000;
	}
	
	public double inNM() {
		return inMetres() / NMToM;
	}
	
	public static Distance getPythagSideH(Distance a, Distance b) {
		Distance aSquared = a.pow(2);
		Distance bSquared = b.pow(2);
		Distance sumOfSquares = aSquared.add(bSquared);
		return sumOfSquares.pow(0.5);
	}
	
	public static Distance getPythagSideA(Distance h, Distance b) {
		Distance h2 = h.pow(2);
		Distance b2 = b.pow(2);
		Distance h2minusb2 = h2.subtract(b2);
		return h2minusb2.pow(0.5);
	}
	public static Distance fromFt(double ft) {
		return new Distance(ft, DistanceUnit.FEET);
	}
	
	public static Distance fromNM(double nm) {
		return new Distance(nm, DistanceUnit.NAUTICALMILES);
	}
}
