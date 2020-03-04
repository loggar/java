package com.loggar.list.assign;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

public class ListAssignment {
    @Test
    public void isEmpry() {
        List<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void initCapacity() throws Exception {
        int initSize = 20;
        List<String> list = new ArrayList<>(initSize);
        System.out.println(list.size());
        assertTrue(list.size() == 0);
        assertTrue(list.isEmpty());
        assertTrue(ArrayListCapacity.get((ArrayList<String>) list) == initSize);
    }
    
    @Test
    public void initFromCollection() {
        Collection<Integer> numbers = IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.toSet());

        List<Integer> list = new ArrayList<>(numbers);
        assertEquals(10, list.size());
        assertTrue(numbers.containsAll(list));
    }

    @Test
    public void add1() {
        List<Long> list = new ArrayList<>();

        list.add(1L);
        list.add(2L);
        list.add(1, 3L);

        assertEquals(Arrays.asList(1L, 3L, 2L), list);
    }

    @Test
    public void add2() {
        List<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        LongStream.range(4, 10)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(ArrayList::new), ys -> list.addAll(0, ys)));
        assertEquals(Arrays.asList(4L, 5L, 6L, 7L, 8L, 9L, 1L, 2L, 3L), list);
    }

}
