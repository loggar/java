package com.loggar.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DifferenceBetweenForEachAndStreamForEach {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", "C", "D");

		List<String> myList = new ReverseList();
		myList.addAll(list);

		for (String s : list)
			System.out.print(s);
		System.out.println();

		list.forEach(System.out::print);
		System.out.println();

		list.stream().forEach(System.out::print);
		System.out.println();
		
		list.parallelStream().forEach(System.out::print);
		System.out.println();

		for (String s : myList)
			System.out.print(s);
		System.out.println();

		myList.forEach(System.out::print);
		System.out.println();

		myList.stream().forEach(System.out::print);
	}

}

class ReverseList extends ArrayList<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4756408762688759218L;

	@Override
	public Iterator<String> iterator() {

		int startIndex = this.size() - 1;
		List<String> list = this;

		Iterator<String> it = new Iterator<String>() {

			private int currentIndex = startIndex;

			@Override
			public boolean hasNext() {
				return currentIndex >= 0;
			}

			@Override
			public String next() {
				String next = list.get(currentIndex);
				currentIndex--;
				return next;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		return it;
	}
}