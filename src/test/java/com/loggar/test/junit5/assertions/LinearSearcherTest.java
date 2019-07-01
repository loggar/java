package com.loggar.test.junit5.assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LinearSearcherTest {
    private static LinearSearcher searcher;

    // before
    @BeforeAll
    public static void setup() {
        int[] array = { 2, 3, 4, 10, 40 };
        searcher = new LinearSearcher(array);
    }

    // Actual test methods
    @Test
    public void getPosition() {
        int result = searcher.getPositionOfNumber(10);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void noSuchNumber() {
        int result = searcher.getPositionOfNumber(55);
        Assertions.assertEquals(-1, result);
    }

    // after
    @AfterAll
    public static void finish() {
        System.out.println("Tests are finished!");
    }
}
