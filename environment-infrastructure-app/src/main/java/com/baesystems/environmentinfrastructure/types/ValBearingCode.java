package com.baesystems.environmentinfrastructure.types;

public class ValBearingCode {
	// The value of a bearing indication (at a given point) measured as the angle between the bearing and either True North or Magnetic North (this should appear explicitly or implicitly). The angle is measured clockwise from 0 degrees up to and including 360 degrees. The value can also be a VOR radial. For example, Westward is expressed as 270.
	
	private String value;
	
	public ValBearingCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValBearingCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
