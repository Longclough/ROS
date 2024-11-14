package com.baesystems.environmentinfrastructure.types;

public class AirspaceAggregationCode {
	// An 'operator' in coded form according to which two 'operands' will be 'associated' in order to produce a result.
	public static final AirspaceAggregationCode BASE = new AirspaceAggregationCode("BASE"); // 'Parent' airspace is the basis for subsequent operations.
	public static final AirspaceAggregationCode UNION = new AirspaceAggregationCode("UNION"); // 'Parent' airspace is second operand in a union operation.
	public static final AirspaceAggregationCode INTERS = new AirspaceAggregationCode("INTERS"); // 'Parent' airspace is second operand in intersection operation.
	public static final AirspaceAggregationCode SUBTR = new AirspaceAggregationCode("SUBTR"); // 'Parent' airspace is second operand in subtraction operation.
	
	private String value;
	
	public AirspaceAggregationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirspaceAggregationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
