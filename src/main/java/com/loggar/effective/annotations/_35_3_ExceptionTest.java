package com.loggar.effective.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Prefer annotations to naming patterns
 *
 */
//Annotation type with an array parameter
//Suppose we change the parameter type of the ExceptionTest annotation to be an array of Class objects:
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface _35_3_ExceptionTest {
	Class<? extends Exception>[] value();
}