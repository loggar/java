package com.loggar.test.junit5.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ArrayAssertionTest {
    @Nested
    @DisplayName("When arrays contain integers")
    class WhenArraysContainIntegers {

        final int[] ACTUAL = new int[] { 2, 5, 7 };
        final int[] EXPECTED = new int[] { 2, 5, 7 };

        @Test
        @DisplayName("Should contain the same integers")
        void shouldContainSameIntegers() {
            assertThat(ACTUAL, equalTo(EXPECTED));
        }
    }
}
