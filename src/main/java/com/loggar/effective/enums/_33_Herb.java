package com.loggar.effective.enums;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Use EnumMap instead of ordinal indexing
 *
 */
public class _33_Herb {
	public enum Type {
		ANNUAL, PERENNIAL, BIENNIAL
	}

	private final String name;
	private final Type type;

	_33_Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return name + "(" + type + ")";
	}

	public static void bad_test_case(String[] args) {
		// Using ordinal() to index an array - DON'T DO THIS!
		_33_Herb[] garden = { new _33_Herb("a", _33_Herb.Type.ANNUAL), new _33_Herb("p", _33_Herb.Type.PERENNIAL),
				new _33_Herb("b", _33_Herb.Type.BIENNIAL) };

		@SuppressWarnings("unchecked")
		Set<_33_Herb>[] herbsByType = // Indexed by Herb.Type.ordinal()
				(Set<_33_Herb>[]) new Set[_33_Herb.Type.values().length];
		for (int i = 0; i < herbsByType.length; i++)
			herbsByType[i] = new HashSet<_33_Herb>();
		for (_33_Herb h : garden)
			herbsByType[h.type.ordinal()].add(h);
		// Print the results
		for (int i = 0; i < herbsByType.length; i++) {
			System.out.printf("%s: %s%n", _33_Herb.Type.values()[i], herbsByType[i]);
		}
	}

	public static void main(String[] args) {
		_33_Herb[] garden = { new _33_Herb("a", _33_Herb.Type.ANNUAL), new _33_Herb("p", _33_Herb.Type.PERENNIAL),
				new _33_Herb("b", _33_Herb.Type.BIENNIAL) };

		Map<_33_Herb.Type, Set<_33_Herb>> herbsByType = new EnumMap<_33_Herb.Type, Set<_33_Herb>>(_33_Herb.Type.class);
		for (_33_Herb.Type t : _33_Herb.Type.values())
			herbsByType.put(t, new HashSet<_33_Herb>());
		for (_33_Herb h : garden)
			herbsByType.get(h.type).add(h);
		System.out.println(herbsByType);
	}
}