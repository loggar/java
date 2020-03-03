package com.loggar.collectors;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

public class CollectorsGuava {
    @Test
    public void whenCollectToImmutableList_thenSuccess() {
        List<Integer> list = IntStream.range(0, 9)
                .boxed()
                .collect(ImmutableList.toImmutableList());

        System.out.println(list);

        Assertions.assertTrue(
                list.getClass()
                        .toString()
                        .equals("class com.google.common.collect.RegularImmutableList")
        );
    }
}
