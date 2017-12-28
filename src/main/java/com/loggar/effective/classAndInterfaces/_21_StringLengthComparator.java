package com.loggar.effective.classAndInterfaces;

import java.util.Comparator;

/**
 * Use function objects to represent strategies
 *
 */
class _21_StringLengthComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}
