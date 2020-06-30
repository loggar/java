package com.loggar.structure.circular;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CircularLinkedListTest {
	private static CircularLinkedList cll;

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
		assertTrue(cll.size() > 0);
	}

	@Test
	public void givenACircularLinkedList_WhenTraverseTheList_ThenReturnsSize() {
		assertTrue(cll.traverse() > 0);
	}
}
