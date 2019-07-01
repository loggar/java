package com.loggar.strings;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubstringTest {
	Logger logger = LoggerFactory.getLogger(getClass());

	// @Test
	public void test() {
		String requestUriSplit[] = { "", "sfss", "010100CR" };

		String pg2 = "";

		try {
			pg2 = requestUriSplit[2].substring(0, requestUriSplit[2].length() - 2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		logger.debug(pg2);
	}

	@Test
	public void test2() {
		String tri = "0217";

		String tri2 = tri.substring(0, 2);
		String tri3 = tri.substring(2);

		logger.debug(tri2);
		logger.debug(tri3);
		logger.debug(tri3 + tri2);
	}

	@Test
	public void last8chars() {
		String parsedDate = "12/12/2018 11:01:59";
		if (parsedDate.length() < 8) parsedDate = "        " + parsedDate;
		String currentTime = parsedDate.substring(parsedDate.length() - 8, parsedDate.length());

		logger.debug('[' + currentTime + ']');
	}
}
