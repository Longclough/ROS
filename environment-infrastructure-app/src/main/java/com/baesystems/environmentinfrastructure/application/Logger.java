package com.baesystems.environmentinfrastructure.application;

public class Logger {

	public static void log(Object message) {
		if(message == null) {
			System.out.println("Logging null");
		}
		System.out.println(message);
	}

}
