package com.baesystems.environmentinfrastructure.airspace;

import java.util.List;

import aero.aixm.schema._5.AirspaceActivationType;

import com.baesystems.environmentinfrastructure.basictypes.time.Timesheet;
import com.baesystems.environmentinfrastructure.types.StatusAirspaceCode;

public class AirspaceActivation {

	private AirspaceActivationType airspaceActivationType;
	private String activity; 
	private List<String> annotation;
	private StatusAirspaceCode status;
	private List<Timesheet> timeInterval;
	
	public AirspaceActivationType getAirspaceActivationType() {
		return airspaceActivationType;
	}

	public String getActivity() {
		return activity;
	}

	public List<String> getAnnotation() {
		return annotation;
	}

	public StatusAirspaceCode getStatus() {
		return status;
	}

	public List<Timesheet> getTimeInterval() {
		return timeInterval;
	}
	
	public AirspaceActivation(
			AirspaceActivationType airspaceActivationType,
			String activity, 
			List<String> annotation, 
			StatusAirspaceCode status,
			List<Timesheet> timeInterval) {
		this.airspaceActivationType = airspaceActivationType;
		this.activity = activity;
		this.annotation = annotation;
		this.status = status;
		this.timeInterval = timeInterval;
	}
}
