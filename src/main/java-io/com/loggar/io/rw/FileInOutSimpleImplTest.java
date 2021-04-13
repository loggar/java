package com.loggar.io.rw;

import java.lang.invoke.MethodHandles;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileInOutSimpleImplTest {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private FileInOutSimple fileio;

	@Before
	public void before() {
		this.fileio = new FileInOutSimpleImpl();
	}

	@Test
	public void file_read_1() {
		String filePath = "version-info-resources";
		URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
		String data = fileio.read(url.getPath());

		logger.debug("filePath={}", filePath);
		logger.debug("url={}", url);
		logger.debug("url.getPath()={}", url.getPath());
		logger.debug("data={}", data);
	}
}
