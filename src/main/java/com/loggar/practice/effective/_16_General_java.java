package com.loggar.practice.effective;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _16_General_java {
	List<String> list = new ArrayList<>();

	/**
	 * minimize the scope of local variables.
	 */
	public void localScope() {
		for (Iterator<String> i = list.iterator(); i.hasNext();) {
			System.out.println(i);
		}
	}

	/**
	 * prefer for-each loops to traditional for loops.
	 */
	public void forLoop() {
		for (String s : list) {
			System.out.println(s);
		}
	}
	
	/**
	 * String concatenation leads low performance.
	 */
	public String concat1() {
		String r= "";
		for(int i=0; i<1000; i++)
			r += i;
		return r;
	}
	
	/**
	 * Prefer StringBuilder for string concatenation.
	 */
	public String concat2() {
		StringBuilder b = new StringBuilder();
		b.setLength(0);
		
		for(int i=0; i<1000; i++)
			b.append(i);
		return b.toString();
	}
}
