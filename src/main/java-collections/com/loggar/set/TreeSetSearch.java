package com.loggar.set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class TreeSetSearch {

    @Test
    public void whenCheckingFirstElement_shouldReturnFirstElement() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("First");

        assertEquals("First", treeSet.first());
    }

    @Test
    public void whenCheckingLastElement_shouldReturnLastElement() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Last");

        assertEquals("Last", treeSet.last());
    }

}
