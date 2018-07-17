package com.loggar.effective.enums;

import java.util.EnumSet;
import java.util.Set;

/*
//Bit field enumeration constants - OBSOLETE!
public class Text {
	public static final int STYLE_BOLD = 1 << 0; // 1
	public static final int STYLE_ITALIC = 1 << 1; // 2
	public static final int STYLE_UNDERLINE = 1 << 2; // 4
	public static final int STYLE_STRIKETHROUGH = 1 << 3; // 8
	// Parameter is bitwise OR of zero or more STYLE_ constants

	public void applyStyles(int styles) { ... }
	
	// text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
}
*/

/**
 * Use EnumSet instead of bit fields
 */
public class _32_Text {
	public enum Style {
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
	}

	// Any Set could be passed in, but EnumSet is clearly best
	public void applyStyles(Set<Style> styles) {
		System.out.print("apply style :");
		for (Style s : styles) {
			System.out.print(" " + s);
		}
	}

	public static void main(String[] args) {
		_32_Text text = new _32_Text();
		text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
	}
}
