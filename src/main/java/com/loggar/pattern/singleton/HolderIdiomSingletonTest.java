package com.loggar.pattern.singleton;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class HolderIdiomSingletonTest {
	private static final Logger logger = LoggerFactory.getLogger(HolderIdiomSingletonTest.class);
	
	@Test
	public void singletonTest() {
		HolderIdiomSingleton singletonInstance = HolderIdiomSingleton.getInstance();
		HolderIdiomSingleton singletonInstance2 = HolderIdiomSingleton.getInstance();
		
		logger.debug("singletonInstance : {}", singletonInstance);
		logger.debug("singletonInstance2 : {}", singletonInstance2);
		
		assertTrue(singletonInstance == singletonInstance2);
	}
}
