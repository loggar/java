package com.loggar.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class CrayonSortLamda {
	private List<Crayon> getData() {
		Crayon crayon1 = new Crayon("yellow");
		Crayon crayon2 = new Crayon("green");
		Crayon crayon3 = new Crayon("red");
		Crayon crayon4 = new Crayon("blue");
		Crayon crayon5 = new Crayon("purple");
		List<Crayon> cList = new ArrayList<>();
		cList.add(crayon1);
		cList.add(crayon2);
		cList.add(crayon3);
		cList.add(crayon4);
		cList.add(crayon5);

		return cList;
	}

	@Test
	public void test_crayonSortLamda() {
		Comparator<Crayon> cSort = new Comparator<Crayon>() {
			public int compare(Crayon c1, Crayon c2) {
				return c1.getColor().compareTo(c2.getColor());
			}
		};

		List<Crayon> cList = getData();
		Collections.sort(cList, cSort);
		System.out.println("Sorted: " + cList);
	}

	@Test
	public void test_crayonSortLamda2() {
		List<Crayon> cList = getData();
		Collections.sort(cList, (c1, c2) -> c1.getColor().compareTo(c2.getColor()));
		System.out.println("Sorted: " + cList);
	}
}
