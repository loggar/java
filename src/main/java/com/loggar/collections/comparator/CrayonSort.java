package com.loggar.collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

public class CrayonSort implements Comparator<Crayon> {
	@Override
	public int compare(Crayon c1, Crayon c2) {
		return c1.getColor().compareTo(c2.getColor());
	}

	@Test
	public void test_crayonSort() {
		Crayon crayon1 = new Crayon("yellow");
		Crayon crayon2 = new Crayon("green");
		Crayon crayon3 = new Crayon("red");
		Crayon crayon4 = new Crayon("blue");
		Crayon crayon5 = new Crayon("purple");
		ArrayList<Crayon> cList = new ArrayList<>();
		cList.add(crayon1);
		cList.add(crayon2);
		cList.add(crayon3);
		cList.add(crayon4);
		cList.add(crayon5);
		System.out.println("Unsorted: " + cList);
		CrayonSort cSort = new CrayonSort(); // Here
		Collections.sort(cList, cSort);
		System.out.println("Sorted: " + cList);
	}
}
