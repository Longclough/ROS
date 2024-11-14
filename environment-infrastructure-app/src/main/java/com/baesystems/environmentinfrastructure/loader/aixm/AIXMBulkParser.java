package com.baesystems.environmentinfrastructure.loader.aixm;

import com.baesystems.environmentinfrastructure.loader.aixm.datasource.AIXMDataSource;

public class AIXMBulkParser extends AIXMParser {

	public AIXMBulkParser(Class<?> featureType, AIXMDataSource ds) {
		super(featureType, ds);
		startProcessing();
	}

}
