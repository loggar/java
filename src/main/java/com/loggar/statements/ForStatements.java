package com.loggar.statements;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ForStatements {
    @Test
    public void countForBody() {
        // How many times will the following for loop be executed?
        int i = 0;
        for (int count = 10; count <= 21; count++) {
            System.out.println("Java is great!!!");
            i++;
        }

        assertTrue(i == 12);
    }
}
