package com.baesystems.environmentinfrastructure.types;

public class ValDistanceVerticalCode {
	// A vertical distance value.For example, Upper and lower limits of an airspace, an ATS route, FL100, 600M, 300 FT, etc.. This data type also allows some special non-numerical values:GND - meaning "the Surface of the Earth";UNL - meaning "unlimited";FLOOR - meaning "the bottom of the airspace"; necessary to express usages for Airspace that have a non-constant lower limit;CEILING - meaning "the top of the airspace"; necessary to express usages for Airspace that have a non-constant upper limit.
	
	private String value;
	
	public ValDistanceVerticalCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ValDistanceVerticalCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
