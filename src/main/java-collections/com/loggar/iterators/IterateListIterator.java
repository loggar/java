package com.loggar.iterators;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class IterateListIterator {
    public void listIteratorTest() {
        List<String> countries = Arrays.asList("Germany", "Panama", "Australia");

        ListIterator<String> listIterator = countries.listIterator();

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
