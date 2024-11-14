package com.baesystems.environmentinfrastructure.loader.aixm.parse;

import javax.xml.bind.JAXBElement;

import aero.aixm.schema._5.CodeYesNoType;

public class ParseBoolean {
	
	public static Boolean yesNoToBoolean(CodeYesNoType yesNo) {
		if(yesNo != null && yesNo.getValue() != null) {
			if(yesNo.getValue().equals("YES")) {
				return true;
			} else {
				return false;
			}
		} 
		return null;
	}
	
	public static Boolean yesNoToBoolean(JAXBElement<CodeYesNoType> yesNo) {
		if(yesNo != null && yesNo.getValue() != null) {
			return yesNoToBoolean(yesNo.getValue());
		} 
		return null;
	}
}
