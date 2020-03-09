package com.loggar.streamapi;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StreamApiTest {
    List<Integer> list = null;

    @Before
    public void set() {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            list.add(i);
    }

    // @Test
    public void test_1() {
        list.forEach(i -> System.out.println(i));

    }

    // @Test
    public void test_2() {
        /*
         * using Stream API : means Thread Safe.
         */
        list.stream().forEach(i -> System.out.println(i));
    }

    @Test
    public void test_3() {
        /*
         * works with creation threads automatically.
         */
        list.parallelStream().forEach(i -> System.out.println(i));
    }
}
