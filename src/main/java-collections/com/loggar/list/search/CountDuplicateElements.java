package com.loggar.list.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

public class CountDuplicateElements {
    private List<String> INPUT_LIST = Lists.list("expect1", "expect2", "expect2", "expect3", "expect3", "expect3", "expect4", "expect4", "expect4", "expect4");

    private void verifyResult(Map<String, Long> resultMap) {
        assertThat(resultMap).isNotEmpty()
                .hasSize(4)
                .containsExactly(entry("expect1", 1L), entry("expect2", 2L), entry("expect3", 3L), entry("expect4", 4L));
    }

    public <T> Map<T, Long> countByClassicalLoop(List<T> inputList) {
        Map<T, Long> resultMap = new HashMap<>();
        for (T element : inputList) {
            if (resultMap.containsKey(element)) {
                resultMap.put(element, resultMap.get(element) + 1L);
            } else {
                resultMap.put(element, 1L);
            }
        }
        return resultMap;
    }

    @Test
    public void countDuplicatesTest1() {
        verifyResult(countByClassicalLoop(INPUT_LIST));
    }

    // If we don't need the pre-Java 8 compatibility, we can simplify our method further:
    public <T> Map<T, Long> countByForEachLoopWithGetOrDefault(List<T> inputList) {
        Map<T, Long> resultMap = new HashMap<>();
        inputList.forEach(e -> resultMap.put(e, resultMap.getOrDefault(e, 0L) + 1L));
        return resultMap;
    }

    @Test
    public void countDuplicatesTest2() {
        verifyResult(countByForEachLoopWithGetOrDefault(INPUT_LIST));
    }

    // In Java 8, the handy compute() method has been introduced to the Map interface. We can make use of this method as well:
    public <T> Map<T, Long> countByForEachLoopWithMapCompute(List<T> inputList) {
        Map<T, Long> resultMap = new HashMap<>();
        inputList.forEach(e -> resultMap.compute(e, (k, v) -> v == null ? 1L : v + 1L));
        return resultMap;
    }
    // Notice (k, v) -> v == null ? 1L : v + 1L is the remapping function that implements the BiFunction<T, Long, Long> interface. For a given key, it either returns its current value incremented by one (if the key is already present in the map) or returns the default value of one.
    // To make the code more readable, we could extract the remapping function to its variable or even take it as the input parameter for the countByForEachLoopWithMapCompute.

    @Test
    public void countDuplicatesTest3() {
        verifyResult(countByForEachLoopWithMapCompute(INPUT_LIST));
    }

    // When using Map.compute(), we must handle the null values explicitly – for instance, if a mapping for a given key doesn't exist. This is why we've implemented a null check in our remapping function. This, however, doesn't look pretty.
    // Let's clean up our code further with the help of Map.merge() method:
    public <T> Map<T, Long> countByForEachLoopWithMapMerge(List<T> inputList) {
        Map<T, Long> resultMap = new HashMap<>();
        inputList.forEach(e -> resultMap.merge(e, 1L, Long::sum));
        return resultMap;
    }
    // Let's explain how merge() works. If the mapping for a given key doesn't exist, or its value is null, it associates the key with the provided value. Otherwise, it calculates a new value using the remapping function and updates the mapping accordingly.
    // Notice that this time we used Long::sum as the BiFunction<T, Long, Long> interface implementation.

    @Test
    public void countDuplicatesTest4() {
        verifyResult(countByForEachLoopWithMapMerge(INPUT_LIST));
    }

    // Stream API Collectors.groupingBy() and Collectors.counting()
    // Except for the toMap(), our problem can be solved by two other collectors, groupingBy() and counting():
    public <T> Map<T, Long> countByStreamGroupBy(List<T> inputList) {
        return inputList.stream()
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
    }

    @Test
    public void countDuplicatesTest5() {
        verifyResult(countByStreamGroupBy(INPUT_LIST));
    }
}
