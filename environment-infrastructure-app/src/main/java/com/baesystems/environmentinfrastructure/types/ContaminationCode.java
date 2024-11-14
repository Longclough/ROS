package com.baesystems.environmentinfrastructure.types;

public class ContaminationCode {
	// An enumeration of substance types, which can contaminate airport/heliport movement areas.
	public static final ContaminationCode NONE = new ContaminationCode("NONE"); // Clear and dry.
	public static final ContaminationCode DAMP = new ContaminationCode("DAMP"); // A wee bit wet.
	public static final ContaminationCode WATER = new ContaminationCode("WATER"); // Wet or water patches.
	public static final ContaminationCode FROST = new ContaminationCode("FROST"); // Rime or Frost covered (depth less than 1 mm)
	public static final ContaminationCode DRY_SNOW = new ContaminationCode("DRY_SNOW"); // Snow which can be blown if loose or, ifcompacted by hand, will fall apart again upon release;specific gravity: up to but not including 0.35.
	public static final ContaminationCode WET_SNOW = new ContaminationCode("WET_SNOW"); // Snow which, if compacted by hand, will sticktogether and tend to or form a snowball; specificgravity: 0.35 up to but not including 0.5.
	public static final ContaminationCode SLUSH = new ContaminationCode("SLUSH"); // Water-saturated snow which with a heel-and-toe slapdownmotion against the ground will be displaced with asplatter; specific gravity: 0.5 up to 0.8.Note.- Combinations of ice, snow and/or standing watermay, especially when rain, rain and snow, or snow is falling,produce substances with specific gravities in excess of 0.8.These substances, due to their high water/ice content, willhave a transparent rather than a cloudy appearance and, atthe higher specific gravities, will be readily distinguishablefrom slush.
	public static final ContaminationCode ICE = new ContaminationCode("ICE"); // Ice.
	public static final ContaminationCode COMPACT_SNOW = new ContaminationCode("COMPACT_SNOW"); // Snow which has been compressedinto a solid mass that resists further compression andwill hold together or break up into lumps if picked up;specific gravity: 0.5 and over.
	public static final ContaminationCode RUT = new ContaminationCode("RUT"); // Frozen ruts or ridges.
	public static final ContaminationCode ASH = new ContaminationCode("ASH"); // Ash from volcanic activity.
	public static final ContaminationCode SAND = new ContaminationCode("SAND"); // Sand.
	public static final ContaminationCode OIL = new ContaminationCode("OIL"); // Oil and gas.
	public static final ContaminationCode RUBBER = new ContaminationCode("RUBBER"); // Rubber deposits.
	public static final ContaminationCode GRAS = new ContaminationCode("GRAS"); // Overgrown grass
	
	private String value;
	
	public ContaminationCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ContaminationCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
