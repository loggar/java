package com.loggar.list.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class IntersectionTwoLists {
    List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
    List<String> otherList = Arrays.asList("red", "green", "green", "yellow");

    @Test
    public void intersection() {
        Set<String> result = list.stream()
                .distinct()
                .filter(otherList::contains)
                .collect(Collectors.toSet());

        @SuppressWarnings({ "unchecked", "rawtypes" }) Set<String> commonElements = new HashSet(Arrays.asList("red", "green"));

        Assert.assertEquals(commonElements, result);
    }
}
