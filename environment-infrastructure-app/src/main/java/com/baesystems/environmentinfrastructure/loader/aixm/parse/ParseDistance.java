package com.baesystems.environmentinfrastructure.loader.aixm.parse;

import java.math.BigDecimal;

import javax.xml.bind.JAXBElement;

import net.opengis.gml._3.LengthType;
import aero.aixm.schema._5.ValDepthType;
import aero.aixm.schema._5.ValDistanceSignedType;
import aero.aixm.schema._5.ValDistanceType;
import com.baesystems.environmentinfrastructure.basictypes.distance.Distance;
import com.baesystems.environmentinfrastructure.basictypes.distance.DistanceUnit;

public class ParseDistance {
	
	private static Distance getDistance(BigDecimal value, String uom) {
		double doubleValue = value.doubleValue();
		
		if(uom.equals("FT")) {
			return new Distance(doubleValue, DistanceUnit.FEET);
		} else if(uom.equals("KM")) {
			return new Distance(doubleValue * 1000, DistanceUnit.METRES);
		} else if(uom.equals("M")) {
			return new Distance(doubleValue, DistanceUnit.METRES);
		} else if(uom.equals("NM")) {
			return new Distance(doubleValue, DistanceUnit.NAUTICALMILES);
		} else {
			return new Distance(0, DistanceUnit.METRES);
		}
	}

	public static Distance lengthTypeToDistance(LengthType length) {
		if(length.getUom().equals("NM") || length.getUom().equals("[nmi_i]")) {
			return new Distance(length.getValue(), DistanceUnit.NAUTICALMILES);
		} else if(length.getUom().equals("FT")){
			return new Distance(length.getValue(), DistanceUnit.FEET);
		} else {
			return new Distance(length.getValue(), DistanceUnit.METRES);
		}
	}
	
	public static Distance valDepthTypeToDistance(JAXBElement<ValDepthType> value) {
		if(value != null && value.getValue() != null) {
			return getDistance(value.getValue().getValue(), value.getValue().getUom());
		}
		return null;
	}
	
	public static Distance valDistanceSignedTypeToDistance(JAXBElement<ValDistanceSignedType> value) {
		if(value != null && value.getValue() != null) {
			return getDistance(value.getValue().getValue(), value.getValue().getUom());
		}
		return null;
	}
	
	public static Distance valDistanceTypeToDistance(JAXBElement<ValDistanceType> distance) {
		if(distance != null && distance.getValue() != null) {
			return valDistanceTypeToDistance(distance.getValue());
		} else {
			return null;
		}
	}
	
	public static Distance valDistanceTypeToDistance(ValDistanceType value) {
		return getDistance(value.getValue(), value.getUom());
	}
}
