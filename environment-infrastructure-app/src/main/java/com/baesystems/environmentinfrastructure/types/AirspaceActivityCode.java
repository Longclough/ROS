package com.baesystems.environmentinfrastructure.types;

public class AirspaceActivityCode {
	// A code indicating the primary activity taking place in the airspace or the reason for its establishment.
	public static final AirspaceActivityCode AD_TFC = new AirspaceActivityCode("AD_TFC"); // All traffic on the manoeuvring area of an aerodrome and all aircraft flying in the vicinity of an aerodrome.(Annex11).Description:A type of special air traffic.
	public static final AirspaceActivityCode HELI_TFC = new AirspaceActivityCode("HELI_TFC"); // Helicopter or gyrocopter operations.Description:A type of special air traffic.
	public static final AirspaceActivityCode TRAINING = new AirspaceActivityCode("TRAINING"); // Flights conducted for the purpose of training.Description:A type of special air traffic.
	public static final AirspaceActivityCode AEROBATICS = new AirspaceActivityCode("AEROBATICS"); // The usage of unusual or artful flying manoeuvres for recreation, competition, or entertainment.Description:A type of special air traffic.
	public static final AirspaceActivityCode AIRSHOW = new AirspaceActivityCode("AIRSHOW"); // A show at which aircraft are on view and featuring aerial displays.Description:A type of special air traffic.
	public static final AirspaceActivityCode SPORT = new AirspaceActivityCode("SPORT"); // The competition or practice by an individual or a group to achieve the best aerial performance.Description:A type of special air traffic. This could be an air race or aerobatic training or competition.
	public static final AirspaceActivityCode ULM = new AirspaceActivityCode("ULM"); // Ultra light flights.
	public static final AirspaceActivityCode GLIDING = new AirspaceActivityCode("GLIDING"); // Flying a non-power-driven heavier-than-air aircraft.Description:A type of special air traffic. (ICAO derived) A glider derives its lift in flight chiefly from aerodynamic reactions on surfaces which remain fixed under given conditions of flight.
	public static final AirspaceActivityCode PARAGLIDER = new AirspaceActivityCode("PARAGLIDER"); // Recreational and competitive flying sport using a free-flying, foot launched aircraft.Description:A type of special air traffic. When paragliding, the pilot sits in a harness suspended below a fabric wing, whose shape is formed by the pressure of air entering vents in the front of the wing. It is known in some countries as parapenting.
	public static final AirspaceActivityCode HANGGLIDING = new AirspaceActivityCode("HANGGLIDING"); // Recreational and competitive flying sport using a small glider from which the operator is suspended in a frame and which is controlled by movements of the body.Description:A type of special air traffic.
	public static final AirspaceActivityCode PARACHUTE = new AirspaceActivityCode("PARACHUTE"); // Exiting a flying aircraft by an individual using a parachute.Description:A type of special air traffic. A parachute is a soft fabric device used to slow the motion through the atmosphere by generating drag.
	public static final AirspaceActivityCode AIR_DROP = new AirspaceActivityCode("AIR_DROP"); // The dropping of troops, supplies, bombs, etc., from an aircraft.Description:A type of special air traffic. 
	public static final AirspaceActivityCode BALLOON = new AirspaceActivityCode("BALLOON"); // Flight activity involving a bag called the envelope that is capable of containing heated air, with a gondola or basket suspended beneath.Description:A type of special air traffic.
	public static final AirspaceActivityCode RADIOSONDE = new AirspaceActivityCode("RADIOSONDE"); // The lifting of devices through the atmosphere, which are tied to a helium or hydrogen filled balloon.Description:A type of special air traffic. Radio probe and meteorological balloons are examples.
	public static final AirspaceActivityCode SPACE_FLIGHT = new AirspaceActivityCode("SPACE_FLIGHT"); // Vertical launch for space flight operations.Description:A type of special air traffic.
	public static final AirspaceActivityCode UAV = new AirspaceActivityCode("UAV"); // The operation of a powered, aerial vehicle that does not carry a human operator.Description:A type of special air traffic. (NATO derived) An Unmanned Aerial Vehicle uses aerodynamic forces to provide vehicle lift, can fly autonomously or be piloted remotely, can be expendable or recoverable, and can carry a lethal or non-lethal payload.
	public static final AirspaceActivityCode AERIAL_WORK = new AirspaceActivityCode("AERIAL_WORK"); // Operations in which an aircraft is used for specialized services.Description:A type of special air traffic. Services such as agriculture, construction, photography, surveying, observation and patrol, search and rescue, aerial advertisement, etc. are examples.
	public static final AirspaceActivityCode CROP_DUSTING = new AirspaceActivityCode("CROP_DUSTING"); // Spraying crops with fertilizers, pesticides, and fungicides from an agricultural aircraft.Description:A type of special air traffic.
	public static final AirspaceActivityCode FIRE_FIGHTING = new AirspaceActivityCode("FIRE_FIGHTING"); // Intense fire fighting activity involving chemical agents being laid down from fire fighting aircraft.Description:A type of special air traffic.
	public static final AirspaceActivityCode MILOPS = new AirspaceActivityCode("MILOPS"); // The execution of operations by the military.Description:A type of military activity (usually).
	public static final AirspaceActivityCode REFUEL = new AirspaceActivityCode("REFUEL"); // Transfer of fuel between aircraft in the air.Description:A type of military activity (usually).
	public static final AirspaceActivityCode JET_CLIMBING = new AirspaceActivityCode("JET_CLIMBING"); // Climb-out of jet aircraft via predefined and common tracks.Description:A type of military activity (usually).
	public static final AirspaceActivityCode EXERCISE = new AirspaceActivityCode("EXERCISE"); // Intercepting and destroying of hostile aircraft or conducting similar training activities.Description:A type of military activity (usually).
	public static final AirspaceActivityCode TOWING = new AirspaceActivityCode("TOWING"); // Drawing or pulling through the air a target for aerial shooting practice.Description:A type of military activity (usually).
	public static final AirspaceActivityCode NAVAL_EXER = new AirspaceActivityCode("NAVAL_EXER"); // Naval forces (for example: vessels or aircraft) conduct firing and/or munitions exercises.Description:Distinguished from areas where Naval forces conduct general operations and manoeuvres.
	public static final AirspaceActivityCode MISSILES = new AirspaceActivityCode("MISSILES"); // The launch, transit, and targeting of guided missiles.Description:A type of military activity (usually). (NATO) A guided missile is an unmanned self-propelled vehicle whose trajectory or course, while in flight, is controlled.
	public static final AirspaceActivityCode AIR_GUN = new AirspaceActivityCode("AIR_GUN"); // The delivery of air to air or air to ground weapons for the destruction of a target.Description:A type of military activity (usually).
	public static final AirspaceActivityCode ARTILLERY = new AirspaceActivityCode("ARTILLERY"); // The discharge of a projectile into the air for the destruction of a target.Description:A type of military activity (usually).
	public static final AirspaceActivityCode SHOOTING = new AirspaceActivityCode("SHOOTING"); // The discharge of a gun or bow to propel arrows, bullets, etc swiftly or violently direct and sharply in specified directions. Description:A type of military activity (usually). This could be a shooting range or hunting area.
	public static final AirspaceActivityCode BLASTING = new AirspaceActivityCode("BLASTING"); // Controlled use of explosives to excavate or remove rock.Description:A type of hazard.
	public static final AirspaceActivityCode WATER_BLASTING = new AirspaceActivityCode("WATER_BLASTING"); // The action or an act of forcing out or emitting something suddenly underwater.Description:A type of hazard. Usually involving violence and noise. 
	public static final AirspaceActivityCode ANTI_HAIL = new AirspaceActivityCode("ANTI_HAIL"); // The use of small rockets to protect crops by seeding clouds with small particles that prevent hailstorms from forming.Description:A type of hazard.
	public static final AirspaceActivityCode BIRD = new AirspaceActivityCode("BIRD"); // Bird hazard.
	public static final AirspaceActivityCode BIRD_MIGRATION = new AirspaceActivityCode("BIRD_MIGRATION"); // A high number of bird species as they fly instinctual routes based on breeding or diverse environmental urges.Description:A type of hazard. For Example: Large scale movements of migrating birds occur during various months in the European-Mediterranean and UK areas. There are also large concentrations of nesting, breeding, and wintering birds, often numbering in the millions.
	public static final AirspaceActivityCode FIREWORK = new AirspaceActivityCode("FIREWORK"); // Launching of pyrotechnic devices.Description:A type of hazard..
	public static final AirspaceActivityCode HI_RADIO = new AirspaceActivityCode("HI_RADIO"); // Electromagnetic fields produced by high intensity radio transmission.Description:A type of hazard.
	public static final AirspaceActivityCode HI_LIGHT = new AirspaceActivityCode("HI_LIGHT"); // Non-navigational lights with high visibility potential.Description:A type of hazard.
	public static final AirspaceActivityCode LASER = new AirspaceActivityCode("LASER"); // The emission of photons in a coherent beam by an optical source.Description:A type of hazard. Laser stands for Light Amplification by Stimulated Emission of Radiation. An example is a laser light show.
	public static final AirspaceActivityCode NATURE = new AirspaceActivityCode("NATURE"); // Wildlife, flora, fauna or features of geological or other special interest which is reserved and managed for conservation.Description:A type of protection. This is given a protective status. This could provide special opportunities for study or research. For example, a national park..
	public static final AirspaceActivityCode FAUNA = new AirspaceActivityCode("FAUNA"); // The animals or animal life of a given area, habitat, or epoch which is easily and dangerously aroused by excessive aerial noise such as from an aircraft.Description:A type of protection. Examples include mink or turkey farms and zoos.
	public static final AirspaceActivityCode NO_NOISE = new AirspaceActivityCode("NO_NOISE"); // Airspace in which special procedures or other precautionary measures are established for reducing noise.Description:A type of protection.
	public static final AirspaceActivityCode ACCIDENT = new AirspaceActivityCode("ACCIDENT"); // Airspace needing a protective status due to an investigation of a flight catastrophe.Description:A type of protection.
	public static final AirspaceActivityCode POPULATION = new AirspaceActivityCode("POPULATION"); // An area with a high concentration of inhabitants.Description:A type of protection.
	public static final AirspaceActivityCode VIP = new AirspaceActivityCode("VIP"); // The presence of an individual of renowned status and considered as a very important person.Description:A type of protection.
	public static final AirspaceActivityCode VIP_PRES = new AirspaceActivityCode("VIP_PRES"); // The presence of an individual with status of head of state.Description:A type of protection.
	public static final AirspaceActivityCode VIP_VICE = new AirspaceActivityCode("VIP_VICE"); // The presence of an individual with status of Vice-Head of State.Description:A type of protection.
	public static final AirspaceActivityCode OIL = new AirspaceActivityCode("OIL"); // An area in which oil occurs in quantities worthy of exploitation.Description:A type of industrial hazard.
	public static final AirspaceActivityCode GAS = new AirspaceActivityCode("GAS"); // Pumping natural gas from the ground or converting gasoline into vapour.Description:A type of industrial hazard.
	public static final AirspaceActivityCode REFINERY = new AirspaceActivityCode("REFINERY"); // A facility where petroleum and/or petroleum products are refined.Description:A type of industrial hazard.
	public static final AirspaceActivityCode CHEMICAL = new AirspaceActivityCode("CHEMICAL"); // A facility utilizing a chemical process for manufacturing.Description:A type of industrial hazard.
	public static final AirspaceActivityCode NUCLEAR = new AirspaceActivityCode("NUCLEAR"); // An installation which provides power, derived from fission or fusion of atomic nuclei.Description:A type of industrial hazard.
	public static final AirspaceActivityCode TECHNICAL = new AirspaceActivityCode("TECHNICAL"); // Generic technical activity affecting air traffic.Description:A type of industrial hazard..
	public static final AirspaceActivityCode ATS = new AirspaceActivityCode("ATS"); // Custom specific flight information service, alerting service, air traffic advisory service, air traffic control service, area control service, approach control service, or airport control service is provided.Description:A type of procedure/service. This could be a service in the air or on the ground.
	public static final AirspaceActivityCode PROCEDURE = new AirspaceActivityCode("PROCEDURE"); // Special procedures established for use by operational personnel in execution of their flight.Description:A type of procedure/service. An overhead approach is an example of a special procedure.
	
	private String value;
	
	public AirspaceActivityCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AirspaceActivityCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
