package com.loggar.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringTest {
	Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Test
	public void test() {
		String requestUriSplit[] = {"", "sfss", "010100CR"};
		
		String pg2 = "";
		
		try {
			pg2 = requestUriSplit[2].substring(0, requestUriSplit[2].length()-2);
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
}
