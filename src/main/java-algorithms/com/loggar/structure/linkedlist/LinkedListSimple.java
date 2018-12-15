package com.loggar.structure.linkedlist;

public class LinkedListSimple<T> implements LinkedList<T> {
	class Node {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}

		boolean hasNext() {
			if (this.next == null) return false;
			else return true;
		}
	}

	private Node header;

	public LinkedListSimple() {
		header = new Node(null);
		header.next = null;
	}

	public int size() {
		Node tmp = this.header;

		int x = 0;
		while (tmp.hasNext()) {
			tmp = tmp.next;
			x++;
		}

		return x;
	}

	public int add(T data, int i) {
		if (i < 1) return -1;

		Node tmp = header;
		int x = 0;

		for (; x < i - 1 && tmp.hasNext(); x++) {
			tmp = tmp.next;
		}

		Node newNode = new Node(data);

		Node tmp2 = tmp.next;
		tmp.next = newNode;
		newNode.next = tmp2;
		return x;
	}

	public int add(T data) {
		return add(data, size() + 1);
	}

	public T get(int i) {
		if (i < 1) return null;

		Node tmp = header;
		int x = 0;

		for (; x < i && tmp.hasNext(); x++) {
			tmp = tmp.next;
		}

		return tmp.data;
	}

	public T remove(int i) {
		if (i < 1 && i > size()) return null;

		Node tmp = header;
		Node tmp_previous = tmp;
		int x = 0;

		for (; x < i && tmp.hasNext(); x++) {
			tmp_previous = tmp;
			tmp = tmp.next;
		}

		tmp_previous.next = tmp.next;

		return tmp.data;

	}
}
