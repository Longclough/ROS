package com.baesystems.environmentinfrastructure.types;

public class DayCode {
	// A code indicating a particular day.For example, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday, the day preceding a holiday, a legal holiday, the day following a holiday, the day preceding a working day, a working day, the day following a working day.
	public static final DayCode MON = new DayCode("MON"); // Monday.
	public static final DayCode TUE = new DayCode("TUE"); // Tuesday.
	public static final DayCode WED = new DayCode("WED"); // Wednesday.
	public static final DayCode THU = new DayCode("THU"); // Thursday.
	public static final DayCode FRI = new DayCode("FRI"); // Friday.
	public static final DayCode SAT = new DayCode("SAT"); // Saturday.
	public static final DayCode SUN = new DayCode("SUN"); // Sunday.
	public static final DayCode WORK_DAY = new DayCode("WORK_DAY"); // Working Day.  This value indicates any day which is neither a Legal Holiday nor a weekly non-working day.
	public static final DayCode BEF_WORK_DAY = new DayCode("BEF_WORK_DAY"); // The day preceding a working day.
	public static final DayCode AFT_WORK_DAY = new DayCode("AFT_WORK_DAY"); // The day after a working day.
	public static final DayCode HOL = new DayCode("HOL"); // Legal Holiday.  The value does not include the weekly non-working days (for example, Saturday and Sunday in most European States).
	public static final DayCode BEF_HOL = new DayCode("BEF_HOL"); // The day preceding a legal holiday.
	public static final DayCode AFT_HOL = new DayCode("AFT_HOL"); // The day after a legal holiday.
	public static final DayCode ANY = new DayCode("ANY"); // Any day.
	public static final DayCode BUSY_FRI = new DayCode("BUSY_FRI"); // Formally declared as 'Busy Friday' by the authority responsible for aeronautical information provision in the area concerned, in order to activate special traffic management arrangements.
	
	private String value;
	
	public DayCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DayCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
