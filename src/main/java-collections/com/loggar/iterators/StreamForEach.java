package com.loggar.iterators;

import java.util.Arrays;
import java.util.List;

public class StreamForEach {
    public void forEachTest() {
        List<String> countries = Arrays.asList("Germany", "Panama", "Australia");

        countries.stream()
                .forEach((c) -> System.out.println(c));

    }
}
