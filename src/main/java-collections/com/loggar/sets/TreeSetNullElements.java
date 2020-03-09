package com.loggar.sets;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class TreeSetNullElements {
    // Before Java 7, it was possible to add null elements to an empty TreeSet.
    // However, that was considered a bug. Therefore, TreeSet no longer supports the addition of null.
    // When we add elements to the TreeSet, the elements get sorted according to their natural order or as specified by the comparator. Hence adding a null, when compared to existing elements, results in a NullPointerException since null cannot be compared to any value:

    @Test
    public void whenAddingNullToNonEmptyTreeSet_shouldThrowException() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");

        assertThrows(NullPointerException.class, () -> {
            treeSet.add(null);
        });
    }

    // Elements inserted into the TreeSet must either implement the Comparable interface or at least be accepted by the specified comparator.
    // All such elements must be mutually comparable, i.e. e1.compareTo(e2) or comparator.compare(e1, e2) mustn't throw a ClassCastException.

    class Element {
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    @Test
    public void whenUsingComparator_shouldSortAndInsertElements() {
        Comparator<Element> comparator = (ele1, ele2) -> {
            return ele1.getId()
                    .compareTo(ele2.getId());
        };
        Set<Element> treeSet = new TreeSet<>(comparator);
        Element ele1 = new Element();
        ele1.setId(100);
        Element ele2 = new Element();
        ele2.setId(200);

        treeSet.add(ele1);
        treeSet.add(ele2);

        System.out.println(treeSet);
    }
}
