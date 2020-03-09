package com.loggar.sets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class TreeSetSubSet {

    @Test
    public void whenUsingSubSet_shouldReturnSubSetElements() {
        SortedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> expectedSet = new TreeSet<>();
        expectedSet.add(2);
        expectedSet.add(3);
        expectedSet.add(4);
        expectedSet.add(5);

        Set<Integer> subSet = treeSet.subSet(2, 6);

        assertEquals(expectedSet, subSet);
    }

    @Test
    public void whenUsingHeadSet_shouldReturnHeadSetElements() {
        SortedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> subSet = treeSet.headSet(6);

        assertEquals(subSet, treeSet.subSet(1, 6));
    }

    @Test
    public void whenUsingTailSet_shouldReturnTailSetElements() {
        NavigableSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> subSet = treeSet.tailSet(3);

        assertEquals(subSet, treeSet.subSet(3, true, 6, true));
    }
}
