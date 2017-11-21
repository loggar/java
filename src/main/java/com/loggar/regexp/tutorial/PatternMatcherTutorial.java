package com.loggar.regexp.tutorial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTutorial {
	public static void main(String[] args) {
		String crunchifyData = "This is Java Regex Pattern Example. http://crunchify.com. This is the list of all Matcher Example";
		System.out.println("This is sample data 'crunchifyData': " + crunchifyData);
		matches(crunchifyData);
		lookingAt(crunchifyData);
		findStartEnd(crunchifyData);

		String crunchifyData2 = "Crunchify is a Web company. Google is a Search company. Facebook is a social company.";
		group(crunchifyData2);
		multipleGroups(crunchifyData2);
		replaceAll(crunchifyData2);
	}

	// crunchifyMatcher.replaceAll()
	private static void replaceAll(String crunchifyData2) {
		String crunchifyPattern = "company";
		Pattern pat = Pattern.compile(crunchifyPattern);
		Matcher crunchifyMatcher = pat.matcher(crunchifyData2);
		String updatedString = crunchifyMatcher.replaceAll("best company");
		System.out.println("replaceAll() - updated String: " + updatedString);
	}

	private static void multipleGroups(String crunchifyData2) {
		String crunchifyPattern = "(is) (.+?) (.+?) ";
		Pattern pat = Pattern.compile(crunchifyPattern);
		Matcher crunchifyMatcher = pat.matcher(crunchifyData2);
		while (crunchifyMatcher.find()) {
			System.out.println("multipleGroup() result: " + crunchifyMatcher.group());
		}
	}

	// crunchifyMatcher.group()
	private static void group(String crunchifyData2) {
		String crunchifyPattern = "company";
		Pattern pat = Pattern.compile(crunchifyPattern);
		Matcher crunchifyMatcher = pat.matcher(crunchifyData2);
		while (crunchifyMatcher.find()) {
			System.out.println("group() result: " + crunchifyMatcher.group());
		}
	}

	// crunchifyMatcher.find() - start() - end()
	private static void findStartEnd(String crunchifyData) {
		String crunchifyPattern = "Example";
		Pattern pat = Pattern.compile(crunchifyPattern);
		Matcher crunchifyMatcher = pat.matcher(crunchifyData);
		int totalCount = 0;
		while (crunchifyMatcher.find()) {
			totalCount++;
			System.out.println("findStartEnd result = Iteration " + totalCount + " : " + crunchifyMatcher.start()
					+ " - " + crunchifyMatcher.end());
		}
	}

	// crunchifyMatcher.lookingAt()
	private static void lookingAt(String crunchifyData) {
		String crunchifyPattern = "This is Java";
		Pattern pat = Pattern.compile(crunchifyPattern);
		Matcher crunchifyMatcher = pat.matcher(crunchifyData);
		boolean isLookingAt = crunchifyMatcher.lookingAt();
		System.out.println("lookingAt() result 1: " + isLookingAt);

		crunchifyPattern = " is Java";
		pat = Pattern.compile(crunchifyPattern);
		crunchifyMatcher = pat.matcher(crunchifyData);
		isLookingAt = crunchifyMatcher.lookingAt();
		System.out.println("lookingAt() result 2: " + isLookingAt);

	}

	// crunchifyMatcher.matches()
	public static void matches(String crunchifyData) {
		String crunchifyPattern = ".*http://.*";

		Pattern pat = Pattern.compile(crunchifyPattern);
		Matcher crunchifyMatcher = pat.matcher(crunchifyData);
		boolean isMatched = crunchifyMatcher.matches();
		System.out.println("matches() result: " + isMatched);
	}
}
