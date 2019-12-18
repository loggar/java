package com.loggar.optionals;

import java.util.Optional;

public class OptionalOrElse {
    private static String doSomething() {
        return null;
    }

    public static void main(String[] args) {
        String value = Optional.ofNullable(doSomething())
                .orElse("default value");

        System.out.println(value);
    }
}
