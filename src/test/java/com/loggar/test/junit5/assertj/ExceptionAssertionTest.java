package com.loggar.test.junit5.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Writing assertions for exceptions")
class ExceptionAssertionTest {

    @Nested
    @DisplayName("When we write assertions directly to the thrown exception")
    class WhenWeWriteAssertionsForThrownException {

        @Nested
        @DisplayName("When the system under test throws the correct exception")
        class WhenSystemUnderTestThrowsException {

            @Test
            @DisplayName("Should throw the correct exception")
            void shouldThrowCorrectException() {
                assertThatThrownBy(() -> {
                    throw new NullPointerException();
                }).isExactlyInstanceOf(NullPointerException.class);
            }
        }
    }

    @Nested
    @DisplayName("When we write assertions directly to the thrown exception")
    class WhenWeWriteAssertionsForThrownException2 {

        @Nested
        @DisplayName("When SUT throws an exception that has the correct message")
        class WhenSystemUnderTestThrowsExceptionWithCorrectMessage {

            @Test
            @DisplayName("Should throw an exception that has the correct message")
            void shouldThrowAnExceptionWithCorrectMessage() {
                assertThatThrownBy(() -> {
                    throw new NullPointerException("Hello World!");
                }).hasMessage("Hello World!");
            }
        }
    }

    @Nested
    @DisplayName("When we catch the thrown exception object")
    class WhenWeCatchThrownExceptionObject {

        @Nested
        @DisplayName("When the system under test throws the correct exception")
        class WhenSystemUnderTestThrowsException {

            @Test
            @DisplayName("Should throw the correct exception")
            void shouldThrowCorrectException() {
                final Throwable thrown = catchThrowable(() -> {
                    throw new NullPointerException();
                });
                assertThat(thrown).isExactlyInstanceOf(NullPointerException.class);
            }
        }
    }

    @Nested
    @DisplayName("When we catch the thrown exception object")
    class WhenWeCatchThrownExceptionObject2 {

        @Nested
        @DisplayName("When the system under test throws an exception that has the correct message")
        class WhenSystemUnderTestThrowsExceptionWithCorrectMessage {

            @Test
            @DisplayName("Should throw an exception that has the correct message")
            void shouldThrowAnExceptionWithCorrectMessage() {
                final Throwable thrown = catchThrowable(() -> {
                    throw new NullPointerException("Hello World!");
                });
                assertThat(thrown.getMessage()).isEqualTo("Hello World!");
            }
        }
    }
}
