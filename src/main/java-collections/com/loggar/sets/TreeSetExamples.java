package com.loggar.sets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class TreeSetExamples {
    // It stores unique elements
    // It doesn't preserve the insertion order of the elements
    // It sorts the elements in ascending order
    // It's not thread-safe

    @SuppressWarnings("unused")
    public void instantiation() {
        Set<String> treeSet = new TreeSet<>();

        Set<String> treeSet2 = new TreeSet<>(Comparator.comparing(String::length));

        // Although TreeSet isn't thread-safe, it can be synchronized externally using the Collections.synchronizedSet() wrapper:
        Set<String> syncTreeSet = Collections.synchronizedSet(treeSet);
    }

    @Test
    public void whenAddingElement_shouldAddElement() {
        Set<String> treeSet = new TreeSet<>();

        assertTrue(treeSet.add("String Added"));
    }

    @Test
    public void whenCheckingForElement_shouldSearchForElement() {
        Set<String> treeSetContains = new TreeSet<>();
        treeSetContains.add("String Added");

        assertTrue(treeSetContains.contains("String Added"));
    }

    @Test
    public void whenRemovingElement_shouldRemoveElement() {
        Set<String> removeFromTreeSet = new TreeSet<>();
        removeFromTreeSet.add("String Added");

        assertTrue(removeFromTreeSet.remove("String Added"));
    }

    @Test
    public void whenClearingTreeSet_shouldClearTreeSet() {
        Set<String> clearTreeSet = new TreeSet<>();
        clearTreeSet.add("String Added");
        clearTreeSet.clear();

        assertTrue(clearTreeSet.isEmpty());
    }

    @Test
    public void whenCheckingTheSizeOfTreeSet_shouldReturnThesize() {
        Set<String> treeSetSize = new TreeSet<>();
        treeSetSize.add("String Added");

        assertEquals(1, treeSetSize.size());
    }

    @Test
    public void whenCheckingForEmptyTreeSet_shouldCheckForEmpty() {
        Set<String> emptyTreeSet = new TreeSet<>();

        assertTrue(emptyTreeSet.isEmpty());
    }

}
