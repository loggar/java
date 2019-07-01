package com.loggar.test.junit5.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;

import java.util.Arrays;
import java.util.List;

public class ListAssertionTest {
    @Nested
    @DisplayName("When we write assertions for elements")
    class WhenWeWriteAssertionsForElements {

        private Object first;
        private Object second;

        private List<Object> list;

        @BeforeEach
        void createAndInitializeList() {
            first = new Object();
            second = new Object();

            list = Arrays.asList(first, second);
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertThat(list.size(), equalTo(2));
        }
    }

    @Nested
    @DisplayName("When we write assertions for elements")
    class WhenWeWriteAssertionsForElements2 {

        private Object first;
        private Object second;

        private List<Object> list;

        @BeforeEach
        void createAndInitializeList() {
            first = new Object();
            second = new Object();

            list = Arrays.asList(first, second);
        }

        @Test
        @DisplayName("Should contain a correct element")
        void shouldContainCorrectElement() {
            assertThat(list, hasItem(first));
        }
    }

    @Nested
    @DisplayName("When we write assertions for elements")
    class WhenWeWriteAssertionsForElements3 {

        private Object first;
        private Object second;

        private List<Object> list;

        @BeforeEach
        void createAndInitializeList() {
            first = new Object();
            second = new Object();

            list = Arrays.asList(first, second);
        }

        @Test
        @DisplayName("Should contain the correct elements in the given order")
        void shouldContainCorrectElementsInGivenOrder() {
            assertThat(list, hasItems(first, second));
        }
    }

    @Nested
    @DisplayName("When we write assertions for elements")
    class WhenWeWriteAssertionsForElements4 {

        private Object first;
        private Object second;

        private List<Object> list;

        @BeforeEach
        void createAndInitializeList() {
            first = new Object();
            second = new Object();

            list = Arrays.asList(first, second);
        }

        @Test
        @DisplayName("Should not contain an incorrect element")
        void shouldNotContainIncorrectElement() {
            assertThat(list, not(hasItem(new Object())));
        }
    }

    @Nested
    @DisplayName("When we compare two lists")
    class WhenWeCompareTwoLists {

        private final List<Integer> ACTUAL = Arrays.asList(1, 2, 3);
        private final List<Integer> EXPECTED = Arrays.asList(1, 2, 3);

        @Test
        @DisplayName("Should contain the same elements")
        void shouldContainSameElements() {
            assertThat(ACTUAL, equalTo(EXPECTED));
        }
    }
}
