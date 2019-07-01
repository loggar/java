package com.loggar.test.junit5.assertj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Writing assertions for maps")
class MapAssertionTest {

    private static final String INCORRECT_KEY = "incorrectKey";
    private static final String KEY = "key";
    private static final String VALUE = "value";

    private Map<String, String> map;

    @BeforeEach
    void createAndInitializeMap() {
        map = new HashMap<>();
        map.put(KEY, VALUE);
    }

    @Nested
    @DisplayName("When we verify that the map contains the given key")
    class WhenWeVerifyThatMapContainsGivenKey {

        @Test
        @DisplayName("Should contain the correct key")
        void shouldContainCorrectKey() {
            assertThat(map).containsKey(KEY);
        }
    }

    @Nested
    @DisplayName("When we verify that the map doesn't contain the given key")
    class WhenWeVerifyThatMapDoesNotContainGivenKey {

        @Test
        @DisplayName("Should not contain the incorrect key")
        void shouldNotContainIncorrectKey() {
            assertThat(map).doesNotContainKey(INCORRECT_KEY);
        }
    }

    @Nested
    @DisplayName("When we verify that the map contains the given entry")
    class WhenWeVerifyThatMapContainsGivenEntry {

        @Test
        @DisplayName("Should contain the given entry")
        void shouldContainGivenEntry() {
            assertThat(map).containsEntry(KEY, VALUE);
        }
    }

    @Nested
    @DisplayName("When we verify that the map doesn't contain the given entry")
    class WhenWeVerifyThatMapDoesNotContainGivenEntry {

        @Test
        @DisplayName("Should not contain the given entry")
        void shouldContainGivenEntry() {
            assertThat(map).doesNotContainEntry(INCORRECT_KEY, VALUE);
        }
    }

}
