package com.baesystems.environmentinfrastructure.types;

public class VerticalStructureMaterialCode {
	// A coded list of values indicating the type(s) of material that could compose the load-bearing structure and/or exterior facing of a vertical construction.
	public static final VerticalStructureMaterialCode ADOBE_BRICK = new VerticalStructureMaterialCode("ADOBE_BRICK"); // Brick made of adobe clay and straw, dried in the sun rather than by oven firing (as are standard bricks).  Larger than standard bricks, adobe bricks require a type of clay that contains between 25 and 45 percent aluminium salts.
	public static final VerticalStructureMaterialCode ALUMINIUM = new VerticalStructureMaterialCode("ALUMINIUM"); // A light silvery ductile and malleable metal, not readily tarnished by air, which is a chemical element, atomic number 13. (Symbol Al) 
	public static final VerticalStructureMaterialCode BRICK = new VerticalStructureMaterialCode("BRICK"); // Clay kneaded, moulded, and baked or sun-dried, used as a building material.
	public static final VerticalStructureMaterialCode CONCRETE = new VerticalStructureMaterialCode("CONCRETE"); // A heavy-duty building material made from a mixture of broken stone or gravel, sand, cement and water, that forms a stonelike mass on hardening.
	public static final VerticalStructureMaterialCode FIBREGLASS = new VerticalStructureMaterialCode("FIBREGLASS"); // Any material consisting of glass filaments woven into a textile or paper, or embedded in plastic, for use as a construction or insulation material.
	public static final VerticalStructureMaterialCode GLASS = new VerticalStructureMaterialCode("GLASS"); // A substance made by fusing soda and/or potash with other ingredients.  Usually transparent, lustrous, hard, and brittle.
	public static final VerticalStructureMaterialCode IRON = new VerticalStructureMaterialCode("IRON"); // A malleable, magnetic, readily oxidizable metal which is a chemical element of the transition series, atomic number 26. (Symbol Fe)  Occurs abundantly in certain ores and in meteorites, and is widely used, chiefly in alloys such as steel.
	public static final VerticalStructureMaterialCode MASONRY = new VerticalStructureMaterialCode("MASONRY"); // Building materials (for example: stone, brick, concrete, hollow-tile, concrete block, gypsum block, or other similar building units or materials and/or combination of the same) bonded together with mortar to form a structure (for example: a wall, a pier).
	public static final VerticalStructureMaterialCode METAL = new VerticalStructureMaterialCode("METAL"); // Any of the class of substances that are characteristically lustrous, ductile, fusible, malleable solids and are good conductors of heat and electricity.  For example, gold, silver, copper, iron, lead, tin, and certain alloys (as brass and bronze).
	public static final VerticalStructureMaterialCode MUD = new VerticalStructureMaterialCode("MUD"); // Constructed principally from mud applied to a structural scaffold of plant material (for example: wooden posts).  Effective only in extremely dry climates and usually must be resurfaced on a regular basis (for example: yearly) otherwise the structure steadily disintegrates under the effect of weather.
	public static final VerticalStructureMaterialCode PLANT = new VerticalStructureMaterialCode("PLANT"); // Plant material (for example: straw and/or tall coarse grass), possibly also containing the slices of soil to which the plant material is attached.  For example, used in thatching or sodding a roof.
	public static final VerticalStructureMaterialCode PRESTRESSED_CONCRETE = new VerticalStructureMaterialCode("PRESTRESSED_CONCRETE"); // Reinforced concrete in which internal stresses have been introduced to reduce potential tensile stress in the concrete resulting from loads.
	public static final VerticalStructureMaterialCode REINFORCED_CONCRETE = new VerticalStructureMaterialCode("REINFORCED_CONCRETE"); // Poured concrete containing steel bars or metal netting to increase its tensile strength.
	public static final VerticalStructureMaterialCode SOD = new VerticalStructureMaterialCode("SOD"); // A usually square or oblong piece or slice of earth together with the grass growing on it.
	public static final VerticalStructureMaterialCode STEEL = new VerticalStructureMaterialCode("STEEL"); // Any of numerous artificially produced alloys of iron containing up to 3 per cent of other elements (including less than about 2.2 per cent carbon) and having great strength and malleability.  Able to be tempered to many different degrees of hardness.  Used for making tools, weapons, and/or machinery.
	public static final VerticalStructureMaterialCode STONE = new VerticalStructureMaterialCode("STONE"); // Pieces of rock or mineral substance (other than metal) of definite form and size, usually artificially shaped, and used for some special purpose.  Used, for example, for building, for paving, or in the form of a block, slab, or pillar set up as  a memorial and/or a boundary-mark. 
	public static final VerticalStructureMaterialCode TREATED_TIMBER = new VerticalStructureMaterialCode("TREATED_TIMBER"); // A timber that has been impregnated with chemicals (for example: creosote oil) to reduce damage from wood rot and/or insects.  Often used for the portions of a structure that are likely to be in ongoing contact with soil and/or water.
	public static final VerticalStructureMaterialCode WOOD = new VerticalStructureMaterialCode("WOOD"); // The hard, compact, fibrous substance of which the roots, trunks, and branches of trees and shrubs consist.  Consists largely of secondary xylem, which forms the strengthening and water-transporting tissue of the plant.
	
	private String value;
	
	public VerticalStructureMaterialCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof VerticalStructureMaterialCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
