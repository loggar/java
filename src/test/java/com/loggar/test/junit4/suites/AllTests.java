package com.loggar.test.junit4.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.loggar.datetimes.DateTimeComponentImplParseTest;
import com.loggar.datetimes.DateTimeComponentTest;

@RunWith(Suite.class)
@SuiteClasses({ DateTimeComponentImplParseTest.class, DateTimeComponentTest.class })
public class AllTests {
	// empty, just holder for annotations
	// run test of this class
}