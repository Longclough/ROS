package com.baesystems.environmentinfrastructure.types;

public class FuelCode {
	// A code indicating the category of fuel available at an aerodrome/heliport.
	public static final FuelCode AVGAS = new FuelCode("AVGAS"); // AVGAS [Octane 100 aviation gasoline.] 
	public static final FuelCode AVGAS_LL = new FuelCode("AVGAS_LL"); // AVGAS-LL [Octane 100 Low Lead aviation gasoline.]
	public static final FuelCode OCT73 = new FuelCode("OCT73"); // OCT73 [Octane 73 aviation gasoline.] 
	public static final FuelCode OCT80 = new FuelCode("OCT80"); // OCT80 [Octane 80 aviation gasoline.] 
	public static final FuelCode OCT82UL = new FuelCode("OCT82UL"); // OCT82UL [Octane 82 low-octane unleaded aviation gasoline.]
	public static final FuelCode OCT80_87 = new FuelCode("OCT80_87"); // OCT80-87 [Octane 80-87 aviation gasoline.] 
	public static final FuelCode OCT91_98 = new FuelCode("OCT91_98"); // OCT91-98 [Octane 91-98 aviation gasoline.] 
	public static final FuelCode OCT100_130 = new FuelCode("OCT100_130"); // OCT100-130 [Octane 100-130 aviation gasoline.] 
	public static final FuelCode OCT108_135 = new FuelCode("OCT108_135"); // OCT108-135 [Octane 108-135 aviation gasoline.] 
	public static final FuelCode OCT115_145 = new FuelCode("OCT115_145"); // OCT115-145 [Octane 115-145 aviation gasoline.] 
	public static final FuelCode MOGAS = new FuelCode("MOGAS"); // MOGAS [MOGAS aviation gasoline.] 
	public static final FuelCode JET = new FuelCode("JET"); // Jet aviation fuel.
	public static final FuelCode A = new FuelCode("A"); // Jet A Aviation fuel.
	public static final FuelCode A1 = new FuelCode("A1"); // Jet A1 aviation fuel.
	public static final FuelCode A1_PLUS = new FuelCode("A1_PLUS"); // Jet A1-plus FSII aviation fuel.
	public static final FuelCode B = new FuelCode("B"); // Jet B aviation fuel.
	public static final FuelCode JP1 = new FuelCode("JP1"); // Jet JP-1 aviation fuel.
	public static final FuelCode JP2 = new FuelCode("JP2"); // Jet JP-2 aviation fuel.
	public static final FuelCode JP3 = new FuelCode("JP3"); // Jet JP-3 aviation fuel.
	public static final FuelCode JP4 = new FuelCode("JP4"); // Jet JP-4 aviation fuel.
	public static final FuelCode JP5 = new FuelCode("JP5"); // Jet JP-5 aviation fuel.
	public static final FuelCode JP6 = new FuelCode("JP6"); // Jet JP-6 aviation fuel.
	public static final FuelCode JPTS = new FuelCode("JPTS"); // Jet JP fuel with higher thermal stability.
	public static final FuelCode JP7 = new FuelCode("JP7"); // Jet JP-7 aviation fuel.
	public static final FuelCode JP8 = new FuelCode("JP8"); // Jet JP-8 aviation fuel.
	public static final FuelCode JP8_HIGHER = new FuelCode("JP8_HIGHER"); // Jet JP-8 with higher thermal stability.
	public static final FuelCode JP9 = new FuelCode("JP9"); // Jet JP-9 aviation fuel - missiles.
	public static final FuelCode JP10 = new FuelCode("JP10"); // Jet JP-10 aviation fuel - missiles.
	public static final FuelCode F18 = new FuelCode("F18"); // F-18 [(NATO) aviation gasoline (low lead) - equivalent AVGAS 100LL.]
	public static final FuelCode F34 = new FuelCode("F34"); // F-34 [(NATO) jet aviation fuel with FSII - equivalent JP-8.] 
	public static final FuelCode F35 = new FuelCode("F35"); // F-35 [(NATO) jet aviation fuel - equivalent JET A-1.]
	public static final FuelCode F40 = new FuelCode("F40"); // F-40 [(NATO) jet aviation fuel with FSII - equivalent JP-4.] 
	public static final FuelCode F44 = new FuelCode("F44"); // F-44 [(NATO) jet aviation fuel with FSII - equivalent JP-5.] 
	public static final FuelCode TR0 = new FuelCode("TR0"); // TR0 [(France) jet TR0 aviation fuel.] 
	public static final FuelCode TR4 = new FuelCode("TR4"); // TR4 [(France) jet TR4 aviation fuel.] 
	public static final FuelCode TS1 = new FuelCode("TS1"); // TS-1 [(Russia) jet TS-1 aviation fuel.]
	public static final FuelCode RT = new FuelCode("RT"); // RT [(Russia) jet RT aviation fuel.] 
	public static final FuelCode ALL = new FuelCode("ALL"); // ALL [All regular fuel types.] 
	
	private String value;
	
	public FuelCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof FuelCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
