package com.loggar.statements;

/**
 * Assertions are Boolean expressions used to check whether code behaves as expected while running in debug mode (i.e., using the -enableassertions or -ea switch with the Java interpreter).
 */
public class AssertSample1 {
	public void assertSampleTest() {
		int i = 4;

		assert (i == 5) : "Invalid value : " + i;

		System.out.println("not reached if assertion above failed.");
	}

	public static void main(String[] args) {
		AssertSample1 a1 = new AssertSample1();
		a1.assertSampleTest();
	}
}
