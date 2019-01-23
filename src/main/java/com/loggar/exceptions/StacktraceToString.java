package com.loggar.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class StacktraceToString {
	static String convert(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}

	static String convertWithCommonsLang(Exception e) {
		// <!-- apache commons -->
		// <dependency>
		// <groupId>org.apache.commons</groupId>
		// <artifactId>commons-lang3</artifactId>
		// <version>3.5</version>
		// </dependency>
		return ExceptionUtils.getStackTrace(e);
	}

	public static void main(String[] args) {
		Exception e = new NullPointerException("something should not be null.");

		System.out.println(convert(e));
		System.out.println(convertWithCommonsLang(e));
	}
}
