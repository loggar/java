package com.loggar.list;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class ArrayListIterating {
    @Test
    public void previous() {
        List<Integer> list = new ArrayList<>(
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new))
        );

        ListIterator<Integer> it = list.listIterator(list.size());
        List<Integer> result = new ArrayList<>(list.size());
        while (it.hasPrevious()) {
            result.add(it.previous());
        }

        Collections.reverse(list);
        assertEquals(result, list);
    }

    @Test
    public void next() {
        List<Integer> list = new ArrayList<>(
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new))
        );

        ListIterator<Integer> it = list.listIterator();
        List<Integer> result = new ArrayList<>(list.size());
        while (it.hasNext()) {
            result.add(it.next());
        }

        assertEquals(result, list);
    }
}
