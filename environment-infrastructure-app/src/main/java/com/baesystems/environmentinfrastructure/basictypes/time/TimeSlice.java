package com.baesystems.environmentinfrastructure.basictypes.time;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

import com.baesystems.environmentinfrastructure.application.Logger;

@MappedSuperclass
public abstract class TimeSlice {
	
	protected String name;

	@Transient
	protected TimeData timeData;
	
	protected TimeSlice() {
		
	}

	public String getName() {
		return name;
	}
	
	public TimeData getTimeData() {
		return timeData;
	}

	protected TimeSlice(TimeData timeData, String name) {
		if(timeData == null) {
			Logger.log("Time data is null");
		}
		this.timeData = timeData;
		this.name = name; // may be null
	}

	@Override
	public String toString() {
		if(name != null) {
			return name;
		} else {
			return "";
		}
	}
}
