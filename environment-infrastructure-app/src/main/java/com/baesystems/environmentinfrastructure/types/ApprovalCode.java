package com.baesystems.environmentinfrastructure.types;

public class ApprovalCode {
	// Indicates an approval code
	public static final ApprovalCode APPROVED = new ApprovalCode("APPROVED"); // Approved
	public static final ApprovalCode DISAPPROVED = new ApprovalCode("DISAPPROVED"); // Disapproved
	public static final ApprovalCode NOT_AUTHORISED = new ApprovalCode("NOT_AUTHORISED"); // Not authorized
	public static final ApprovalCode RESTRICTED = new ApprovalCode("RESTRICTED"); // Restricted
	
	private String value;
	
	public ApprovalCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ApprovalCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
