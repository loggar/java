package com.loggar.collectors;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectorsJoining {
    List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

    @Test
    public void join1() {
        String result = givenList.stream()
                .collect(joining());

        Assertions.assertTrue(result.equals("abbcccdd"));
    }

    @Test
    public void join2() {
        String result = givenList.stream()
                .collect(joining(" "));

        Assertions.assertTrue(result.equals("a bb ccc dd"));
    }

    @Test
    public void join3() {
        String result = givenList.stream()
                .collect(joining(" ", "PRE-", "-POST"));

        System.out.println(result);

        Assertions.assertTrue(result.equals("PRE-a bb ccc dd-POST"));
    }
}
