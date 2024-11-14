package com.baesystems.environmentinfrastructure.loader.aixm.parse;

import java.awt.Color;

import javax.xml.bind.JAXBElement;

import aero.aixm.schema._5.CodeColourType;

public class ParseColour {
	
	public static Color getColour(CodeColourType colour) {
		if(colour != null && colour.getValue() != null) {
			String colourCode = colour.getValue();
			if(colourCode.equals("YELLOW")) {
				return Color.YELLOW;
			} else if(colourCode.equals("MAGENTA")) {
				return Color.MAGENTA;
			} else if(colourCode.equals("GREEN")) {
					return Color.GREEN;
			} else if(colourCode.equals("RED")) {
				return Color.RED;
			} else if(colourCode.equals("ORANGE")) {
				return Color.ORANGE;
			} else if(colourCode.equals("BLUE")) {
				return Color.BLUE;
			} else if(colourCode.equals("WHITE")) {
				return Color.WHITE;
			} else if(colourCode.equals("PINK")) {
				return Color.PINK;
			} else if(colourCode.equals("OTHER:CYAN")) {
				return Color.CYAN;
			} else {
				return Color.BLACK;
			}
		}
		return null;
	}

	public static Color getColour(JAXBElement<CodeColourType> colour) {
		if(colour != null && colour.getValue() != null) {
			return getColour(colour.getValue());
		}
		return null;
	}
}
