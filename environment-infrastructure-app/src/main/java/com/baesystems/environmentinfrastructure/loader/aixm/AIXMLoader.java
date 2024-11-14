package com.baesystems.environmentinfrastructure.loader.aixm;

import com.baesystems.environmentinfrastructure.application.Logger;
import com.baesystems.environmentinfrastructure.loader.aixm.datasource.AIXMDataSource;
import com.baesystems.environmentinfrastructure.loader.aixm.feature.AirspaceTypeParser;

public class AIXMLoader {
	public AIXMLoader(AIXMDataSource ds) {
		try {	
			ds.load();
		
			new AirspaceTypeParser(ds);
			
			ds.printUnparsedFeatureTypes();
			
			Logger.log("Completed loading file: " + ds);
			Logger.log("");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
