package com.baesystems.environmentinfrastructure.types;

public class CheckpointCategoryCode {
	// The position of the checkpoint; airborne or ground
	public static final CheckpointCategoryCode A = new CheckpointCategoryCode("A"); // Airborne
	public static final CheckpointCategoryCode G = new CheckpointCategoryCode("G"); // Ground
	
	private String value;
	
	public CheckpointCategoryCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof CheckpointCategoryCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
