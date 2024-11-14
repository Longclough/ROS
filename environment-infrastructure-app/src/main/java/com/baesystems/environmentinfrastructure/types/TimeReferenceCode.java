package com.baesystems.environmentinfrastructure.types;

public class TimeReferenceCode {
	// A coded indication of a time reference system - UTC or local.
	public static final TimeReferenceCode UTC = new TimeReferenceCode("UTC"); // Co-ordinated Universal Time
	public static final TimeReferenceCode UTCminus12 = new TimeReferenceCode("UTC-12"); // UTC minus 12 hours.
	public static final TimeReferenceCode UTCminus11 = new TimeReferenceCode("UTC-11"); // UTC minus 11 hours.
	public static final TimeReferenceCode UTCminus10 = new TimeReferenceCode("UTC-10"); // UTC minus 10 hours.
	public static final TimeReferenceCode UTCminus9 = new TimeReferenceCode("UTC-9"); // UTC minus 9 hours.
	public static final TimeReferenceCode UTCminus8 = new TimeReferenceCode("UTC-8"); // UTC minus 8 hours.
	public static final TimeReferenceCode UTCminus7 = new TimeReferenceCode("UTC-7"); // UTC minus 7 hours.
	public static final TimeReferenceCode UTCminus6 = new TimeReferenceCode("UTC-6"); // UTC minus 6 hours.
	public static final TimeReferenceCode UTCminus5 = new TimeReferenceCode("UTC-5"); // UTC minus 5 hours.
	public static final TimeReferenceCode UTCminus4 = new TimeReferenceCode("UTC-4"); // UTC minus 4 hours.
	public static final TimeReferenceCode UTCminus3 = new TimeReferenceCode("UTC-3"); // UTC minus 3 hours.
	public static final TimeReferenceCode UTCminus2 = new TimeReferenceCode("UTC-2"); // UTC minus 2 hours.
	public static final TimeReferenceCode UTCminus1 = new TimeReferenceCode("UTC-1"); // UTC minus 1 hour.
	public static final TimeReferenceCode UTCplus1 = new TimeReferenceCode("UTC+1"); // UTC plus 1 hour.
	public static final TimeReferenceCode UTCplus2 = new TimeReferenceCode("UTC+2"); // UTC plus 2 hours.
	public static final TimeReferenceCode UTCplus3 = new TimeReferenceCode("UTC+3"); // UTC plus 3 hours
	public static final TimeReferenceCode UTCplus4 = new TimeReferenceCode("UTC+4"); // UTC plus 4 hours
	public static final TimeReferenceCode UTCplus5 = new TimeReferenceCode("UTC+5"); // UTC plus 5 hours
	public static final TimeReferenceCode UTCplus6 = new TimeReferenceCode("UTC+6"); // UTC plus 6 hours.
	public static final TimeReferenceCode UTCplus7 = new TimeReferenceCode("UTC+7"); // UTC plus 7 hours.
	public static final TimeReferenceCode UTCplus8 = new TimeReferenceCode("UTC+8"); // UTC plus 8 hours.
	public static final TimeReferenceCode UTCplus9 = new TimeReferenceCode("UTC+9"); // UTC plus 9 hours.
	public static final TimeReferenceCode UTCplus10 = new TimeReferenceCode("UTC+10"); // UTC plus 10 hours.
	public static final TimeReferenceCode UTCplus11 = new TimeReferenceCode("UTC+11"); // UTC plus 11 hours.
	public static final TimeReferenceCode UTCplus12 = new TimeReferenceCode("UTC+12"); // UTC plus 12 hours.
	public static final TimeReferenceCode UTCplus13 = new TimeReferenceCode("UTC+13"); // UTC plus 13 hours.
	public static final TimeReferenceCode UTCplus14 = new TimeReferenceCode("UTC+14"); // UTC plus 14 hours.
	
	private String value;
	
	public TimeReferenceCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TimeReferenceCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
