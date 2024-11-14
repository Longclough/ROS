package com.baesystems.environmentinfrastructure.airspace;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.baesystems.environmentinfrastructure.basictypes.time.IdentifiedTimeSlicedElement;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Airspace extends IdentifiedTimeSlicedElement {
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<AirspaceTimeSlice> timeSlices = new ArrayList<>();
	
	public void addTimeSlice(AirspaceTimeSlice timeSlice) {
		this.timeSlices.add(timeSlice);
	}
	
	public Airspace() {
		
	}
	
	public Airspace(String uid) {
		super(uid);
	}
	
	@Override
	public AirspaceTimeSlice getSnapshot() {
		AirspaceTimeSlice baseline = ((AirspaceTimeSlice) getBaseline(timeSlices));
		AirspaceTimeSlice snapshot = baseline.copy();
		
		for(int i=timeSlices.indexOf(baseline) + 1; i < timeSlices.size(); i++) {
			if(timeSlices.get(i).getTimeData().isValidModification(new Date())) {
				snapshot.mergeIn(timeSlices.get(i));
			}
		}
		
		return snapshot;
	}

	public List<AirspaceTimeSlice> getTimeSlices() {
		return timeSlices;
	}

	public JSONObject toJSON() {
		return getSnapshot().toJSON(true);
	}
}
