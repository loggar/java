package com.loggar.datetimes;

import java.util.Calendar;

public class CalendarStatics {
	public static void main(String[] args) {
		String y = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

		System.out.println(y);
	}
}
