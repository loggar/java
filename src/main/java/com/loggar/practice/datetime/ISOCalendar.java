package com.loggar.practice.datetime;

import java.time.Year;
import java.time.temporal.ChronoUnit;

public class ISOCalendar {
	public final static String DISNEY_BIRTH_YEAR = "1901";
	public final static String TEMPLE_BIRTH_YEAR = "1928";
	
	public static void main(String[] args) {
		Year birthYear1 = Year.parse(DISNEY_BIRTH_YEAR);
		Year birthYear2 = Year.parse(TEMPLE_BIRTH_YEAR);
		long diff = ChronoUnit.YEARS.between(birthYear1, birthYear2);
		System.out.println("There is an age difference of " + Math.abs(diff) + " years.");
	}
}
