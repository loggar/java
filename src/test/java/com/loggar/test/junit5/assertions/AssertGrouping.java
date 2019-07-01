package com.loggar.test.junit5.assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Group multiple assertions")
public class AssertGrouping {
    public class Person {

        private String firstName;
        private String lastName;

        public Person() {
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    private static final String FIRST_NAME = "Jane";
    private static final String LAST_NAME = "Doe";

    private Person person;

    @BeforeEach
    void createPerson() {
        person = new Person();
        person.setFirstName(FIRST_NAME);
        person.setLastName(LAST_NAME);
    }

    @Test
    @DisplayName("Should have the correct name")
    void shouldHaveCorrectName() {
        assertAll("name",
                () -> assertEquals(FIRST_NAME, person.getFirstName(), "The first name is incorrect"),
                () -> assertEquals(LAST_NAME, person.getLastName(), "The last name is incorrect"));
    }
}
