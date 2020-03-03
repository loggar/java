package com.loggar.datetimes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeComponentTest {
	private static final Logger logger = LoggerFactory.getLogger(DateTimeComponentTest.class);

	DateTimeComponent dateTimeComponent = new DateTimeComponentImpl();

	String test_startDate = null;
	String test_targetDate = null;
	String test_endDate = null;

	String test_startDate_2 = "29/10/2016";
	String test_targetDate_2 = "1/11/2016";
	String test_endDate_2 = "31/10/2016";

	String test_lastChangedDate = "20160831 23:11:22";
	String test_lastChangedDate_2 = "20160702 23:11:22";

	@Before
	public void set() {
		Date day_test = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat(DateTimeComponent.str_dateFormat_1);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day_test);
		calendar.add(Calendar.MONTH, -1);
		Date date_start = new Date(calendar.getTimeInMillis());
		calendar.add(Calendar.MONTH, 2);
		Date date_end = new Date(calendar.getTimeInMillis());

		test_targetDate = dateFormatter.format(day_test);
		test_startDate = dateFormatter.format(date_start);
		test_endDate = dateFormatter.format(date_end);
	}

	@Test
	public void getYear() {
		logger.debug(String.valueOf(dateTimeComponent.getYear()));
	}

	@Test
	public void dateParse() {
		logger.debug(dateTimeComponent.parse(DateTimeComponent.str_dateFormat_1));
		logger.debug(dateTimeComponent.parse(DateTimeComponent.str_dateFormat_1_1));
		logger.debug(dateTimeComponent.parse(DateTimeComponent.str_dateFormat_1_2, Locale.ENGLISH));
		logger.debug(dateTimeComponent.parse(DateTimeComponent.str_dateFormat_2));
		logger.debug(dateTimeComponent.parse(DateTimeComponent.str_dateFormat_3));
	}

	// @Test
	public void between() {
		assertThat(dateTimeComponent.isBetween(test_startDate, test_endDate, DateTimeComponent.str_dateFormat_1), is(true));
		assertThat(dateTimeComponent.isBetween(test_targetDate, test_startDate, test_endDate, DateTimeComponent.str_dateFormat_1), is(true));
		assertThat(dateTimeComponent.isBetween(test_targetDate_2, test_startDate_2, test_endDate_2, DateTimeComponent.str_dateFormat_1), is(false));
		assertThat(dateTimeComponent.isBetween(test_targetDate_2, test_startDate_2, test_endDate_2, DateTimeComponent.str_dateFormat_1), is(false));
	}

	@Test
	public void expired() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -32);
		Date pastDate = new Date(calendar.getTimeInMillis());
		String str_test_date = dateTimeComponent.parse(pastDate, DateTimeComponent.str_dateFormat_3);

		logger.debug("Calendar : {}", new Date(calendar.getTimeInMillis()));

		assertThat(dateTimeComponent.isExpired(str_test_date, Calendar.MONTH, 3, DateTimeComponent.str_dateFormat_3), is(false));
		assertThat(dateTimeComponent.isExpired(str_test_date, Calendar.MONTH, 1, DateTimeComponent.str_dateFormat_3), is(true));
	}

	@Test
	public void isBetweenTargetTime() {
		assertThat(dateTimeComponent.isTimeBetweenTwoTime("01:01:01", "13:00:00", "09:01:01"), is(true));
		assertThat(dateTimeComponent.isTimeBetweenTwoTime("07:00:00", "22:00:01", "07:00:01"), is(true));
		assertThat(dateTimeComponent.isTimeBetweenTwoTime("07:00:00", "22:00:01", "07:00:00"), is(true));
		assertThat(dateTimeComponent.isTimeBetweenTwoTime("07:00:00", "22:00:01", "22:00:00"), is(true));
		assertThat(dateTimeComponent.isTimeBetweenTwoTime("07:00:00", "22:00:01", "22:00:01"), is(false));
	}

	// valid at 16:00:00
	// @Test
	public void isBetweenCurrentTime() {
		assertThat(dateTimeComponent.isTimeBetweenTwoTime("01:01:01", "13:00:00"), is(false));
		assertThat(dateTimeComponent.isTimeBetweenTwoTime("20:00:00", "23:59:59"), is(false));
		assertThat(dateTimeComponent.isTimeBetweenTwoTime("07:00:00", "22:00:01"), is(true));
		assertThat(dateTimeComponent.isTimeBetweenTwoTime("13:00:00", "22:00:01"), is(true));
	}
}
