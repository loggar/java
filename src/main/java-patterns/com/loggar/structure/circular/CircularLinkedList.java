package com.loggar.structure.circular;

public class CircularLinkedList {
	private Node head = null;
	private Node tail = null;

	public boolean addNode(String name, int value) {
		if (!containsNode(name)) {
			Node newNode = new Node(new NodeValue(name, value));

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
		Node currentNode = head;

		if (head == null) {
			return false;
		} else {
			do {
				if (currentNode.value.getName().equals(name)) {
					return true;
				}
				currentNode = currentNode.nextNode;
			} while (currentNode != head);
			return false;
		}
	}

	public void deleteNode(String name) {
		Node currentNode = head;

		if (head != null) {
			if (currentNode.value.getName().equals(name)) {
				head = head.nextNode;
				tail.nextNode = head;
			} else {
				do {
					Node nextNode = currentNode.nextNode;
					if (nextNode.value.getName().equals(name)) {
						currentNode.nextNode = nextNode.nextNode;
						break;
					}
					currentNode = currentNode.nextNode;
				} while (currentNode != head);
			}
		}
	}

	public int size() {
		Node currentNode = head;
		int i = 0;
		if (head != null) {
			do {
				currentNode = currentNode.nextNode;
				i++;
			} while (currentNode != head);
		}
		return i;
	}

	public int traverse() {
		Node currentNode = head;
		int i = 0;
		if (head != null) {
			do {
				System.out.println(currentNode.value);
				currentNode = currentNode.nextNode;
				i++;
			} while (currentNode != head);
		}
		return i;
	}
}
