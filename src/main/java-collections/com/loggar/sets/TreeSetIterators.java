package com.loggar.sets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class TreeSetIterators {

    @Test
    public void whenIteratingTreeSet_shouldIterateTreeSetInAscendingOrder() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test
    public void whenIteratingTreeSet_shouldIterateTreeSetInDescendingOrder() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.descendingIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test
    public void whenModifyingTreeSetWhileIterating_shouldThrowException() {
        // The Iterator throws a ConcurrentModificationException if the set is modified at any time after the iterator is created in any way except through the iterator's remove() method.

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();

        assertThrows(ConcurrentModificationException.class, () -> {
            while (itr.hasNext()) {
                itr.next();
                treeSet.remove("Second");
            }
        });
    }

    @Test
    public void whenRemovingElementUsingIterator_shouldRemoveElement() {
        // Alternatively, if we had used the iterator's remove method, then we wouldn't have encountered the exception:

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            if (element.equals("Second")) itr.remove();
        }

        assertEquals(2, treeSet.size());

        // There's no guarantee on the fail-fast behavior of an iterator as it's impossible to make any hard guarantees in the presence of unsynchronized concurrent modification.
    }
}
