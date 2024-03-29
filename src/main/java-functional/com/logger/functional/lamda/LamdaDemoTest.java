package com.logger.functional.lamda;

import org.junit.Test;

interface A {
	void show();
}

interface B {
	void show(int i);
}

/*
 * some kind of implemented classes of interfaces (has a single behavior) used as temporalrily or instantely.
 */
public class LamdaDemoTest {
	@Test
	public void demo_1() {
		A obj = new A() {
			public void show() {
				System.out.println("show");
			}
		};
		
		obj.show();
	}
	
	@Test
	public void demo_2() {
		A obj = () -> {
			System.out.println("show");
		};
		
		obj.show();
	}
	
	@Test
	public void demo_3() {
		B obj = (int i) -> {
			System.out.println(i);
		};
		
		obj.show(3);
	}
	
	@Test
	public void demo_4() {
		B obj = (int i) -> System.out.println(i);
		
		obj.show(4);
	}
}
