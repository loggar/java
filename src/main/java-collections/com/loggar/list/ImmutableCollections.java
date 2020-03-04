package com.loggar.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableCollections {

	// Collections.unmodifiableCollection
	// Collections.unmodifiableList
	// Collections.unmodifiableMap
	// Collections.unmodifiableNavigableMap
	// Collections.unmodifiableNavigableSet
	// Collections.unmodifiableSet
	// Collections.unmodifiableSortedMap
	// Collections.unmodifiableSortedSet

	/*
	 * Bad news! If you hang onto the reference to the collection when you create the collection, you can still modify it, even if you store it as an unmodifiable collection internally.
	 */
	public void test_1() {

		class ImmutableShoppingList {
			private final List<String> list;

			public ImmutableShoppingList(List<String> list) {
				this.list = Collections.unmodifiableList(list);
			}

			public List<String> getList() {
				return list;
			}
		}

		List<String> originalList = new ArrayList<>();
		originalList.add("apple");
		ImmutableShoppingList blah = new ImmutableShoppingList(originalList);
		blah.getList();
		originalList.add("candy bar");
	}

	/*
	 * The supposedly immutable shopping list started with an apple, and had a candy bar added to it after creation. What can we do about this? Clone the list!
	 */
	public void test_2() {
		class ImmutableShoppingList {

			private final List<String> list;

			public ImmutableShoppingList(List<String> list) {
				List<String> tmpListOfHolding = new ArrayList<>();
				tmpListOfHolding.addAll(list);
				this.list = Collections.unmodifiableList(tmpListOfHolding);
			}

			public String[] getList() {
				return (String[]) list.toArray();
			}
		}

		List<String> originalList = new ArrayList<>();
		originalList.add("apple");
		ImmutableShoppingList blah = new ImmutableShoppingList(originalList);
		blah.getList();
		originalList.add("candy bar");
	}

	public void test_array() {
		class ImmutableShoppingList {

			private final List<String> list;

			public ImmutableShoppingList(String[] list) {
				this.list = Collections.unmodifiableList(Arrays.asList(list));
			}

			public String[] getList() {
				return (String[]) list.toArray();
			}
		}

		String[] arrStr = { "a", "b" };
		ImmutableShoppingList blah = new ImmutableShoppingList(arrStr);
		blah.getList();
	}
}
