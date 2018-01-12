package com.loggar.statements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterateConvention {
	public void test() {
		List<String> list = new ArrayList<>();

		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String s = it.next();
			System.out.println(s);
		}
	}
}
