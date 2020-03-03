package com.loggar.optionals;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

public class OptionalFlatMapTest {
	@Test
	public void givenOptional_whenFlatMapWorks_thenCorrect2() {
		Person person = new Person("john", 26);
		Optional<Person> personOptional = Optional.of(person);

		Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);
		Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
		String name1 = nameOptional.orElse("");
		assertEquals("john", name1);

		String name = personOptional.flatMap(Person::getName).orElse("");
		assertEquals("john", name);
	}

	public class Person {
		private String name;
		private int age;
		private String password;

		public Optional<String> getName() {
			return Optional.ofNullable(name);
		}

		public Optional<Integer> getAge() {
			return Optional.ofNullable(age);
		}

		public Optional<String> getPassword() {
			return Optional.ofNullable(password);
		}

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}
}
