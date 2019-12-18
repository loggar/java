package com.loggar.optionals;

import java.util.Optional;

public class OptionalFilter {
	public static void main(String[] args) {
		User user = new User("2", "John Smith");
		user.setGender("male");
		Optional<User> optional = Optional.of(user);

		if (user != null && user.getGender().equalsIgnoreCase("MALE")) {
			System.out.println(user);
		}

		optional.filter(u -> u.getGender().equalsIgnoreCase("MALE")).ifPresent((u) -> {
			System.out.println(u);
		});
	}
}
