package com.loggar.process.node;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunProcessNoWait {
	private static final Logger logger = LoggerFactory.getLogger(RunProcessNoWait.class);

	public static void run(String[] args) {
		ProcessBuilder builder = new ProcessBuilder(args);
		builder.redirectErrorStream(true);
		try {
			builder.start();
		} catch (IOException e) {
			logger.error("{}" + e);
		}
	}
}
