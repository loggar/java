package com.loggar.practice.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTest {
	private static final Logger logger = LoggerFactory.getLogger(DateTest.class);

	Locale locale = Locale.ENGLISH;

	String str_dateFormat_1 = "dd/MM/yyyy";
	String str_dateFormat_2 = "dd/MM/yyyy HH:mm:ss";
	String str_dateFormat_3 = "yyyyMMdd HH:mm:ss";
	String str_dateFormat_4 = "yyyyMMddHHmm";
	String str_dateFormat_5 = "dd/MM/yyyy h:mm a";

	@SuppressWarnings("deprecation")
	@Test
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
	public void checkBetweenDate_jdk8() {
		String str_issueDate = "31/10/2016";
		String str_invoiceStartDate = "29/10/2016";
		String str_invoiceEndDate = "31/10/2016";

		boolean result = false;

		LocalDateTime dt = LocalDateTime.from(
				LocalDate.parse(str_issueDate, DateTimeFormatter.ofPattern("dd/MM/yyyy", java.util.Locale.ENGLISH))
						.atStartOfDay());
		LocalDateTime startDtStr = LocalDateTime.from(LocalDate
				.parse(str_invoiceStartDate, DateTimeFormatter.ofPattern("dd/MM/yyyy", java.util.Locale.ENGLISH))
				.atStartOfDay());
		LocalDateTime endDtStr = LocalDateTime.from(
				LocalDate.parse(str_invoiceEndDate, DateTimeFormatter.ofPattern("dd/MM/yyyy", java.util.Locale.ENGLISH))
						.atStartOfDay());

		if ((dt.isAfter(startDtStr) || dt.equals(startDtStr)) && (dt.isBefore(endDtStr) || dt.equals(endDtStr))) {
			result = true;
		}

		logger.debug(String.valueOf(result));
	}

	@Test
	public void checkBetweenDate_jdk7() {
		String str_issueDate = "31/10/2016";
		String str_invoiceStartDate = "29/10/2016";
		String str_invoiceEndDate = "31/10/2016";

		boolean result = false;

		Date issueDate = null;
		Date startDate = null;
		Date endDate = null;

		SimpleDateFormat formatter_01 = new SimpleDateFormat(str_dateFormat_1);

		try {
			issueDate = formatter_01.parse(str_issueDate);
			startDate = formatter_01.parse(str_invoiceStartDate);
			endDate = formatter_01.parse(str_invoiceEndDate);

			if ((issueDate.after(startDate) || issueDate.equals(startDate))
					&& (issueDate.before(endDate) || issueDate.equals(endDate))) {
				result = true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		logger.debug(String.valueOf(result));
	}

	@Test
	public void calendar() {
		logger.debug(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
	}
}
