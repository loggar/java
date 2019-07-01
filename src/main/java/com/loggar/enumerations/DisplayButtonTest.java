package com.loggar.enumerations;

import org.junit.jupiter.api.Test;

public class DisplayButtonTest {
	enum DisplayButton {
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
	
	@Test
	public void test1() {
		for(DisplayButton b : DisplayButton.values()) {
			System.out.println("Button: " + b.size());
		}
	}
}
