package com.loggar.test.junit5.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Writing assertions for Optional objects")
public class OptionalObjects {
    @Nested
    @DisplayName("When the optional is empty")
    class WhenOptionalIsEmpty {

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(Optional.empty()).isEmpty();
        }
    }

    @Nested
    @DisplayName("When the optional is not empty")
    class WhenOptionalIsNotEmpty {

        @Test
        @DisplayName("Should not be empty")
        void shouldNotBeEmpty() {
            assertThat(Optional.of(new Object())).isNotEmpty();
        }
    }

    @Nested
    @DisplayName("When the optional is not empty")
    class WhenOptionalIsNotEmpty2 {

        private final Object OBJECT = new Object();

        @Test
        @DisplayName("Should contain the correct object")
        void shouldContainCorrectObject() {
            assertThat(Optional.of(OBJECT)).contains(OBJECT);
        }
    }
}
