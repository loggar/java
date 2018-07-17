package com.loggar.effective.annotations;

/**
 * Prefer annotations to naming patterns
 *
 */
public class _35_1_Sample {
	@_35_1_Test
	public static void m1() {
	} // Test should pass

	public static void m2() {
	}

	@_35_1_Test
	public static void m3() { // Test Should fail
		throw new RuntimeException("Boom");
	}

	public static void m4() {
	}

	@_35_1_Test
	public void m5() {
	} // INVALID USE: nonstatic method

	public static void m6() {
	}

	@_35_1_Test
	public static void m7() { // Test should fail
		throw new RuntimeException("Crash");
	}

	public static void m8() {
	}
}
/*
 * The Sample class has eight static methods, four of which are annotated as
 * tests. Two of these, m3 and m7, throw exceptions and two, m1 and m5, do not.
 * But one of the annotated methods that does not throw an exception, m5, is an
 * instance method, so it is not a valid use of the annotation. In sum, Sample
 * contains four tests: one will pass, two will fail, and one is invalid. The
 * four methods that are not annotated with the Test annotation will be ignored
 * by the testing tool.
 */
