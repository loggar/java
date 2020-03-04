package com.loggar.collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.collectingAndThen;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;

public class CollectorsToCollection {
    List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

    public static void main(String[] args) {
        CollectorsToCollection c = new CollectorsToCollection();
        c.toListExample();
        c.toSetExample();
        c.toMapExample1();
        c.toMapExample2();
        c.toMapExample3();
        c.collectingAndThenExample();
    }

    public void toListExample() {
        List<String> result = givenList.stream()
                .collect(toList());

        System.out.println(result);
    }

    public void toSetExample() {
        Set<String> result = givenList.stream()
                .collect(toSet());

        System.out.println(result);

        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> result2 = listWithDuplicates.stream()
                .collect(toSet());

        System.out.println(result2.size() == 4);
    }

    public void toMapExample1() {
        Map<String, Integer> result = givenList.stream()
                .collect(toMap(Function.identity(), String::length));

        System.out.println(result);
    }

    public void toMapExample2() {
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");

        try {
            Map<String, Integer> result = listWithDuplicates.stream()
                    .collect(toMap(Function.identity(), String::length));

            System.out.println(result);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void toMapExample3() {
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");

        Map<String, Integer> result = listWithDuplicates.stream()
                .collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));

        System.out.println(result);
    }

    public void collectingAndThenExample() {
        List<String> result = givenList.stream()
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));

        System.out.println(result);
    }
}
