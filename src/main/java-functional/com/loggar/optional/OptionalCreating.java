package com.loggar.optional;

import java.util.Optional;

public class OptionalCreating {
	public static void main(String[] args) {
		// Create an empty Optional
		Optional<User> user = Optional.empty();

		// Create an Optional with a non-null value
		User user1 = new User("1", "John Smith");
		Optional<User> userOptional = Optional.of(user1);

		Optional<User> userOptional2 = Optional.of(new User("2", "John Smith"));

		System.out.println(user);
		System.out.println(userOptional);
		System.out.println(userOptional2);

		// Create an Optional with a value which may or may not be null
		Optional<Optional<User>> userOptional3 = Optional.ofNullable(user);

		System.out.println(userOptional3);
	}
}
