package com.loggar.list.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FindMinMaxObject {
	@Test
	public void whenListIsOfPersonObjectThenMinCanBeDoneUsingCustomComparatorThroughLambda() {
		// given
		Person alex = new Person("Alex", 23);
		Person john = new Person("John", 40);
		Person peter = new Person("Peter", 32);
		List<Person> people = Arrays.asList(alex, john, peter);

		// then
		Person minByAge = people.stream().min(Comparator.comparing(Person::getAge)).orElseThrow(NoSuchElementException::new);

		Assert.assertEquals("Should be Alex", alex, minByAge);
	}
}

class Person {
	String name;
	Integer age;

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}