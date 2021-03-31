package com.loggar.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time24HoursValidator {
	private Pattern pattern;
	private Matcher matcher;

	private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";

	public Time24HoursValidator() {
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
	}

	/**
	 * Validate time in 24 hours format with regular expression
	 * 
	 * @param time time address for validation
	 * @return true valid time fromat, false invalid time format
	 */
	public boolean validate(final String time) {
		matcher = pattern.matcher(time);
		return matcher.matches();
	}
	
	public static void main(String [] args) {
		Time24HoursValidator time24HoursValidator = new Time24HoursValidator();
		
		System.out.println(time24HoursValidator.validate("09:00:00"));
		System.out.println(time24HoursValidator.validate("17:00:00"));
	}
}
