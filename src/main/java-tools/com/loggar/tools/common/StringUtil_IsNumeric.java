package com.loggar.tools.common;

public class StringUtil_IsNumeric {
    private StringUtil_IsNumeric() {
        throw new AssertionError(StringUtil_IsNumeric.class.getName() + " cannot be instantiable.");
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
