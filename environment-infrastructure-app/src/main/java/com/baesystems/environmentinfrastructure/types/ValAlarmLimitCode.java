package com.baesystems.environmentinfrastructure.types;

public class ValAlarmLimitCode {
	// A distance value expressed in meter that is used for the Horizontal or Vertical Alarm Limit of a FAS Data Block.
	
	private String value;
	
	public ValAlarmLimitCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValAlarmLimitCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
