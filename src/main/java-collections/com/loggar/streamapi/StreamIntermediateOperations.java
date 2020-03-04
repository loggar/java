package com.loggar.streamapi;

import java.util.Arrays;
import java.util.List;

public class StreamIntermediateOperations {
    public static void main(String[] args) {
        // filter
        List<String> strings = Arrays.asList("Hollis", "", "HollisChuang", "H", "hollis");
        strings.stream().filter(string -> !string.isEmpty()).forEach(System.out::println);
        // Hollis, , HollisChuang, H, hollis

        // map
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().map(i -> i * i).forEach(System.out::println);
        // 9,4,4,9,49,9,25

        // limit/skip
        List<Integer> numbers2 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers2.stream().limit(4).forEach(System.out::println);
        // 3,2,2,3

        // sorted
        List<Integer> numbers3 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers3.stream().sorted().forEach(System.out::println);
        // 2,2,3,3,3,5,7

        // distinct
        List<Integer> numbers4 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers4.stream().distinct().forEach(System.out::println);
        // 3,2,7,5
    }
}
