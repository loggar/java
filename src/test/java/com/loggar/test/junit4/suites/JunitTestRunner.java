package com.loggar.test.junit4.suites;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.loggar.datetimes.DateTimeComponentTest;

public class JunitTestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(DateTimeComponentTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}
}
