package com.loggar.effective.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * More generally, annotations never change the semantics of the annotated code, but enable it for special treatment by tools such as this simple test runner:
 * 
 */
public class _01_RunTests {
	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName("com.loggar.effective.annotations._01_Sample");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(_01_Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " failed: " + exc);
				} catch (Exception exc) {
					System.out.println("INVALID @Test: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}
}
/*
 * The isAnnotationPresent method tells the tool which methods to run. If a test
 * method throws an exception, the reflection facility wraps it in an
 * InvocationTargetException. The tool catches this exception and prints a
 * failure report containing the original exception thrown by the test method,
 * which is extracted from the InvocationTargetException with the getCause
 * method.
 */
