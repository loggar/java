package com.loggar.list;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListToArray {
	@Test
	public void toArray () {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		String[] arr = list.stream().toArray(String[]::new);
		
		String s = String.join(", ", arr);
		System.out.println(s);
	}
	
	@Test
	public void toArray2 () {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		String[] arr = list.toArray(new String[list.size()]);
		
		String s = String.join(", ", arr);
		System.out.println(s);
	}
}
