package com.loggar.test.junit5.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

public class MapAssertionTest1 {
    private static final String KEY = "key";
    private static final String VALUE = "value";

    private Map<String, String> map;

    @BeforeEach
    void createAndInitializeMap() {
        map = new HashMap<>();
        map.put(KEY, VALUE);
    }

    @Nested
    @DisplayName("When we check if the map contains the given key")
    class WhenWeCheckIfMapContainsGivenKey {

        @Test
        @DisplayName("Should contain the correct key")
        void shouldContainCorrectKey() {
            assertThat(map.containsKey(KEY), equalTo(true));
        }
    }

    @Nested
    @DisplayName("When we check if the map contains the correct value")
    class WhenWeCheckIfMapContainsCorrectValue {

        @Test
        @DisplayName("Should contain the correct value")
        void shouldContainCorrectValue() {
            assertThat(map.containsValue(VALUE), equalTo(true));
        }
    }
    
}
