package com.loggar.test.junit5.assertj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Writing assertions for lists")
class ListAssertionTest {

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
            assertThat(list).hasSize(2);
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
        @DisplayName("Should contain the correct elements in the given order")
        void shouldContainCorrectElementsInGivenOrder() {
            assertThat(list).containsExactly(first, second);
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
        @DisplayName("Should contain the correct elements in any order")
        void shouldContainCorrectElementsInAnyOrder() {
            assertThat(list).containsExactlyInAnyOrder(second, first);
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
        @DisplayName("Should contain the correct element once")
        void shouldContainCorrectElementOnce() {
            assertThat(list).containsOnlyOnce(first);
        }
    }

    @Nested
    @DisplayName("When we write assertions for elements")
    class WhenWeWriteAssertionsForElements5 {

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
            assertThat(list).doesNotContain(new Object());
        }
    }

    @Nested
    @DisplayName("When we compare two lists")
    class WhenWeCompareTwoLists {

        private final List<Integer> FIRST = Arrays.asList(1, 2, 3);
        private final List<Integer> SECOND = Arrays.asList(1, 2, 3);

        @Test
        @DisplayName("Should contain the same elements")
        void shouldContainSameElements() {
            assertThat(FIRST).isEqualTo(SECOND);
        }
    }
}
