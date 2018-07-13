package com.loggar.process.cmd;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProceedCommandTimeDecorator {
	private static final Logger logger = LoggerFactory.getLogger(ProceedCommandTimeDecorator.class);

	private ProceedCommandTimeDecorator() {
		throw new AssertionError();
	}

	public static void run(ProceedCommand runable, List<String> commands) {
		long startTime = System.currentTimeMillis();
		logger.debug("Processing Start = {}", new Date(startTime));
		boolean resultRunable = runable.run(commands);
		long endTime = System.currentTimeMillis();
		logger.debug("Processing End = {}", new Date(endTime));
		logger.debug("Total Processing Time = {}", String.format("%,d msec", endTime - startTime));
		logger.debug("command list {}", commands);
		if (resultRunable) {
			logger.debug("Success run commands.");
		} else {
			logger.debug("Fail run commands.");
		}
	}
}
