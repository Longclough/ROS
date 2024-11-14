package com.baesystems.environmentinfrastructure.basictypes.time;

import java.util.Date;

import com.baesystems.environmentinfrastructure.loader.aixm.parse.ParseTime;

import net.opengis.gml._3.TimePrimitivePropertyType;
import aero.aixm.schema._5.FeatureTimeSliceMetadataPropertyType;

public class TimeData {

	private Long correctionNumber;
	private Date featureLifetimeStart; 
	private Date featureLifetimeEnd; 
	private String interpretation;
	private Long sequenceNumber; 
	private Date validTimeStart;
	private Date validTimeEnd;
	
	public Long getCorrectionNumber() {
		return correctionNumber;
	}

	public Date getFeatureLifetimeStart() {
		return featureLifetimeStart;
	}

	public Date getFeatureLifetimeEnd() {
		return featureLifetimeEnd;
	}

	public String getInterpretation() {
		return interpretation;
	}

	public Long getSequenceNumber() {
		return sequenceNumber;
	}

	public Date getValidTimeStart() {
		return validTimeStart;
	}

	public Date getValidTimeEnd() {
		return validTimeEnd;
	}

	public TimeData(
			Long correctionNumber,
			TimePrimitivePropertyType featureLifetime, 
			String interpretation,
			FeatureTimeSliceMetadataPropertyType timeSliceMetadata,
			Long sequenceNumber, 
			TimePrimitivePropertyType validTime) {
		this.correctionNumber = correctionNumber;
		this.interpretation = interpretation;
		this.sequenceNumber = sequenceNumber;
		this.validTimeStart = ParseTime.getStartTime(validTime);
		this.validTimeEnd = ParseTime.getEndTime(validTime);
	}

	public TimeData() {
		this.correctionNumber = (long) 0;
		this.interpretation = "BASELINE";
		this.sequenceNumber = (long) 0;
		this.validTimeStart = new Date();
		this.validTimeEnd = null;
	}

	public TimeData(
			Long correctionNumber, 
			Date featureLifetimeStart,
			Date featureLifetimeEnd, 
			String interpretation,
			Long sequenceNumber, 
			Date validTimeStart, 
			Date validTimeEnd) {
		this.correctionNumber = correctionNumber;
		this.interpretation = interpretation;
		this.sequenceNumber = sequenceNumber;
		this.validTimeStart = validTimeStart;
		this.validTimeEnd = validTimeEnd;
	}

	public boolean isValidModification(Date date) {
		if(interpretation.equals("BASELINE")) {
			return true;
		} else if(interpretation.equals("PERMDELTA")) {
			return true;
		} else if(interpretation.equals("TEMPDELTA")) {
			return date.after(validTimeStart) && date.before(validTimeEnd);
		} else {
			System.out.println("Didn't understand timeslice interpretation: " + interpretation);
			return false;
		}
	}

}
