package com.loggar.test.junit5.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpectExceptionsTest {

    @Test
    void testExpectedException() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("One");
        });
    }

    @Test
    void testExpectedExceptionWithSuperType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("One");
        });
    }

    // fail test example
    // @Test
    void testExpectedExceptionFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("1");
        });
    }
}
