package com.loggar.reflection;

import java.lang.invoke.MethodHandles;

public class ClassNameMethodName {
    public static void main(String[] args) {
        System.out.println(MethodHandles.lookup().lookupClass());
        System.out.println(MethodHandles.lookup().lookupClass().getCanonicalName());
        System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName());
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        method1();
    }

    private static void method1() {
        System.out.println(MethodHandles.lookup().lookupClass().getCanonicalName());
        System.out.println(MethodHandles.lookup().lookupClass());
        System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName());
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
