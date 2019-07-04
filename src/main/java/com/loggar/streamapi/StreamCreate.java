package com.loggar.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreate {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        Stream<String> stream = strings.stream();

        Stream<String> stream2 = Stream.of("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");

        stream.close();
        stream2.close();
    }
}
