package com.loggar.practice.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatting {
	public static void main(String[] args) {
		LocalDateTime input = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
		String date = input.format(format);
		String logFile = "simple-log-" + date + ".txt";

		System.out.println(logFile);

		System.out.print(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
	}
}
