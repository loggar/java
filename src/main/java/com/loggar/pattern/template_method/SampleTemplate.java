package com.loggar.pattern.template_method;

public class SampleTemplate extends Template {
	@Override
	protected void insert() {
		System.out.println("INSERT with " + this.connection);
	}

	@Override
	protected void update() {
		System.out.println("UPDATE with " + this.connection);
	}

	@Override
	protected void delete() {
		System.out.println("UPDATE with " + this.connection);
	}
}
