package com.loggar.datetimes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class DateTimeUtilTest {
	@Test
	public void isValid() {
		String s1 = "01/01/2020";
		String s2 = "27/10/20200300";
		String s3 = "50/12/2020";
		String s4 = "02/15/2020";
		String s5 = "02/31/2205";
		String s6 = "31/12/2999";
		String s7 = "91239/05/2020,";
		String s8 = "12/2198/2018";
		String s9 = "01-01-2018";
		String s10 = "01-15-2018";
		assertTrue(DateTimeUtil.isValidAUDateFormat(s1));
		assertFalse(DateTimeUtil.isValidAUDateFormat(s2));
		assertFalse(DateTimeUtil.isValidAUDateFormat(s3));
		assertFalse(DateTimeUtil.isValidAUDateFormat(s4));
		assertFalse(DateTimeUtil.isValidAUDateFormat(s5));
		assertTrue(DateTimeUtil.isValidAUDateFormat(s6));
		assertFalse(DateTimeUtil.isValidAUDateFormat(s7));
		assertFalse(DateTimeUtil.isValidAUDateFormat(s8));
		assertTrue(DateTimeUtil.isValidAUDateFormat(s9));
		assertFalse(DateTimeUtil.isValidAUDateFormat(s10));

		String t1 = "01:00";
		String t2 = "15:30";
		String t3 = "23:59";
		String t4 = "99:01";
		String t5 = "3920";
		String t6 = "05-21";
		assertTrue(DateTimeUtil.isValidTimeStringFormat(t1));
		assertTrue(DateTimeUtil.isValidTimeStringFormat(t2));
		assertTrue(DateTimeUtil.isValidTimeStringFormat(t3));
		assertFalse(DateTimeUtil.isValidTimeStringFormat(t4));
		assertFalse(DateTimeUtil.isValidTimeStringFormat(t5));
		assertFalse(DateTimeUtil.isValidTimeStringFormat(t6));
	}
}
