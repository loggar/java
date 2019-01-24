package com.loggar.regex;

import java.util.List;

import org.junit.Test;

import com.loggar.tools.common.StringUtil;

public class StringExtractorTest {
	@Test
	public void test1() {
		String str = "123-456-789";
		List<String> nums = StringExtractor.extractNumbers(str);
		System.out.println(StringUtil.debugList(nums, true));
	}

	@Test
	public void test2() {
		String str = " 3 subjects   ";
		List<String> nums = StringExtractor.extractNumbers(str);
		System.out.println(StringUtil.debugList(nums, true));

	}
}
