package com.loggar.regexp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.loggar.util.common.StringUtil;

public class StringExtractor {
	public static List<String> extractNumbers(String str) {
		List<String> nums = new ArrayList<>();

		if (StringUtil.isEmpty(str)) {
			return Collections.emptyList();
		}

		String regex = "(\\d+)";
		Matcher matcher = Pattern.compile(regex).matcher(str);
		while (matcher.find()) {
			String m = matcher.group();
			nums.add(m);
		}
		return nums;
	}
}
