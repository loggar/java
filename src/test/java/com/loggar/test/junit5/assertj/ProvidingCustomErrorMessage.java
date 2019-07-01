package com.loggar.test.junit5.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Provide a custom error message")
public class ProvidingCustomErrorMessage {
    @Nested
    @DisplayName("When we provide only the description")
    class WhenWeProvideOnlyDescription {

        @Test
        @DisplayName("Should override only the description")
        void shouldBeFalseWithCustomErrorMessage() {
            assertThat(false).describedAs("The boolean is not false").isFalse();
        }
    }

    @Nested
    @DisplayName("When we provide the entire error message")
    class WhenWeProvideEntireErrorMessage {

        @Test
        @DisplayName("Should override entire error message")
        void shouldBeFalseWithCustomErrorMessage() {
            assertThat(false).overridingErrorMessage("The boolean is not false").isFalse();
        }
    }
}
