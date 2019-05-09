package com.loggar.statements;

public class Overloading {
	class Form<T> {

	}

	void a(Form<Number> f) {

	}

	void a(Form<Number> f, String s) {

	}

	void write(Form<?> xxxx) {

	}

	void write(Form<?> xxxx, String yyyy) {

	}
}
