package com.loggar.annotations.feedback;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Feedback {
	String reportName();
	String comment() default "none";
}