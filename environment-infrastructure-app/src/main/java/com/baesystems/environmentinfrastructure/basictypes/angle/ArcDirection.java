package com.baesystems.environmentinfrastructure.basictypes.angle;

public enum ArcDirection {
	CLOCKWISE, ANTICLOCKWISE;

	public ArcDirection reverse() {
		if(this == CLOCKWISE) {
			return ANTICLOCKWISE;
		} else {
			return CLOCKWISE;
		}
	}
}
