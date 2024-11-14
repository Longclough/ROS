package com.baesystems.environmentinfrastructure.loader.aixm.parse;

import javax.xml.bind.JAXBElement;

import aero.aixm.schema._5.CodeHeightReferenceType;
import aero.aixm.schema._5.CodeVerticalReferenceType;
import aero.aixm.schema._5.ValDistanceVerticalType;
import aero.aixm.schema._5.ValFLType;
import com.baesystems.environmentinfrastructure.basictypes.distance.AltitudeReference;
import com.baesystems.environmentinfrastructure.basictypes.distance.FlightLevel;
import com.baesystems.environmentinfrastructure.basictypes.distance.Height;

public class ParseHeight {
	
	/*public static AltitudeInterp getAltitudeInterp(JAXBElement<CodeAltitudeUseType> altitudeInterp) {
		if(altitudeInterp != null && altitudeInterp.getValue() != null) {
			String altitudeInterpString = altitudeInterp.getValue().getValue();
			for(AltitudeInterp altitudeInterpEnum : AltitudeInterp.values()) {
				if(altitudeInterpEnum.toString().equals(altitudeInterpString)) {
					return altitudeInterpEnum;
				}
			}
			Logger.log("Altitude interpretation not recognised: " + altitudeInterpString);
		}
		return null;
	}*/
	
	public static Height valDistanceVerticalTypeToAltitude(JAXBElement<ValDistanceVerticalType> value, AltitudeReference reference) {
		if(value != null && value.getValue() != null && reference != null) {
			return valDistanceVerticalTypeToAltitude(value.getValue(), reference);
		} else {
			return null;
		}
	}
	
	public static Height valDistanceVerticalTypeToAltitude(JAXBElement<ValDistanceVerticalType> value, JAXBElement<CodeVerticalReferenceType> reference) {
		if(value != null && value.getValue() != null && reference != null) {
			return valDistanceVerticalTypeToAltitude(value.getValue(), reference.getValue());
		} else {
			return null;
		}
	}

	public static Height valDistanceVerticalTypeToAltitude(ValDistanceVerticalType value, AltitudeReference reference) {
		return valDistanceVerticalTypeToAltitude(value, value.getUom(), reference);
	}
	
	private static Height valDistanceVerticalTypeToAltitude(ValDistanceVerticalType value, CodeVerticalReferenceType reference) {
		AltitudeReference ref = AltitudeReference.MSL;
		if(reference.getValue().equals("MSL")) {
			ref = AltitudeReference.MSL;
		} else if(reference.getValue().equals("QFE")) {
			ref = AltitudeReference.QFE;
		} else if(reference.getValue().equals("QNH")) {
			ref = AltitudeReference.QNH;
		} else if(reference.getValue().equals("SFC")) {
			return Height.sfc;
		} else if(reference.getValue().equals("STD")) {
			ref = AltitudeReference.STD;
		}

		return valDistanceVerticalTypeToAltitude(value, ref);
	}

	public static Height valDistanceVerticalTypeToAltitude(ValDistanceVerticalType value, String uom, AltitudeReference reference) {
		try { 
			double doubleValue = Double.parseDouble(value.getValue());
			if(uom != null) {
				if(value.getUom().equals("FT")) {
					return Height.fromFt(doubleValue, reference);
				} else if(value.getUom().equals("FL")) {
					return new FlightLevel((int)doubleValue);
				} else if(value.getUom().equals("M")) {
					return Height.fromM(doubleValue, reference);
				}
			} else {
				return Height.fromFt(doubleValue, reference);
			}
		} catch (NumberFormatException e) {
			if(value.getValue().equals("CEILING")) {
					return Height.max;
			} else if(value.getValue().equals("FLOOR")) {
				return Height.sfc;
			} else if(value.getValue().equals("GND")) {
				return Height.sfc;
			} 	
		}

		return Height.max;
	}
	
	public static Height valFLTypeToAltitude(ValFLType value) {
		if(value != null) {
			return new FlightLevel((int) value.getValue());
		} else {
			return null;
		}
	}

	public static Height valDistanceVerticalTypeToHeight(JAXBElement<ValDistanceVerticalType> value, JAXBElement<CodeHeightReferenceType> reference) {
		if(value != null && value.getValue() != null && reference != null) {
			return valDistanceVerticalTypeToAltitude(value.getValue(), reference.getValue());
		} else {
			return null;
		}
	}
	
	private static Height valDistanceVerticalTypeToAltitude(ValDistanceVerticalType value, CodeHeightReferenceType reference) {
		AltitudeReference ref = AltitudeReference.MSL;
		if(reference.getValue().equals("MSL")) {
			ref = AltitudeReference.MSL;
		} else if(reference.getValue().equals("QFE")) {
			ref = AltitudeReference.QFE;
		} else if(reference.getValue().equals("QNH")) {
			ref = AltitudeReference.QNH;
		} else if(reference.getValue().equals("SFC")) {
			return Height.sfc;
		} else if(reference.getValue().equals("STD")) {
			ref = AltitudeReference.STD;
		}

		return valDistanceVerticalTypeToAltitude(value, ref);
	}
}
