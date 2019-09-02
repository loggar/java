package com.loggar.statements;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CountForBody {
    @Test
    public void countForBody() {
        int i = 0;
        for (int count = 10; count <= 21; count++) {
            System.out.println("Java is great!!!");
            i++;
        }

        assertTrue(i == 12);
    }
}
