package com.baesystems.environmentinfrastructure.loader.aixm.parse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBElement;

import com.baesystems.environmentinfrastructure.basictypes.time.Timesheet;

import com.baesystems.environmentinfrastructure.basictypes.time.Duration;
import com.baesystems.environmentinfrastructure.basictypes.time.TimeReference;
import net.opengis.gml._3.TimeInstantType;
import net.opengis.gml._3.TimePeriodType;
import net.opengis.gml._3.TimePositionType;
import net.opengis.gml._3.TimePrimitivePropertyType;
import aero.aixm.schema._5.CodeDayType;
import aero.aixm.schema._5.CodeTimeReferenceType;
import aero.aixm.schema._5.DateMonthDayType;
import aero.aixm.schema._5.DateTimeType;
import aero.aixm.schema._5.DateType;
import aero.aixm.schema._5.DateYearType;
import aero.aixm.schema._5.TimeType;
import aero.aixm.schema._5.TimesheetPropertyType;
import aero.aixm.schema._5.TimesheetType;
import aero.aixm.schema._5.ValDurationType;

public class ParseTime {
	
	public static Date getDate(DateType date) {
		if(date != null && date.getValue() != null) {
			date.getValue().toGregorianCalendar().getTime();
		}
		return null;
	}
	
	public static Date getDate(JAXBElement<DateType> date) {
		if(date != null && date.getValue() != null) {
			return getDate(date.getValue());
		}
		return null;
	}
	
	private static String getDateMonthDay(JAXBElement<DateMonthDayType> date) {
		if(date != null && date.getValue() != null) {
			return date.getValue().getValue();
		}
		return null;
	}
	
	public static Date getDateTime(JAXBElement<DateTimeType> value) {
		if(value != null && value.getValue() != null) {
			return value.getValue().getValue().toGregorianCalendar().getTime();
		}
		return null;
	}

	private static Date getDateTime(TimePositionType timePosition) {
		if(timePosition.getValue().size() > 0) {
			return DatatypeConverter.parseDateTime(timePosition.getValue().get(0)).getTime();
		} else {
			return null;
		}
	}
	
	private static String getDay(JAXBElement<CodeDayType> day) {
		if(day != null && day.getValue() != null) {
			return day.getValue().getValue();
		}
		return null;
	}
	
	public static Date getEndTime(TimePrimitivePropertyType time) {
		return getTime(time, false);
	}
	
	public static Date getStartTime(TimePrimitivePropertyType time) {
		return getTime(time, true);
	}

	public static String getTime(JAXBElement<TimeType> time) {
		if(time != null && time.getValue() != null) {
			return time.getValue().getValue();
		}
		return null;
	}

	public static Date getTime(TimePrimitivePropertyType time, boolean atStartOfPeriod) {
		if(time.getAbstractTimePrimitive() != null) {
			if(time.getAbstractTimePrimitive().getValue() instanceof TimePeriodType) {
				TimePeriodType timePeriod = (TimePeriodType) time.getAbstractTimePrimitive().getValue();
				if(atStartOfPeriod) {
					return getDateTime(timePeriod.getBeginPosition());
				} else {
					return getDateTime(timePeriod.getEndPosition());
				}
			} else if (time.getAbstractTimePrimitive().getValue() instanceof TimeInstantType) {
				TimeInstantType timeInstant = (TimeInstantType) time.getAbstractTimePrimitive().getValue();
				return getDateTime(timeInstant.getTimePosition());
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public static List<Timesheet> getTimeInterval(List<TimesheetPropertyType> timeInterval) {
		List<Timesheet> timeIntervals = new ArrayList<Timesheet>();
		for(TimesheetPropertyType timesheetProperty : timeInterval) {
			timeIntervals.add(getTimesheet(timesheetProperty));
		}
		return timeIntervals;
	}

	private static String getTimeReference(JAXBElement<CodeTimeReferenceType> timeReference) {
		if(timeReference != null && timeReference.getValue() != null) {
			return timeReference.getValue().getValue();
		}
		return null;
	}

	public static Timesheet getTimesheet(TimesheetPropertyType timesheetProperty) {
		TimesheetType timesheet = timesheetProperty.getTimesheet();
		String day = getDay(timesheet.getDay());
		Boolean excluded = ParseBoolean.yesNoToBoolean(timesheet.getExcluded());
		String startDate = getDateMonthDay(timesheet.getStartDate());
		String startTime = getTime(timesheet.getStartTime());
		String endDate = getDateMonthDay(timesheet.getEndDate());
		String endTime = getTime(timesheet.getEndTime());
		String timeReference = getTimeReference(timesheet.getTimeReference());
		return new Timesheet(day, excluded, startDate, startTime, endDate, endTime, timeReference);
	}

	public static Duration valDurationTypeToDuration(JAXBElement<ValDurationType> value) {
		if(value != null && value.getValue() != null) {
			if(value.getValue().getUom().equals("MIN")) {
				return new Duration(value.getValue().getValue().doubleValue(), TimeUnit.MINUTES, TimeReference.RELATIVE);
			} else if(value.getValue().getUom().equals("SEC")) {
				return new Duration(value.getValue().getValue().doubleValue(), TimeUnit.SECONDS, TimeReference.RELATIVE);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public static Integer getYear(DateYearType value) {
		return Integer.parseInt(((DateYearType) value).getValue());
	}
}
