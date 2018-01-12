package com.loggar.enumerations;

public enum DisplayButton {
	// size in inches
	ROUND (.50f), SQUARE (.40f);
	
	private final float size;
	
	DisplayButton(float size) {
		this.size = size;
	}
	
	public float size() {
		return size;
	}
}
