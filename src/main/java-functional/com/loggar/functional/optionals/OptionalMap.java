package com.loggar.functional.optionals;

import java.util.Optional;

public class OptionalMap {
	public static void main(String[] args) {
		User user = new User("2", "John Smith");
		user.setGender("male");
		Optional<User> optional = Optional.of(user);

		optional.map(User::getName).filter(name -> name.equalsIgnoreCase("John Smith")).ifPresent((u) -> {
			System.out.println("User is " + u);
		});

		User user3 = new User("3", "John Smith");
		user3.setGender(null);
		Optional<User> optional2 = Optional.of(user3);

		Optional<String> optionalGender = optional2.flatMap(User::getGenderOptional);
		System.out.println(optionalGender);
	}
}
