package com.loggar.iterators;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;

public class IterateToList {
    Iterator<Integer> iterator = Arrays.asList(1, 2, 3)
            .iterator();

    @Test
    public void usingWhileLoop() {
        List<Integer> actualList = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            actualList.add(iterator.next());
        }

        assertThat(actualList, containsInAnyOrder(1, 2, 3));
    }

    @Test
    public void usingJava8forEachRemaining() {
        List<Integer> actualList = new ArrayList<Integer>();
        iterator.forEachRemaining(actualList::add);

        assertThat(actualList, containsInAnyOrder(1, 2, 3));
    }

    @Test
    public void usingJava8StreamsAPI() {
        Iterable<Integer> iterable = () -> iterator;

        List<Integer> actualList = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        assertThat(actualList, containsInAnyOrder(1, 2, 3));
    }

}
