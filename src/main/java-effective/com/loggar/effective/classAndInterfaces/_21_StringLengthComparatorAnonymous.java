package com.loggar.effective.classAndInterfaces;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * Use function objects to represent strategies
 *
 */
public class _21_StringLengthComparatorAnonymous {
	@Test
	public void test() {
		String[] arr = { "abc", "acb" };

		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
	}
}
