package com.loggar.test.junit5.assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Write assertions for arrays")
class ArrayAssertionTest {

    @Nested
    @DisplayName("When arrays contain integers")
    class WhenArraysContainIntegers {

        final int[] ACTUAL = new int[] { 2, 5, 7 };
        final int[] EXPECTED = new int[] { 2, 5, 7 };

        @Test
        @DisplayName("Should contain the same integers")
        void shouldContainSameIntegers() {
            assertArrayEquals(EXPECTED, ACTUAL);
        }
    }
}