package com.baesystems.environmentinfrastructure.types;

public class SurfacePreparationCode {
	// A code indicating the preparation technique for a surface area.
	public static final SurfacePreparationCode NATURAL = new SurfacePreparationCode("NATURAL"); // Natural surface; no treatment.
	public static final SurfacePreparationCode ROLLED = new SurfacePreparationCode("ROLLED"); // Rolled.
	public static final SurfacePreparationCode COMPACTED = new SurfacePreparationCode("COMPACTED"); // Compacted
	public static final SurfacePreparationCode GRADED = new SurfacePreparationCode("GRADED"); // Graded.
	public static final SurfacePreparationCode GROOVED = new SurfacePreparationCode("GROOVED"); // Cut or plastic grooved.
	public static final SurfacePreparationCode OILED = new SurfacePreparationCode("OILED"); // Oiled.
	public static final SurfacePreparationCode PAVED = new SurfacePreparationCode("PAVED"); // Paved.
	public static final SurfacePreparationCode PFC = new SurfacePreparationCode("PFC"); // Porous friction coat.
	public static final SurfacePreparationCode AFSC = new SurfacePreparationCode("AFSC"); // Aggregate friction seal coat.
	public static final SurfacePreparationCode RFSC = new SurfacePreparationCode("RFSC"); // Rubberised friction seal coat.
	public static final SurfacePreparationCode NON_GROOVED = new SurfacePreparationCode("NON_GROOVED"); // This covers such items as 'APSHALT NON GROOVED' .
	
	private String value;
	
	public SurfacePreparationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SurfacePreparationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
