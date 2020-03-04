package com.loggar.iterators;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;



public class IterateToListGuava {
    Iterator<Integer> iterator = Arrays.asList(1, 2, 3)
            .iterator();

    @Test
    public void usingGuavaImmutable() {
        List<Integer> actualList = ImmutableList.copyOf(iterator);

        assertThat(actualList, containsInAnyOrder(1, 2, 3));
    }

    @Test
    public void usingGuavaMutable() {
        List<Integer> actualList = Lists.newArrayList(iterator);

        assertThat(actualList, containsInAnyOrder(1, 2, 3));
    }

}
