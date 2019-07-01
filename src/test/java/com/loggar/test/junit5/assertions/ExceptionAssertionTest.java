package com.loggar.test.junit5.assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Writing assertions for exceptions")
class ExceptionAssertionTest {

    @Test
    @DisplayName("Should throw the correct exception")
    void shouldThrowCorrectException() {
        assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException();
        });
    }

    @Test
    @DisplayName("Should throw an exception that has the correct message")
    void shouldThrowAnExceptionWithCorrectMessage() {
        final NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException("Hello World!");
        });
        assertEquals("Hello World!", thrown.getMessage());
    }

    @Test
    @DisplayName("Should not throw an exception")
    void shouldNotThrowException() {
        assertDoesNotThrow(() -> {
        });
    }

    @Test
    @DisplayName("Should not throw an exception")
    void shouldNotThrowException2() {
        String message = assertDoesNotThrow(() -> {
            return "Hello World!";
        });
        assertEquals("Hello World!", message);
    }
}
