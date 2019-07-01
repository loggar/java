package com.loggar.test.junit5.assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Providing a Custom Error Message")
public class ProvidingCustomErrorMessage2 {
    private static final String KEY = "key";
    private static final String VALUE = "value";

    private Map<String, String> map;

    @BeforeEach
    void createAndInitializeMap() {
        map = new HashMap<>();
        map.put(KEY, VALUE);
    }

    @Test
    @DisplayName("Should contain the correct key")
    void shouldContainCorrectKey() {
        assertTrue(map.containsKey(KEY), () -> String.format("The map doesn't contain the key: %s", KEY));
    }
}
