package com.loggar.java8.interfaces;

import org.junit.Test;

public class StaticMethodInInterface {
	interface A {
		static void show() {
			System.out.println("show");
		}
	}
	
	/*	
	 * now we can define a static method in interface.
	 * we can invoke the method without instance.
	 */
	@Test
	public void test() {
		A.show();
	}
}
