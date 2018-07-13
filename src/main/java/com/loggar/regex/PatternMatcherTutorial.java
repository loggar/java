package com.loggar.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTutorial {
	public static void main(String[] args) {
		String sampleData = "This is Java Regex Pattern Example. http://sample.com. This is the list of all Matcher Example";
		System.out.println("This is sample data 'sampleData': " + sampleData);
		matches(sampleData);
		lookingAt(sampleData);
		findStartEnd(sampleData);

		String sampleData2 = "Sample is a Web company. Google is a Search company. Facebook is a social company.";
		group(sampleData2);
		multipleGroups(sampleData2);
		replaceAll(sampleData2);
	}

	// sampleMatcher.replaceAll()
	private static void replaceAll(String sampleData2) {
		String samplePattern = "company";
		Pattern pat = Pattern.compile(samplePattern);
		Matcher sampleMatcher = pat.matcher(sampleData2);
		String updatedString = sampleMatcher.replaceAll("best company");
		System.out.println("replaceAll() - updated String: " + updatedString);
	}

	private static void multipleGroups(String sampleData2) {
		String samplePattern = "(is) (.+?) (.+?) ";
		Pattern pat = Pattern.compile(samplePattern);
		Matcher sampleMatcher = pat.matcher(sampleData2);
		while (sampleMatcher.find()) {
			System.out.println("multipleGroup() result: " + sampleMatcher.group());
		}
	}

	// sampleMatcher.group()
	private static void group(String sampleData2) {
		String samplePattern = "company";
		Pattern pat = Pattern.compile(samplePattern);
		Matcher sampleMatcher = pat.matcher(sampleData2);
		while (sampleMatcher.find()) {
			System.out.println("group() result: " + sampleMatcher.group());
		}
	}

	// sampleMatcher.find() - start() - end()
	private static void findStartEnd(String sampleData) {
		String samplePattern = "Example";
		Pattern pat = Pattern.compile(samplePattern);
		Matcher sampleMatcher = pat.matcher(sampleData);
		int totalCount = 0;
		while (sampleMatcher.find()) {
			totalCount++;
			System.out.println("findStartEnd result = Iteration " + totalCount + " : " + sampleMatcher.start()
					+ " - " + sampleMatcher.end());
		}
	}

	// sampleMatcher.lookingAt()
	private static void lookingAt(String sampleData) {
		String samplePattern = "This is Java";
		Pattern pat = Pattern.compile(samplePattern);
		Matcher sampleMatcher = pat.matcher(sampleData);
		boolean isLookingAt = sampleMatcher.lookingAt();
		System.out.println("lookingAt() result 1: " + isLookingAt);

		samplePattern = " is Java";
		pat = Pattern.compile(samplePattern);
		sampleMatcher = pat.matcher(sampleData);
		isLookingAt = sampleMatcher.lookingAt();
		System.out.println("lookingAt() result 2: " + isLookingAt);

	}

	// sampleMatcher.matches()
	public static void matches(String sampleData) {
		String samplePattern = ".*http://.*";

		Pattern pat = Pattern.compile(samplePattern);
		Matcher sampleMatcher = pat.matcher(sampleData);
		boolean isMatched = sampleMatcher.matches();
		System.out.println("matches() result: " + isMatched);
	}
}
