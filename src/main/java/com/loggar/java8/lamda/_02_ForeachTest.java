package com.loggar.java8.lamda;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class _02_ForeachTest {
	@Test
	public void test() {
		List<Integer> v = Arrays.asList(4,5,6,7,8,9);
		
		/*
		 * internal loops : the loop logic has alrealdy been contained in the List class.
		 */
		v.forEach(i->System.out.println(i)); // and lamda expression.
		
		/*
		 * 결국 Lamda Expression(->) 는 한번만 사용되는 inner class 의 정의를 단순화 하는데에 있다
		 * Java Collection 의 forEach() 는 파라미터로 Consumer<T>로 선언 되어 있으며, forEach() 안에 정의된 "->" 는 단순히 그 Consumer<T> 인터페이스를 임시정의 하는 것이다. 
		 */
	}
	
}
