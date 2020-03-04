package com.loggar.iterators;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.junit.jupiter.api.Test;

public class IterateToListApacheCommons {
    Iterator<Integer> iterator = Arrays.asList(1, 2, 3)
            .iterator();

    @Test
    public void usingApacheCommonsCollections() {
        @SuppressWarnings("unchecked") List<Integer> actualList = IteratorUtils.toList(iterator);

        assertThat(actualList, containsInAnyOrder(1, 2, 3));
    }

}
