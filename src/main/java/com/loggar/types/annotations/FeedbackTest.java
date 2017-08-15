package com.loggar.types.annotations;

import org.junit.Test;

public class FeedbackTest {
	@Test
	@Feedback(reportName="report1")
	public void test1() {
		System.out.println(Feedback.class);
	}
}
