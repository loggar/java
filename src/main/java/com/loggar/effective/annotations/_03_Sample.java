package com.loggar.effective.annotations;

import java.util.ArrayList;
import java.util.List;

//Program containing annotations with a parameter
public class _03_Sample {
	// Code containing an annotation with an array parameter
	@_03_ExceptionTest({ IndexOutOfBoundsException.class, NullPointerException.class })
	public static void doublyBad() {
		List<String> list = new ArrayList<String>();
		// The spec permits this method to throw either
		// IndexOutOfBoundsException or NullPointerException
		list.addAll(5, null);
	}
}
