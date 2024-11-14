package com.baesystems.environmentinfrastructure.loader.aixm;

import com.baesystems.environmentinfrastructure.application.Logger;

public class AIXMParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AIXMParseException(String string) {
		super(string);
	}

	public void printMessage() {
		Logger.log(super.getMessage());
	}

}
