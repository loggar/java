package com.loggar.annotations.feedback;

import org.junit.Test;

public class FeedbackTest {
	@Feedback(reportName = "report1")
	private class FeedbackSample {

	}

	@Test
	public void test1() {
		Feedback feedback = FeedbackSample.class.getAnnotation(Feedback.class);
		if (feedback == null) {
			System.out.println("no FeedbackSample annotation.");
		} else {
			System.out.println(feedback);
			System.out.println(feedback.comment());
			System.out.println(feedback.reportName());
			System.out.println(feedback.annotationType());
		}
	}
}
