package com.baesystems.environmentinfrastructure.basictypes.time;

import java.util.concurrent.TimeUnit;

public class Duration {
	private double timeInMilliseconds;
	private boolean timeSet = false;
	
	public double inMilliseconds() { return timeInMilliseconds; }
	public double inSeconds() { return timeInMilliseconds / 1000; }
	public double inMinutes() { return timeInMilliseconds / 1000 / 60; }
	public double inHours() { return timeInMilliseconds / 1000 / 60 / 60; }
	public double inDays() { return timeInMilliseconds / 1000 / 60 / 60 / 24; }
	
	public Duration() {
		timeInMilliseconds = 0;
	}
	
	public Duration(double value, TimeUnit unit, TimeReference reference)
	{
		switch(unit)
		{
			case NANOSECONDS:
				timeInMilliseconds = value / (1000 * 1000);
				timeSet = true;
				break;
			case MICROSECONDS:
				timeInMilliseconds = value / 1000;
				timeSet = true;
				break;
			case MILLISECONDS:
				timeInMilliseconds = value;
				timeSet = true;
				break;
			case SECONDS:
				timeInMilliseconds = value * 1000;
				timeSet = true;
				break;
			case MINUTES:
				timeInMilliseconds = value * 60 * 1000;
				timeSet = true;
				break;
			case HOURS:
				timeInMilliseconds = value * 60 * 60 * 1000;
				timeSet = true;
				break;
			case DAYS:
				timeInMilliseconds = value * 24 * 60 * 60 * 1000;
				timeSet = true;
				break;
			default:
				break;
		}
	}
	
	public boolean isValid() {
		return timeSet;
	}
	
	public String toString() {
		if(inMilliseconds() < 1000) {
			return inMilliseconds() + "ms";
		} else if (inSeconds() < 60) {
			return inSeconds() + "s";
		} else if (inMinutes() < 60) {
			return inMinutes() + "m";
		} else if (inHours() < 24) {
			return inHours() + "h";
		} else {
			return inDays() + "d";
		} 
	}
}
