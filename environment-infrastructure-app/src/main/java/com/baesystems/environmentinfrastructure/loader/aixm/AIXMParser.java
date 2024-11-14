package com.baesystems.environmentinfrastructure.loader.aixm;

import java.util.Collection;

import com.baesystems.environmentinfrastructure.application.ProgressMonitor;
import com.baesystems.environmentinfrastructure.loader.aixm.datasource.AIXMDataSource;

import aero.aixm.schema._5.AbstractAIXMFeatureType;

public abstract class AIXMParser {
	
	protected AIXMDataSource ds;
	private Class<?> featureType;
	private Collection<AbstractAIXMFeatureType> features;
	private ProgressMonitor progressMonitor;
	protected int passes = 0;
	
	protected AIXMParser(Class<?> featureType, AIXMDataSource ds) {
		this.ds = ds;
		this.featureType = featureType;
		ds.registerParser(featureType);
		features = ds.getFeatures(featureType);
		progressMonitor = new ProgressMonitor(featureType.toString(), features.size());
	}
	
	protected void beforeStartProcessing() {
		
	}
	
	protected void startProcessing() {
		beforeStartProcessing();
		progressMonitor.startedProcessing();
		for(AbstractAIXMFeatureType feature : ds.getFeatures(featureType)) {
			progressMonitor.itemProcessed();
			processFeature(feature);	
		}
		progressMonitor.completedProcessing();
		passes++;
	}

	protected void processFeature(AbstractAIXMFeatureType feature) {
		
	}
}


