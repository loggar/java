package com.loggar.structure.circular;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CircularLinkedListTest {
	private static CircularLinkedList cll;
	private static CircularLinkedList c2;

	@BeforeAll
	public static void setup() {
		cll = new CircularLinkedList();

		assertTrue(cll.addNode("A", 13));

		assertTrue(cll.addNode("B", 7));
		assertTrue(cll.addNode("C", 24));
		assertTrue(cll.addNode("D", 1));
		assertTrue(cll.addNode("E", 8));
		assertFalse(cll.addNode("C", 8));
		assertTrue(cll.addNode("F", 37));
		assertFalse(cll.addNode("D", 8));
		assertTrue(cll.addNode("G", 46));

		c2 = new CircularLinkedList();

		assertTrue(c2.addNode("A", 13));
		assertTrue(c2.addNode("B", 7));
		assertTrue(c2.addNode("C", 24));
		assertTrue(c2.addNode("D", 1));
		assertTrue(c2.addNode("E", 8));
		assertFalse(c2.addNode("C", 8));
		assertTrue(c2.addNode("F", 37));
		assertFalse(c2.addNode("D", 8));
		assertTrue(c2.addNode("G", 46));
	}

	@Test
	public void givenACircularLinkedList_WhenAddingElements_ThenListContainsThoseElements() {
		assertTrue(cll.containsNode("A"));
		assertTrue(cll.containsNode("G"));
	}

	@Test
	public void givenACircularLinkedList_WhenLookingForNonExistingElement_ThenReturnsFalse() {
		assertFalse(cll.containsNode("Z"));
	}

	@Test
	public void givenACircularLinkedList_WhenDeletingElements_ThenListDoesNotContainThoseElements() {
		assertTrue(cll.containsNode("C"));
		cll.deleteNode("C");
		assertFalse(cll.containsNode("C"));

		assertTrue(cll.containsNode("D"));
		cll.deleteNode("D");
		assertFalse(cll.containsNode("D"));

		assertTrue(cll.containsNode("E"));
		cll.deleteNode("E");
		assertFalse(cll.containsNode("E"));

	}

	@Test
	public void givenACircularLinkedList_WhenLookingForSize_ThenReturnsNumberGreaterThanZero() {
		assertTrue(c2.size() == 7);
	}

	@Test
	public void givenACircularLinkedList_WhenTraverseTheList_ThenReturnsSize() {
		assertTrue(c2.traverse() == 7);
	}

	@Test
	public void givenACircularLinkedList_WhenTraverseCircularly_ThenReturnsNode() {
		assertTrue(c2.current().o.getName().equals("A"));
		assertTrue(c2.current().o.getName().equals("A"));
		assertTrue(c2.current().o.getName().equals("A"));
		assertTrue(c2.next().o.getName().equals("B"));
		assertTrue(c2.next().o.getName().equals("C"));
		assertTrue(c2.next().o.getName().equals("D"));
		assertTrue(c2.current().o.getName().equals("D"));
		assertTrue(c2.current().o.getName().equals("D"));
		assertTrue(c2.next().o.getName().equals("E"));
		assertTrue(c2.next().o.getName().equals("F"));
		assertTrue(c2.next().o.getName().equals("G"));
		assertTrue(c2.next().o.getName().equals("A"));
		assertTrue(c2.next().o.getName().equals("B"));
		assertTrue(c2.next().o.getName().equals("C"));
		assertTrue(c2.next().o.getName().equals("D"));
		assertTrue(c2.next().o.getName().equals("E"));
		assertTrue(c2.current().o.getName().equals("E"));
		assertTrue(c2.current().o.getName().equals("E"));
	}
}
