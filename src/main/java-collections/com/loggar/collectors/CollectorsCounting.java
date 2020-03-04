package com.loggar.collectors;

import static java.util.stream.Collectors.counting;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectorsCounting {
    List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

    @Test
    public void count() {
        Long result = givenList.stream()
                .collect(counting());

        Assertions.assertTrue(result == 4);
    }

}
