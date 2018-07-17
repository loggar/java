package com.loggar.effective.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Prefer annotations to naming patterns
 * 
 * Indicates that the annotated method is a test method.
 * Use only on parameterless static methods.
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface _35_1_Test {

}
