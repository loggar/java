package com.loggar.datetimes;

import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateBetweenTest {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	Locale locale = Locale.ENGLISH;

	String str_dateFormat_1 = "dd/MM/yyyy";
	String str_dateFormat_2 = "dd/MM/yyyy HH:mm:ss";
	String str_dateFormat_3 = "yyyyMMdd HH:mm:ss";
	String str_dateFormat_4 = "yyyyMMddHHmm";
	String str_dateFormat_5 = "dd/MM/yyyy h:mm a";

	@Test
	public void checkBetweenDate_jdk8() {
		String str_issueDate = "31/10/2016";
		String str_invoiceStartDate = "29/10/2016";
		String str_invoiceEndDate = "31/10/2016";

		boolean result = false;

		LocalDateTime dt = LocalDateTime.from(LocalDate.parse(str_issueDate, DateTimeFormatter.ofPattern("dd/MM/yyyy", java.util.Locale.ENGLISH)).atStartOfDay());
		LocalDateTime startDtStr = LocalDateTime.from(LocalDate.parse(str_invoiceStartDate, DateTimeFormatter.ofPattern("dd/MM/yyyy", java.util.Locale.ENGLISH)).atStartOfDay());
		LocalDateTime endDtStr = LocalDateTime.from(LocalDate.parse(str_invoiceEndDate, DateTimeFormatter.ofPattern("dd/MM/yyyy", java.util.Locale.ENGLISH)).atStartOfDay());

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

			if ((issueDate.after(startDate) || issueDate.equals(startDate)) && (issueDate.before(endDate) || issueDate.equals(endDate))) {
				result = true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		logger.debug(String.valueOf(result));
	}

}
