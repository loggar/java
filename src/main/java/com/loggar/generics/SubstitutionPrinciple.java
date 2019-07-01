package com.loggar.generics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SubstitutionPrinciple {
	@Test
	public void test1() {
		// List declared with generic Number type
		List<Number> nList = new ArrayList<Number>();
		nList.add((byte) 27); // Byte (Autoboxing)
		nList.add((short) 30000); // Short
		nList.add(1234567890); // Integer
		nList.add((long) 2e62); // Long
		nList.add((float) 3.4); // Float
		nList.add(4000.8); // Double
		nList.add(new BigInteger("9223372036854775810"));
		nList.add(new BigDecimal("2.1e309"));
		// Print Number's subtype values from the list
		for (Number n : nList)
			System.out.println(n);
	}

	@Test
	public void test2() {
		List<Integer> srcList = new ArrayList<Integer>();
		srcList.add(0);
		srcList.add(1);
		srcList.add(2);
		// Using addAll() method with extends wildcard
		List<Integer> destList = new ArrayList<Integer>();
		destList.addAll(srcList);
	}

	@Test
	public void test3() {
		// Using addAll() method with super wildcard
		List<Number> sList = new ArrayList<Number>();
		sList.add(0);
		Collections.addAll(sList, (byte) 1, (short) 2);
	}
}
