package com.loggar.effective.instantiation;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Do not make a code (Collection or Array) that allocates dynamically its own memory.
 * This possibly cause problematic memory releasing bu GC.
 * Explicitly define dynamic size of object.
 * 
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
