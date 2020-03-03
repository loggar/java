package com.loggar.datetimes;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeComponentImplParseTest {
	private static final Logger logger = LoggerFactory.getLogger(DateTimeComponentImplParseTest.class);

	DateTimeComponent datetimeComponent = new DateTimeComponentImpl();

	// @Test
	public void selectDate() {
		String parsedDate = datetimeComponent.parse(DateTimeComponent.str_dateFormat_1);

		logger.debug("{}", parsedDate);
	}

	@Test
	public void currentTime() {
		String parsedDateTime = datetimeComponent.parse(DateTimeComponent.str_dateFormat_1_1);
		logger.debug("{}", parsedDateTime);

		if (parsedDateTime.length() < 8) parsedDateTime = "        " + parsedDateTime;
		String currentTime = parsedDateTime.substring(parsedDateTime.length() - 8, parsedDateTime.length());

		logger.debug("{}", currentTime);
	}
}
