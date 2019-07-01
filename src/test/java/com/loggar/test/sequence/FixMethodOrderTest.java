package com.loggar.test.sequence;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // java 1.8, junit 4.11
public class FixMethodOrderTest {

	@Rule
	public TestName testName = new TestName();

	@Test
	public void cake() {
		printDetails();
	}

	@Test
	public void apple() {
		printDetails();
	}

	@Test
	public void brownies() {
		printDetails();
	}

	private void printDetails() {
		System.out.println(testName.getMethodName() + ", hash(" + testName.getMethodName().hashCode() + ")");
	}
}
