package com.loggar.effective.annotations;

import java.lang.reflect.Method;

public class _03_RunTests {
	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName("com.loggar.effective.annotations._03_Sample");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(_03_ExceptionTest.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				} catch (Throwable wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					Class<? extends Exception>[] excTypes = m.getAnnotation(_03_ExceptionTest.class).value();
					int oldPassed = passed;
					for (Class<? extends Exception> excType : excTypes) {
						if (excType.isInstance(exc)) {
							passed++;
							break;
						}
					}
					if (passed == oldPassed)
						System.out.printf("Test %s failed: %s %n", m, exc);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}
}
/*
 * The testing framework developed in this item is just a toy, but it clearly
 * demonstrates the superiority of annotations over naming patterns. And it only
 * scratches the surface of what you can do with annotations. If you write a
 * tool that requires programmers to add information to source files, define an
 * appropriate set of annotation types. There is simply no reason to use naming
 * patterns now that we have annotations.
 * 
 * That said, with the exception of toolsmiths, most programmers will have no
 * need to define annotation types. All programmers should, however, use the
 * predefined annotation types provided by the Java platform (Items 36 and Item
 * 24). Also, consider using any annotations provided by your IDE or static
 * analysis tools. Such annotations can improve the quality of the diagnostic
 * information provided by these tools. Note, however, that these annotations
 * have yet to be standardized, so you will have some work to do if you switch
 * tools, or if a standard emerges.
 */