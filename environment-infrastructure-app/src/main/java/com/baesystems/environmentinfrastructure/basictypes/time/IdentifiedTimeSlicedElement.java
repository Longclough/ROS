package com.baesystems.environmentinfrastructure.basictypes.time;

import java.util.List;

import jakarta.persistence.MappedSuperclass;

import com.baesystems.environmentinfrastructure.application.IdentifiedElement;

@MappedSuperclass
public abstract class IdentifiedTimeSlicedElement extends IdentifiedElement implements ITimeSliced {

	public IdentifiedTimeSlicedElement() {}

	public IdentifiedTimeSlicedElement(String uid) {
		super(uid);
	}

	public static TimeSlice getBaseline(List<? extends TimeSlice> timeSlices) {
		for(TimeSlice timeSlice : timeSlices) {
			if(timeSlice.getTimeData().getInterpretation().equals("BASELINE")) {
				return timeSlice;
			}
		}
		for(TimeSlice timeSlice : timeSlices) {
			if(timeSlice.getTimeData().getInterpretation().equals("SNAPSHOT")) {
				return timeSlice;
			}
		}
		for(TimeSlice timeSlice : timeSlices) {
			if(timeSlice.getTimeData().getInterpretation().equals("PERMDELTA")) {
				return timeSlice;
			}
		}
		return null;
	}
	
	public TimeSlice getSnapshot() {
		return null;
	}
	
	@Override
	public String toString() {
		return getSnapshot().toString();
	}
}
