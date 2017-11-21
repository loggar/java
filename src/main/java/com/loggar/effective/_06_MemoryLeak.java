package com.loggar.effective;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 스스로 필드의 메모리를 동적으로 할당하고 있는 코드가 있다면(배열이나 Collection 의 크기 변경), 해당 클래스의 인스턴스는 GC 에 의해 정상적으로 메모리 해제되지 않을 가능성이 높다.
 * GC 가 메모리 해제여부를 판단 할 수있도록 동적메모리 할당되는 필드의 종료를 명시하자.
 * @author loggar.lee
 *
 */
public class _06_MemoryLeak {
	static class Stack {
		private Object[] elements;
		private int size;
		private static final int DEFAULT_INITIAL_CAPACITY = 16;
		
		public Stack() {
			elements = new Object[DEFAULT_INITIAL_CAPACITY];
		}
		
		private void ensureCapacity() {
			if(elements.length == size) elements = Arrays.copyOf(elements, 2*size + 1);
		}
		
		public void push(Object e) {
			ensureCapacity();
			elements[size++] = e;
		}
		
		public Object pop() {
			if(size == 0) throw new EmptyStackException();
			Object e = elements[--size];
			
			elements[size] = null; // Eliminate obsolete reference
			
			return e;
		}
		
	}
}
