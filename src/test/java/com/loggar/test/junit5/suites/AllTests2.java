package com.loggar.test.junit5.suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import com.loggar.io.convert.ByteArrayAndFloat;
import com.loggar.test.junit5.assertions.LinearSearcherTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ ByteArrayAndFloat.class, LinearSearcherTest.class })
public class AllTests2 {

}
