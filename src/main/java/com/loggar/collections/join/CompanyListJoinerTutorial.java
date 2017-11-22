package com.loggar.collections.join;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyListJoinerTutorial {
	public static void main(String[] args) {
		List<SampleCompany> list = Arrays.asList(new SampleCompany("ABC LLC", "NYC", 5),
				new SampleCompany("Twitter Inc", "San Francisco", 5),
				new SampleCompany("Facebook Inc", "Mountain View", 5));

		// stream() returns a sequential Stream with this collection as its source.
		// map() returns a stream consisting of the results of applying the given
		// function to the elements of
		// this stream.
		String name = list.stream().map(company -> company.getCompanyName()).collect(Collectors.joining(" : ", "<< ", " >>"));
		log("Company Name Joining: \t" + name);

		// joining() returns a Collector that concatenates the input elements, separated
		// by the specified
		// delimiter, with the specified prefix and suffix, in encounter order.
		String address = list.stream().map(company -> company.getCompanyAddress())
				.collect(Collectors.joining(", ", "{{ ", " }}"));
		log("Address Joining: \t" + address);

	}

	private static void log(String data) {
		System.out.println(data);

	}
}

class SampleCompany {
	String companyName;
	String companyAddress;
	int companyEmployee;

	public SampleCompany(String name, String address, int employee) {
		this.companyName = name;
		this.companyAddress = address;
		this.companyEmployee = employee;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public int getCompanyEmployee() {
		return companyEmployee;
	}

	public void setCompanyEmployee(int companyEmployee) {
		this.companyEmployee = companyEmployee;
	}
}
