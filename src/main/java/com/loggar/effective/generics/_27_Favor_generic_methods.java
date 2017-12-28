package com.loggar.effective.generics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Favor generic methods
 *
 */
public class _27_Favor_generic_methods {
	// Generic method
	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}

	// Simple program to exercise generic method
	public void test1() {
		Set<String> guys = new HashSet<String>(Arrays.asList("Tom", "Dick", "Harry"));
		Set<String> stooges = new HashSet<String>(Arrays.asList("Larry", "Moe", "Curly"));
		Set<String> aflCio = union(guys, stooges);
		System.out.println(aflCio);
	}

	// Parameterized type instance creation with constructor
	public void test2() {
		Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
		System.out.println(anagrams.getClass());
	}

	/*
	 * To eliminate this redundancy, write a generic static factory method
	 * corresponding to each constructor that you want to use. For example, here is
	 * a generic static factory method corresponding to the parameterless HashMap
	 * constructor:
	 */
	// Generic static factory method
	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}

	public void test3() {
		Map<String, List<String>> anagrams = newHashMap();
		System.out.println(anagrams.getClass());
	}

	/**
	 * Suppose you have an interface that describes a function that accepts and
	 * returns a value of some type T:
	 */
	public interface UnaryFunction<T> {
		T apply(T arg);
	}

	/*
	 * Now suppose that you want to provide an identity function. It would be
	 * wasteful to create a new one each time it’s required, as it’s stateless. If
	 * generics were reified, you would need one identity function per type, but
	 * since they’re erased you need only a generic singleton. Here’s how it looks:
	 */
	// Generic singleton factory pattern
	private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
		public Object apply(Object arg) {
			return arg;
		}
	};

	// IDENTITY_FUNCTION is stateless and its type parameter is
	// unbounded so it's safe to share one instance across all types.
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}

	// Sample program to exercise generic singleton
	public static void test4(String[] args) {
		String[] strings = { "jute", "hemp", "nylon" };
		UnaryFunction<String> sameString = identityFunction();
		for (String s : strings)
			System.out.println(sameString.apply(s));
		Number[] numbers = { 1, 2.0, 3L };
		UnaryFunction<Number> sameNumber = identityFunction();
		for (Number n : numbers)
			System.out.println(sameNumber.apply(n));
	}

	// Returns the maximum value in a list - uses recursive type bound
	public static <T extends Comparable<T>> T max(List<T> list) {
		Iterator<T> i = list.iterator();
		T result = i.next();
		while (i.hasNext()) {
			T t = i.next();
			if (t.compareTo(result) > 0)
				result = t;
		}
		return result;
	}
}
