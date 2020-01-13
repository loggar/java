package com.loggar.exceptions;

public class FinallyWorks {
    public static int a() {
        int a;
        try {
            a = 1;
        } catch (Exception e) {
            a = 0;
        } finally {
            a = 2;
        }
        return a;
    }

    @SuppressWarnings("finally")
    public static int b() {
        try {
            return 1;
        } catch (Exception e) {
            return 0;
        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(a()); // 2
        System.out.println(b()); // 2
    }
}
