package com.loggar.iterators;

import java.util.Arrays;
import java.util.List;

public class IterableForEach {
    public void forEachTest() {
        List<String> countries = Arrays.asList("Germany", "Panama", "Australia");

        countries.forEach(System.out::println);
    }
}
