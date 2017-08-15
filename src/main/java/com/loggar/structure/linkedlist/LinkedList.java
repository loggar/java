package com.loggar.structure.linkedlist;

public interface LinkedList<T> {
	int size();
	int add(T data);
	int add(T data, int i);
	T get(int p);
}
