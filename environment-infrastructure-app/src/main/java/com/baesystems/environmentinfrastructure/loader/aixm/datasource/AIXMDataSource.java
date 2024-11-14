package com.baesystems.environmentinfrastructure.loader.aixm.datasource;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBElement;

import aero.aixm.schema._5.AbstractAIXMFeatureType;
import aero.aixm.schema._5_1.message.AIXMBasicMessageType;
import aero.aixm.schema._5_1.message.BasicMessageMemberAIXMPropertyType;

import com.baesystems.environmentinfrastructure.application.Logger;
import com.baesystems.environmentinfrastructure.loader.aixm.parse.ParseGeneral;
import com.baesystems.environmentinfrastructure.loader.aixm.parse.XLink;

public class AIXMDataSource {
	
	protected URL url;
	
	HashSet<String> parsedFeatureTypes = new HashSet<>();
	Set<String> unusedData = new HashSet<>();
	Set<String> unsupportedData = new HashSet<>();
	Map<String, AbstractAIXMFeatureType> features = new HashMap<>();
	Map<String, HashMap<String, AbstractAIXMFeatureType>> featuresByType = new HashMap<>();	
	
	public AIXMDataSource(URL url) {
		this.url = url;
	}
	
	public void load() {			
		AIXMBasicMessageType message = JAXB.unmarshal(url, AIXMBasicMessageType.class);		
		loadFeatures(message.getHasMember());
	}
	
	protected void loadFeatures(List<BasicMessageMemberAIXMPropertyType> messageMembers) {
		Logger.log("Loading file: " + url);
		for(BasicMessageMemberAIXMPropertyType member : messageMembers) {
			JAXBElement<? extends AbstractAIXMFeatureType> extendedFeatureType = member.getAbstractAIXMFeature();
			if(extendedFeatureType != null) {
				AbstractAIXMFeatureType feature = extendedFeatureType.getValue();
				String featureType = feature.getClass().toString();
				features.put(ParseGeneral.getUuid(feature), feature);
				Map<String, AbstractAIXMFeatureType> featuresForType = featuresByType.computeIfAbsent(featureType, k -> new HashMap<>());
				featuresForType.put(ParseGeneral.getUuid(feature), feature);
			}
		}
	}

	public void printFeatureTypes() {
		Logger.log("File contents...");
		for(String featureType : featuresByType.keySet()) {
			Logger.log(featureType);
		}
	}
	
	public void printUnparsedFeatureTypes() {
		boolean firstTime = true;
		for(String featureType : featuresByType.keySet()) {
			if(!parsedFeatureTypes.contains(featureType)) {
				if(firstTime) {
					Logger.log("Some file contents unparsed...");
					firstTime= false;
				}
				Logger.log(featureType);
			}
		}
		
		List<String> unusedDataList = new ArrayList<>();
		unusedDataList.addAll(unusedData);
		Collections.sort(unusedDataList);
		
		for(String unusedDataItem : unusedDataList) {
			Logger.log(unusedDataItem);
		}
	}

	public Collection<AbstractAIXMFeatureType> getFeatures(Class<?> featureType) {
		return getFeaturesHash(featureType).values();
	}
	
	public Collection<AbstractAIXMFeatureType> getFeatures() {
		return features.values();
	}

	private Map<String, AbstractAIXMFeatureType> getFeaturesHash(Class<?> featureType) {
		Map<String, AbstractAIXMFeatureType> featuresForType = featuresByType.get(featureType.toString());
		if(featuresForType != null) {
			return featuresForType;
		} else {
			return Collections.emptyMap();
		}
	}

	public AbstractAIXMFeatureType getFeature(String href, Class<?> featureType) {
		registerParser(featureType);
		Map<String, AbstractAIXMFeatureType> featuresForType = getFeaturesHash(featureType);
		AbstractAIXMFeatureType feature = featuresForType.get(XLink.tidyRef(href));
		if(feature == null) {
			Logger.log("Referenced feature " + href + " doesn't exist for type " + featureType);
		}
		return feature;
	}

	public AbstractAIXMFeatureType getFeature(String href) {
		AbstractAIXMFeatureType feature = features.get(XLink.tidyRef(href));
		if(feature == null) {
			Logger.log("Referenced feature doesn't exist " + href);
		} else {
			registerParser(feature.getClass());
		}
		return feature;
	}

	public void registerParser(Class<?> featureType) {
		parsedFeatureTypes.add(featureType.toString());
	}

	public void registerUnusedData(Class<?> featureType, String declaredType, String localPart, Object value) {
		if(!localPart.endsWith("extension")) {
			unusedData.add(featureType + " " + declaredType + " " + localPart + " " + value);
		}
	}

	public void registerUnsupportedData(Class<?> featureType, String declaredType, String localPart, Object value) {
		unsupportedData.add(featureType + " " + declaredType + " " + localPart + " " + value);
	}
	
	public String toString() {
		return url.toString();
	}
}
