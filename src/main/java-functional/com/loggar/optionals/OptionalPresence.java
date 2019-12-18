package com.loggar.optionals;

import java.util.Optional;

public class OptionalPresence {
	public static void main(String[] args) {
		Optional<User> optional = Optional.of(new User("2", "John Smith"));

		// isPresent()
		if (optional.isPresent()) {
			System.out.println("Value found - " + optional.get());
		} else {
			System.out.println("Optional is empty");
		}

		// ifPresent()
		optional.ifPresent(value -> {
			System.out.println("Value found - " + value);
		});

		// Retrieving the value using get() method
		User user = optional.get();

		System.out.println(user);

		// Returning default value using orElse()
		Optional<User> userEmpty = Optional.empty();

		// return "Unknown User" if user is null
		User userNull = null;
		User finalUser1 = (userNull != null) ? userNull : new User("0", "Unknown User");
		System.out.println(finalUser1);

		// return "Unknown User" if user is null (in optional way)
		User finalUser2 = userEmpty.orElse(new User("0", "Unknown User"));
		System.out.println(finalUser2);

		// Returning default value using orElseGet()
		User finalUser3 = userEmpty.orElseGet(() -> {
			return new User("0", "Unknown User");
		});
		System.out.println(finalUser3);

	}

	/*
	 * Throw an exception on absence of a value
	 */
	public User getUser(String userId) throws Exception {
		Optional<User> userEmpty = Optional.empty();
		return userEmpty.orElseThrow(() -> new Exception("User not found with userId " + userId));
	}
}
