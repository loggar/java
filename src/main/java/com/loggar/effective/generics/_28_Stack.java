package com.loggar.effective.generics;

import java.util.Collection;

/**
 * Use bounded wildcards to increase API flexibility
 *
 */
public class _28_Stack<E> extends _26_Stack<E> {
	/*
	 * // pushAll method without wildcard type - deficient! public void
	 * pushAll(Iterable<E> src) { for (E e : src) push(e); }
	 */

	// Wildcard type for parameter that serves as an E producer
	public void pushAll(Iterable<? extends E> src) {
		for (E e : src)
			push(e);
	}

	/*
	 * // popAll method without wildcard type - deficient! public void
	 * popAll(Collection<E> dst) { while (!isEmpty()) dst.add(pop()); }
	 */

	// Wildcard type for parameter that serves as an E consumer
	public void popAll(Collection<? super E> dst) {
		while (!isEmpty())
			dst.add(pop());
	}

}
