package com.loggar.structure.linkedlist;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 테스트중. 시간날때 만들자.
 * @author loggar.lee
 *
 */
public class LinkedListTest {
	private static final Logger logger = LoggerFactory.getLogger(LinkedListTest.class);
	
	@Test
	public void test1() {
		LinkedList<String> lindedList = new LinkedListSimple<String>();
		
		lindedList.add("11");
		lindedList.add("00", 3);
		
		logger.debug(lindedList.get(1));
		logger.debug(lindedList.get(2));
		logger.debug(lindedList.get(3));
		logger.debug(lindedList.get(4));
		logger.debug(lindedList.get(5));
	}
}
