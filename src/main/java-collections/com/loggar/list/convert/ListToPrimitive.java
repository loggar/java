package com.loggar.list.convert;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListToPrimitive {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		int[] array = ArrayUtils.toPrimitive(list.toArray(new Integer[0]));

		logger.debug("array {}", array);

		int[] array2 = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array2[i] = list.get(i);
		}

		logger.debug("array2 {}", array2);
	}
}
