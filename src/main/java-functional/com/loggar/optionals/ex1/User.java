package com.loggar.optionals.ex1;

import java.util.Optional;

public class User {
	String no;
	String name;
	String gender;

	public User(String no, String name) {
		this.no = no;
		this.name = name;
	}

	public User(String no, String name, String gender) {
		this.no = no;
		this.name = name;
		this.gender = gender;
	}

	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public Optional<String> getGenderOptional() {
		return Optional.ofNullable(this.gender);
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [no=").append(no).append(", name=").append(name).append(", gender=").append(gender).append("]");
		return builder.toString();
	}

}
