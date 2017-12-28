package com.loggar.effective.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Consider typesafe heterogeneous containers
 *
 */
// Typesafe heterogeneous container pattern - implementation
public class _29_Favorites {
	private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

	public <T> void putFavorite(Class<T> type, T instance) {
		if (type == null)
			throw new NullPointerException("Type is null");
		favorites.put(type, instance);
	}

	// Achieving runtime type safety with a dynamic cast
	public <T> void putFavorite2(Class<T> type, T instance) {
		favorites.put(type, type.cast(instance));
	}

	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}

	// Typesafe heterogeneous container pattern - client
	public static void main(String[] args) {
		_29_Favorites f = new _29_Favorites();
		f.putFavorite(String.class, "Java");
		f.putFavorite(Integer.class, 0xcafebabe);
		f.putFavorite(Class.class, _29_Favorites.class);
		String favoriteString = f.getFavorite(String.class);
		int favoriteInteger = f.getFavorite(Integer.class);
		Class<?> favoriteClass = f.getFavorite(Class.class);
		System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
	}

}