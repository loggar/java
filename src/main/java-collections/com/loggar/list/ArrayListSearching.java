package com.loggar.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

public class ArrayListSearching {
    @Test
    public void searchFromArrayList() {
        List<String> list = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(Collectors.toCollection(ArrayList::new));

        List<String> stringsToSearch = new ArrayList<>(list);
        stringsToSearch.addAll(list);

        System.out.println(list);
        System.out.println(stringsToSearch);

        assertEquals(10, stringsToSearch.indexOf("a"));
        assertEquals(26, stringsToSearch.lastIndexOf("a"));
    }

    @Test
    public void searchingUnsortedList1() {
        // If you want to find all elements satisfying a predicate, you may filter collection using Java 8 Stream API using Predicate like this:

        List<String> list = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(Collectors.toCollection(ArrayList::new));

        List<String> stringsToSearch = new ArrayList<>(list);
        stringsToSearch.addAll(list);

        Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "c", "9"));

        List<String> result = stringsToSearch.stream()
                .filter(matchingStrings::contains)
                .collect(Collectors.toCollection(ArrayList::new));

        assertEquals(6, result.size());
    }

    @Test
    public void searchingUnsortedList2() {
        // It is also possible to use a for loop or an iterator:

        List<String> list = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(Collectors.toCollection(ArrayList::new));

        List<String> stringsToSearch = new ArrayList<>(list);
        stringsToSearch.addAll(list);

        Iterator<String> it = stringsToSearch.iterator();
        Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "c", "9"));

        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            String s = it.next();
            if (matchingStrings.contains(s)) {
                result.add(s);
            }
        }

        assertTrue(result.size() == 6);
    }

    @Test
    public void searchingSortedList() {
        // If you have a sorted array, then you may use a binary search algorithm which works faster than linear search:

        List<String> list = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(Collectors.toCollection(ArrayList::new));

        List<String> stringsToSearch = new ArrayList<>(list);
        stringsToSearch.addAll(list);

        List<String> copy = new ArrayList<>(stringsToSearch);
        Collections.sort(copy);
        int index = Collections.binarySearch(copy, "f");

        assertTrue(index == 30);
    }
}
