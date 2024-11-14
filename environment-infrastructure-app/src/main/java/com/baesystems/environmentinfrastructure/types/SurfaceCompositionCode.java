package com.baesystems.environmentinfrastructure.types;

public class SurfaceCompositionCode {
	// A code indicating the composition of a surface.For example, asphalt, concrete etc..
	public static final SurfaceCompositionCode ASPH = new SurfaceCompositionCode("ASPH"); // Asphalt.
	public static final SurfaceCompositionCode ASPH_GRASS = new SurfaceCompositionCode("ASPH_GRASS"); // Asphalt and grass.
	public static final SurfaceCompositionCode CONC = new SurfaceCompositionCode("CONC"); // Concrete.
	public static final SurfaceCompositionCode CONC_ASPH = new SurfaceCompositionCode("CONC_ASPH"); // Concrete and asphalt.
	public static final SurfaceCompositionCode CONC_GRS = new SurfaceCompositionCode("CONC_GRS"); // Concrete and grass.
	public static final SurfaceCompositionCode GRASS = new SurfaceCompositionCode("GRASS"); // Grass including portions of turf or bare earth.
	public static final SurfaceCompositionCode SAND = new SurfaceCompositionCode("SAND"); // Sand.
	public static final SurfaceCompositionCode WATER = new SurfaceCompositionCode("WATER"); // Water.
	public static final SurfaceCompositionCode BITUM = new SurfaceCompositionCode("BITUM"); // Bituminous tar or asphalt and/or oil or bitumen bound, mix-in-place surfaces (often referred to as "earth cement"). [note: A bituminous tar or asphalt surface is prepared by digging up the surface, mixing the material with bitumen or oil binder, and surfacing the surface with the resulting mixture. Bitumen is the family name for tar which is derived from coal, or asphalt which is derived from oil. .]  
	public static final SurfaceCompositionCode BRICK = new SurfaceCompositionCode("BRICK"); // Brick.
	public static final SurfaceCompositionCode MACADAM = new SurfaceCompositionCode("MACADAM"); // A macadam or tarmac surface consisting of water-bound crushed rock.
	public static final SurfaceCompositionCode STONE = new SurfaceCompositionCode("STONE"); // Stone.
	public static final SurfaceCompositionCode CORAL = new SurfaceCompositionCode("CORAL"); // Coral.
	public static final SurfaceCompositionCode CLAY = new SurfaceCompositionCode("CLAY"); // Clay.
	public static final SurfaceCompositionCode LATERITE = new SurfaceCompositionCode("LATERITE"); // Laterite - a high iron clay formed in tropical areas.
	public static final SurfaceCompositionCode GRAVEL = new SurfaceCompositionCode("GRAVEL"); // Gravel.
	public static final SurfaceCompositionCode EARTH = new SurfaceCompositionCode("EARTH"); // Earth (in general).
	public static final SurfaceCompositionCode ICE = new SurfaceCompositionCode("ICE"); // Ice.
	public static final SurfaceCompositionCode SNOW = new SurfaceCompositionCode("SNOW"); // Snow.
	public static final SurfaceCompositionCode MEMBRANE = new SurfaceCompositionCode("MEMBRANE"); // A protective laminate usually made of rubber.
	public static final SurfaceCompositionCode METAL = new SurfaceCompositionCode("METAL"); // Metal - steel, aluminium.
	public static final SurfaceCompositionCode MATS = new SurfaceCompositionCode("MATS"); // Landing mat portable system usually made of aluminium.
	public static final SurfaceCompositionCode PIERCED_STEEL = new SurfaceCompositionCode("PIERCED_STEEL"); // Pierced steel planking.
	public static final SurfaceCompositionCode WOOD = new SurfaceCompositionCode("WOOD"); // Wood.
	public static final SurfaceCompositionCode NON_BITUM_MIX = new SurfaceCompositionCode("NON_BITUM_MIX"); // Non Bituminous mix.
	
	private String value;
	
	public SurfaceCompositionCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SurfaceCompositionCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
