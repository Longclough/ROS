package com.baesystems.environmentinfrastructure.types;

public class TextNoteCode {
	// A note.
	
	private String value;
	
	public TextNoteCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TextNoteCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
