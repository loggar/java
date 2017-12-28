package com.loggar.effective.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class _35_2_RunTests {
	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName("com.loggar.effective.annotations._02_Sample");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(_35_2_ExceptionTest.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				} catch (InvocationTargetException wrappedEx) {
					Throwable exc = wrappedEx.getCause();
					Class<? extends Exception> excType = m.getAnnotation(_35_2_ExceptionTest.class).value();
					if (excType.isInstance(exc)) {
						passed++;
					} else {
						System.out.printf("Test %s failed: expected %s, got %s%n", m, excType.getName(), exc);
					}
				} catch (Exception exc) {
					System.out.println("INVALID @Test: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}
}
/*
 * This code is similar to the code we used to process Test annotations, with
 * one exception: this code extracts the value of the annotation parameter and
 * uses it to check if the exception thrown by the test is of the right type.
 * There are no explicit casts, hence no danger of a ClassCastException.
 */
