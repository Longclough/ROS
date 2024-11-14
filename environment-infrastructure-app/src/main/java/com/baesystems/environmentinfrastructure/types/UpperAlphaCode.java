package com.baesystems.environmentinfrastructure.types;

public class UpperAlphaCode {
	// Letters of the Latin alphabet.
	public static final UpperAlphaCode A = new UpperAlphaCode("A"); // null
	public static final UpperAlphaCode B = new UpperAlphaCode("B"); // null
	public static final UpperAlphaCode C = new UpperAlphaCode("C"); // null
	public static final UpperAlphaCode D = new UpperAlphaCode("D"); // null
	public static final UpperAlphaCode E = new UpperAlphaCode("E"); // null
	public static final UpperAlphaCode F = new UpperAlphaCode("F"); // null
	public static final UpperAlphaCode G = new UpperAlphaCode("G"); // null
	public static final UpperAlphaCode H = new UpperAlphaCode("H"); // null
	public static final UpperAlphaCode I = new UpperAlphaCode("I"); // null
	public static final UpperAlphaCode J = new UpperAlphaCode("J"); // null
	public static final UpperAlphaCode K = new UpperAlphaCode("K"); // null
	public static final UpperAlphaCode L = new UpperAlphaCode("L"); // null
	public static final UpperAlphaCode M = new UpperAlphaCode("M"); // null
	public static final UpperAlphaCode N = new UpperAlphaCode("N"); // null
	public static final UpperAlphaCode O = new UpperAlphaCode("O"); // null
	public static final UpperAlphaCode P = new UpperAlphaCode("P"); // null
	public static final UpperAlphaCode Q = new UpperAlphaCode("Q"); // null
	public static final UpperAlphaCode R = new UpperAlphaCode("R"); // null
	public static final UpperAlphaCode S = new UpperAlphaCode("S"); // null
	public static final UpperAlphaCode T = new UpperAlphaCode("T"); // null
	public static final UpperAlphaCode U = new UpperAlphaCode("U"); // null
	public static final UpperAlphaCode V = new UpperAlphaCode("V"); // null
	public static final UpperAlphaCode W = new UpperAlphaCode("W"); // null
	public static final UpperAlphaCode X = new UpperAlphaCode("X"); // null
	public static final UpperAlphaCode Y = new UpperAlphaCode("Y"); // null
	public static final UpperAlphaCode Z = new UpperAlphaCode("Z"); // null
	
	private String value;
	
	public UpperAlphaCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UpperAlphaCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
