package com.loggar.arrays;

import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortArrayObject {
	Employee[] employees;
	Employee[] employeesSorted;
	Employee[] employeesSortedByAge;

	int[] toSort;
	int[] sortedInts;

	@BeforeEach
	public void initVariables() {
		employees = new Employee[] { new Employee("John", 23, 5000), new Employee("Steve", 26, 6000), new Employee("Frank", 33, 7000), new Employee("Earl", 43, 10000), new Employee("Jessica", 23, 4000), new Employee("Pearl", 33, 6000) };
		employeesSorted = new Employee[] { new Employee("Earl", 43, 10000), new Employee("Frank", 33, 70000), new Employee("Jessica", 23, 4000), new Employee("John", 23, 5000), new Employee("Pearl", 33, 4000), new Employee("Steve", 26, 6000) };
		employeesSortedByAge = new Employee[] { new Employee("John", 23, 5000), new Employee("Jessica", 23, 4000), new Employee("Steve", 26, 6000), new Employee("Frank", 33, 70000), new Employee("Pearl", 33, 4000), new Employee("Earl", 43, 10000) };

		toSort = new int[] { 5, 1, 89, 255, 7, 88, 200, 123, 66 };
		sortedInts = new int[] { 1, 5, 7, 66, 88, 89, 123, 200, 255 };
	}

	@Test
	public void givenEmpArray_SortEmpArray_thenSortedArrayinNaturalOrder() {
		Arrays.sort(employees);

		Assert.assertTrue(Arrays.equals(employees, employeesSorted));
	}

	@Test
	public void givenIntegerArray_whenUsingSort_thenSortedArray() {
		Integer[] integers = ArrayUtils.toObject(toSort);
		Arrays.sort(integers, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		Assert.assertTrue(Arrays.equals(integers, ArrayUtils.toObject(sortedInts)));
	}

	@Test
	public void givenEmpArray_SortEmpArray_thenSortedArrayBySalary() {
		Arrays.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o1.getSalary() - o2.getSalary());
			}
		});

		// Assert.assertTrue(Arrays.equals(employees, employeesSortedBySalary));
	}

	@Test
	public void givenArray_whenUsingSortWithLambdas_thenSortedArray() {
		Integer[] integersToSort = ArrayUtils.toObject(toSort);
		Arrays.sort(integersToSort, (a, b) -> {
			return a - b;
		});

		Assert.assertTrue(Arrays.equals(integersToSort, ArrayUtils.toObject(sortedInts)));
	}

}

class Employee implements Comparable<Object> {
	private String name;
	private int age;
	private double salary;

	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public boolean equals(Object obj) {
		return ((Employee) obj).getName().equals(getName());
	}

	@Override
	public int compareTo(Object o) {
		Employee e = (Employee) o;
		return getName().compareTo(e.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}