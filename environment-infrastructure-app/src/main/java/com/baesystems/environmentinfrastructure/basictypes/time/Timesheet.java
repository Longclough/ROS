package com.baesystems.environmentinfrastructure.basictypes.time;

public class Timesheet {

	private String day;
	private Boolean excluded;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	
	public String getDay() {
		return day;
	}

	public Boolean getExcluded() {
		return excluded;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public Timesheet(String day, Boolean excluded, String startDate, String startTime, String endDate, String endTime, String timeReference) {
		this.day = day;
		this.excluded = excluded;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
	}

	public String toString() {
		String s = "";
		s = s + "Day: " + day + ", ";
		s = s + "Excluded: " + excluded + ", ";
		s = s + "Start Date: " + startDate + " ";
		s = s + "Time: " + startTime + ", ";
		s = s + "End Date: " + endDate + " ";
		s = s + "Time: " + endTime;
		return s;
	}
}
