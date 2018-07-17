package com.loggar.effective.annotations;

import java.util.HashSet;
import java.util.Set;

/**
 * Consistently use the Override annotation
 *
 */
// Can you spot the bug?
public class _36_Bigram_1 {
	private final char first;
	private final char second;

	public _36_Bigram_1(char first, char second) {
		this.first = first;
		this.second = second;
	}

	public boolean equals(_36_Bigram_1 b) {
		return b.first == first && b.second == second;
	}

	public int hashCode() {
		return 31 * first + second;
	}

	public static void main(String[] args) {
		Set<_36_Bigram_1> s = new HashSet<_36_Bigram_1>();
		for (int i = 0; i < 10; i++)
			for (char ch = 'a'; ch <= 'z'; ch++)
				s.add(new _36_Bigram_1(ch, ch));
		System.out.println(s.size());
	}
}
/*
 * Clearly, the author of the Bigram class intended to override the equals
 * method (Item 8) and even remembered to override hashCode in tandem (Item 9).
 * Unfortunately, our hapless programmer failed to override equals, overloading
 * it instead (Item 41). To override Object.equals, you must define an equals
 * method whose parameter is of type Object.
 */