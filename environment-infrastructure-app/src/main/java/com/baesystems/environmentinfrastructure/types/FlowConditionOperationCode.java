package com.baesystems.environmentinfrastructure.types;

public class FlowConditionOperationCode {
	// A coded value used to indicate a type of operation combining an elementary flow condition or a previously defined combination of flow conditions with another elementary flow condition or previously defined combination.
	public static final FlowConditionOperationCode AND = new FlowConditionOperationCode("AND"); // 1st condition fulfilled AND 2nd condition fulfilled.
	public static final FlowConditionOperationCode ANDNOT = new FlowConditionOperationCode("ANDNOT"); // 1st condition fulfilled AND 2nd condition NOT fulfilled.
	public static final FlowConditionOperationCode OR = new FlowConditionOperationCode("OR"); // 1st condition fulfilled OR 2nd condition fulfilled.
	public static final FlowConditionOperationCode SEQ = new FlowConditionOperationCode("SEQ"); // 1st condition is fulfilled BEFORE 2nd condition is fulfilled.
	public static final FlowConditionOperationCode NONE = new FlowConditionOperationCode("NONE"); // No operation (used for flows identified by a single condition).
	
	private String value;
	
	public FlowConditionOperationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FlowConditionOperationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
