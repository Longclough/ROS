package com.baesystems.environmentinfrastructure.types;

public class HoldingCategoryCode {
	// A coded list of values that indicates the type of precision approach for which that holding position is designed.
	public static final HoldingCategoryCode NON_PRECISION = new HoldingCategoryCode("NON_PRECISION"); // Non precision approaches.
	public static final HoldingCategoryCode CAT_I = new HoldingCategoryCode("CAT_I"); // Precision approaches cat I.
	public static final HoldingCategoryCode CAT_II_III = new HoldingCategoryCode("CAT_II_III"); // Precision approaches cat II/III.
	
	private String value;
	
	public HoldingCategoryCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof HoldingCategoryCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
