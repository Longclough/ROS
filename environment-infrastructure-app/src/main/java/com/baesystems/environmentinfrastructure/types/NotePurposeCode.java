package com.baesystems.environmentinfrastructure.types;

public class NotePurposeCode {
	// A code list of values that indicate the goal with which a free text Note is provided.
	public static final NotePurposeCode DESCRIPTION = new NotePurposeCode("DESCRIPTION"); // A summary of the feature or property characteristics in a human readable form.
	public static final NotePurposeCode REMARK = new NotePurposeCode("REMARK"); // Additional information about the feature or property, to be considered by a human operator.
	public static final NotePurposeCode WARNING = new NotePurposeCode("WARNING"); // A notice that announces a hazard in relation with the feature or property characteristics.
	public static final NotePurposeCode DISCLAIMER = new NotePurposeCode("DISCLAIMER"); // A denial or disavowal of legal claim with regard to the feature or property information.
	
	private String value;
	
	public NotePurposeCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof NotePurposeCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
