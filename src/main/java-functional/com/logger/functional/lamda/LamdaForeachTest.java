package com.logger.functional.lamda;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LamdaForeachTest {
	@Test
	public void test() {
		List<Integer> v = Arrays.asList(4,5,6,7,8,9);
		
		/*
		 * internal loops : the loop logic has alrealdy been contained in the List class.
		 */
		v.forEach(i->System.out.println(i)); // and lamda expression.
		
		/*
		 * 결국 Lamda Expression(->) 는 한번만 사용�?�는 inner class �?� 정�?�를 단순화 하는�?��? 있다
		 * Java Collection �?� forEach() 는 파�?�미터로 Consumer<T>로 선언 �?�어 있으며, forEach() 안�? 정�?��?� "->" 는 단순히 그 Consumer<T> �?�터페�?�스를 임시정�?� 하는 것�?�다. 
		 */
	}
	
}
