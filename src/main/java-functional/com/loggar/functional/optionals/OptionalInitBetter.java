package com.loggar.functional.optionals;

import java.util.Optional;

public class OptionalInitBetter {
    private static class OptionalSample {
        String buildResult() {
            return "Sample result";
        }

        String toUpCase() {
            String result = this.buildResult();
            if (result == null) {
                return "n/a";
            }
            return result.toUpperCase();
        }

        String toUpCaseOptional() {
            return Optional.ofNullable(buildResult())
                    .map(String::toUpperCase)
                    .orElse("n/a");
        }
    }

    public static void main(String[] args) {
        OptionalSample optionalSample = new OptionalSample();
        System.out.println(optionalSample.toUpCase());
        System.out.println(optionalSample.toUpCaseOptional());
    }
}
