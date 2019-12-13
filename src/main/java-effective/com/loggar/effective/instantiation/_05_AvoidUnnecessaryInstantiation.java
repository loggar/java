package com.loggar.effective.instantiation;

import java.util.Calendar;

/**
 * Avoid unneccessary class instantiation.
 * 
 * ex) String a = new String("sdfs");  <- inefficient.
 *
 */
public class _05_AvoidUnnecessaryInstantiation {
	private static Calendar cal;
	
	static {
		cal = Calendar.getInstance();
	}
	
	/**
	 * This does not create Canendar instance everytime the method invoked.
	 * This works fast.
	 * This is memory efficient.
	 * @return
	 */
	public String doSomethingWithCal() {
		return cal.toString();
	}
}
