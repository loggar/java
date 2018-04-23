package com.loggar.regexp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.loggar.util.common.StringUtil;

public class ExtractDigits {
	private List<String> extractNumbers(String str) {
		List<String> nums = new ArrayList<>();
		String regex = "(\\d+)";
		Matcher matcher = Pattern.compile(regex).matcher(str);
		while (matcher.find()) {
			String m = matcher.group();
			nums.add(m);
		}
		return nums;
	}

	// @Test
	public void test1() {
		String str = "123-456-789";
		List<String> nums = extractNumbers(str);
		System.out.println(StringUtil.debugList(nums, true));
	}

	@Test
	public void test2() {
		String str = " 3 subjects   ";
		List<String> nums = extractNumbers(str);
		System.out.println(StringUtil.debugList(nums, true));

	}
}
