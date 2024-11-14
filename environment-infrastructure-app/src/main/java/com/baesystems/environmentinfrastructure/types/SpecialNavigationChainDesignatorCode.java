package com.baesystems.environmentinfrastructure.types;

public class SpecialNavigationChainDesignatorCode {
	// The coded identifier of a special navigation system chain.
	
	private String value;
	
	public SpecialNavigationChainDesignatorCode(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SpecialNavigationChainDesignatorCode) {
			return o.toString().equals(this.toString());
		} else {
			return false;
		}
	}
}
