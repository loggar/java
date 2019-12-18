package com.loggar.optionals;

import java.util.Optional;

public class OptionalInit {
    public static void main(String[] args) {
        // Case 1: We know there's a value
        Optional<String> withValue = Optional.of("definitly a string");

        // Case 2: We 're not sure
        Optional<String> maybeValue = Optional.ofNullable(null);

        // Case 3: We're sure there's no value
        Optional<String> noValue = Optional.empty();

        if (withValue.isPresent()) {
            System.out.println("withValue There's definitly something there!");
        }

        if (!maybeValue.isPresent()) {
            System.out.println("maybeValue There may be something there!");
        }

        if (!noValue.isPresent()) {
            System.out.println("noValue There's definitly nothing there!");
        }

        // String str = noValue.get();
        // System.out.println(str);
        // java.util.NoSuchElementException: No value present

    }

    // Optional - Primitive Data Types:
    // java.util.OptionalDouble
    // java.util.OptionalInt
    // java.util.OptionalLong

    // Caveat
    // Optionals are just Java objects like any other object, so they might be null themselves. If we design an API and decide to use Optionals, we must not return null for an Optional, always use Optional.empty().
    // This has to be enforced by convention, the compiler can’t help us out, except with additional tooling and @NonNull annotations.
    // Other standard Java features that we shouldn’t use directly with Optionals are about equality: equals(...) and hashCode() are first about comparing the Optional, and only second about the value.
}
