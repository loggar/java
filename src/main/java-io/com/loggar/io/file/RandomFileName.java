package com.loggar.io.file;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomFileName {
	public static void main(String [] args) {
		/*
		 * with apache commons lang3
		 */
		int lenFileName = 32;
		String orgFileName = "abcd.txt";
		String newFileName = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(lenFileName), FilenameUtils.getExtension(orgFileName));
		System.out.println(newFileName);
	}
}
