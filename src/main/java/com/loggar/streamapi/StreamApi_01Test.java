package com.loggar.streamapi;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class StreamApi_01Test {
	List<Integer> list = null;
	
	@Before
	public void set() {
		list = new ArrayList<>();
		for(int i=0; i<100; i++) list.add(i);
	}
	
//	@Test
	public void test_1() {
		list.forEach(i -> System.out.println(i));
		
	}
	
//	@Test
	public void test_2() {
		/*
		 * using Stream API : means Thread Safe.
		 */
		list.stream().forEach(i -> System.out.println(i));
	}
	
	@Test
	public void test_3() {
		/*
		 * works with creation threads automatically.
		 */
		list.parallelStream().forEach(i -> System.out.println(i));
	}
	
	/*
	 * stream 은 한번만 흘러가는 객체이다. 모두 흘려보내면 다시 사용 할 수 없다.
	 * Hadoop 등의 대용량 데이터의 사용이 고려되어 다음의 인터페이스를 Lamda Expression 으로 구현 할 수 있다.
	 * 
	 * [intermediate method] 스트림이 모두 흐른뒤 동작한다.
	 * filter()
	 * map()
	 * orElse(o) : filter 된 객체가 전혀 없는경우를 대비한 메소드.
	 * 
	 * [terminate method] 즉시 수행되다
	 * findFirst()
	 * forEach()
	 * 
	 * streamapi 에 대해 자세한 document 참고 할 것.
	 * 
	 */
}
