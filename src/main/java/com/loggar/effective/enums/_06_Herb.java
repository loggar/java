package com.loggar.effective.enums;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Use EnumMap instead of ordinal indexing
 *
 */
public class _06_Herb {
	public enum Type {
		ANNUAL, PERENNIAL, BIENNIAL
	}

	private final String name;
	private final Type type;

	_06_Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return name + "(" + type + ")";
	}

	public static void bad_test_case(String[] args) {
		// Using ordinal() to index an array - DON'T DO THIS!
		_06_Herb[] garden = { new _06_Herb("a", _06_Herb.Type.ANNUAL), new _06_Herb("p", _06_Herb.Type.PERENNIAL),
				new _06_Herb("b", _06_Herb.Type.BIENNIAL) };

		@SuppressWarnings("unchecked")
		Set<_06_Herb>[] herbsByType = // Indexed by Herb.Type.ordinal()
				(Set<_06_Herb>[]) new Set[_06_Herb.Type.values().length];
		for (int i = 0; i < herbsByType.length; i++)
			herbsByType[i] = new HashSet<_06_Herb>();
		for (_06_Herb h : garden)
			herbsByType[h.type.ordinal()].add(h);
		// Print the results
		for (int i = 0; i < herbsByType.length; i++) {
			System.out.printf("%s: %s%n", _06_Herb.Type.values()[i], herbsByType[i]);
		}
	}

	public static void main(String[] args) {
		_06_Herb[] garden = { new _06_Herb("a", _06_Herb.Type.ANNUAL), new _06_Herb("p", _06_Herb.Type.PERENNIAL),
				new _06_Herb("b", _06_Herb.Type.BIENNIAL) };

		Map<_06_Herb.Type, Set<_06_Herb>> herbsByType = new EnumMap<_06_Herb.Type, Set<_06_Herb>>(_06_Herb.Type.class);
		for (_06_Herb.Type t : _06_Herb.Type.values())
			herbsByType.put(t, new HashSet<_06_Herb>());
		for (_06_Herb h : garden)
			herbsByType.get(h.type).add(h);
		System.out.println(herbsByType);
	}
}