package com.loggar.effective.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated method is a test method that must throw the designated exception to succeed.
 * 
 * Now let’s add support for tests that succeed only if they throw a particular exception. We’ll need a new annotation type for this:
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface _02_ExceptionTest {
	Class<? extends Exception> value();
}
