package com.loggar.datetimes;

import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTest {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	Locale locale = Locale.ENGLISH;

	String str_dateFormat_1 = "dd/MM/yyyy";
	String str_dateFormat_2 = "dd/MM/yyyy HH:mm:ss";
	String str_dateFormat_3 = "yyyyMMdd HH:mm:ss";
	String str_dateFormat_4 = "yyyyMMddHHmm";
	String str_dateFormat_5 = "dd/MM/yyyy h:mm a";

	@SuppressWarnings("deprecation")
	// @Test
	public void date() {
		/*
		 * java.time.LocalDateTime in jdk 8
		 */
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(str_dateFormat_1);
		LocalDateTime date_today_jdk8 = LocalDateTime.now();
		String str_today_jdk8 = date_today_jdk8.format(dtf);
		logger.debug(str_today_jdk8);

		/*
		 * java.util.Date in jdk 7
		 */
		SimpleDateFormat formatter_01 = new SimpleDateFormat(str_dateFormat_1);
		Date date_today_jdk7_1 = new Date();
		String str_today_jdk7_1 = formatter_01.format(date_today_jdk7_1);
		logger.debug(str_today_jdk7_1);

		logger.debug(String.valueOf(date_today_jdk8.getYear()));
		logger.debug(String.valueOf(date_today_jdk7_1.getYear()));

		/*
		 * java.util.Calendar
		 */
		Calendar cal_today = Calendar.getInstance();
		Date date_today_jdk7_2 = new Date(cal_today.getTimeInMillis());
		String str_today_jdk7_2 = formatter_01.format(date_today_jdk7_2);

		logger.debug(cal_today.toString());
		logger.debug(date_today_jdk7_2.toString());
		logger.debug(str_today_jdk7_2);
		logger.debug(String.valueOf(cal_today.get(Calendar.YEAR)));

		/*
		 * formatter java.util.Date
		 */
		SimpleDateFormat formatter_02 = new SimpleDateFormat(str_dateFormat_2);
		String str_today_jdk7_3 = formatter_02.format(date_today_jdk7_2);

		SimpleDateFormat formatter_03 = new SimpleDateFormat(str_dateFormat_3);
		String str_today_jdk7_4 = formatter_03.format(date_today_jdk7_2);

		SimpleDateFormat formatter_04 = new SimpleDateFormat(str_dateFormat_4);
		String str_today_jdk7_5 = formatter_04.format(date_today_jdk7_2);

		logger.debug(str_today_jdk7_3);
		logger.debug(str_today_jdk7_4);
		logger.debug(str_today_jdk7_5);

		/*
		 * Locale
		 */
		SimpleDateFormat formatter_05 = new SimpleDateFormat(str_dateFormat_5, locale);
		String str_today_jdk7_6 = formatter_05.format(date_today_jdk7_2);
		logger.debug(str_today_jdk7_6);

	}

	@Test
	public void calendar() {
		logger.debug(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
	}
}
