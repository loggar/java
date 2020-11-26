package com.loggar.structure.circular;

class Node {
	CounterObject o;
	Node nextNode;

	public Node(String name, int v) {
		this.o = new CounterObject(name, v);
	}
}

public class CircularLinkedList {
	private Node head = null;
	private Node tail = null;
	private Node currentNode = null;

	public Node current() {
		if (currentNode == null) {
			currentNode = head;
		}
		System.out.println("current: " + currentNode.o.getName());
		return currentNode;
	}

	public Node next() {
		if (currentNode != null) {
			currentNode = currentNode.nextNode;
		}
		return current();
	}

	public boolean addNode(String name, int value) {
		if (!containsNode(name)) {
			Node newNode = new Node(name, value);

			if (head == null) {
				head = newNode;
			} else {
				tail.nextNode = newNode;
			}

			tail = newNode;
			tail.nextNode = head;
			return true;
		} else {
			return false;
		}
	}

	public boolean containsNode(String name) {
		Node tmpNode = head;

		if (head == null) {
			return false;
		} else {
			do {
				if (tmpNode.o.getName().equals(name)) {
					return true;
				}
				tmpNode = tmpNode.nextNode;
			} while (tmpNode != head);
			return false;
		}
	}

	public void deleteNode(String name) {
		Node tmpNode = head;

		if (head != null) {
			if (tmpNode.o.getName().equals(name)) {
				head = head.nextNode;
				tail.nextNode = head;
			} else {
				do {
					Node nextNode = tmpNode.nextNode;
					if (nextNode.o.getName().equals(name)) {
						tmpNode.nextNode = nextNode.nextNode;
						break;
					}
					tmpNode = tmpNode.nextNode;
				} while (tmpNode != head);
			}
		}
	}

	public int size() {
		Node tmpNode = head;
		int i = 0;
		if (head != null) {
			do {
				tmpNode = tmpNode.nextNode;
				i++;
			} while (tmpNode != head);
		}
		return i;
	}

	public int traverse() {
		Node tmpNode = head;
		int i = 0;
		if (head != null) {
			do {
				System.out.println(tmpNode.o);
				tmpNode = tmpNode.nextNode;
				i++;
			} while (tmpNode != head);
		}
		return i;
	}
}
