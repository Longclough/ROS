package com.baesystems.environmentinfrastructure.types;

public class RuleProcedureCode {
	// An open coded list of values indicating the purpose of a rule or procedure.
	public static final RuleProcedureCode RULE = new RuleProcedureCode("RULE"); // A prescribed guide for conduct or action.
	public static final RuleProcedureCode LAW = new RuleProcedureCode("LAW"); // A binding rule, enforced by the national/international legislation.
	public static final RuleProcedureCode PROCEDURE = new RuleProcedureCode("PROCEDURE"); // A particular way of accomplishing something or of acting
	public static final RuleProcedureCode PRACTICE = new RuleProcedureCode("PRACTICE"); // The usual way of doing something, even if it is not formally prescribed
	public static final RuleProcedureCode ICAO_DIFF = new RuleProcedureCode("ICAO_DIFF"); // A difference between the national rules/procedures and the ICAO Standards, Recommended Practices and Procedures.
	
	private String value;
	
	public RuleProcedureCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RuleProcedureCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
