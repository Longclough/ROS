package com.baesystems.environmentinfrastructure.application;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class IdentifiedElement {
	
	@Id
	private String uid;

	public String getUid() {
		return uid;
	}

	public IdentifiedElement() {}
	
	public IdentifiedElement(String uid) {
		this.uid = uid;
	}
}
