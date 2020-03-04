package com.loggar.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTerminateOperations {
    public static void main(String[] args) {
        // forEach
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        // count
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hollis666", "Hello", "HelloWorld", "Hollis");
        System.out.println(strings.stream().count());
        // 7

        // collect
        List<String> strings2 = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hollis666", "Hello", "HelloWorld", "Hollis");
        strings2 = strings2.stream().filter(string -> string.startsWith("Hollis")).collect(Collectors.toList());
        System.out.println(strings2);
        // Hollis, HollisChuang, Hollis666, Hollis
    }
}
