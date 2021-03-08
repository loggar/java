package com.loggar.list.manipulate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

public class ListFilter {
	public void remove_fromIterator() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(1);

		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			int i = itr.next();
			if (i > 2) { // filter all ints bigger than 2
				itr.remove();
			}
		}
	}

	public void filter_apacheCommons() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(1);

		CollectionUtils.filter(list, new Predicate<Integer>() {
			@Override
			public boolean evaluate(Integer object) {
				return object < 3;
			}

		});
	}
}
