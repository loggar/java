package com.loggar.statements;

public class ForCount {
    public static void main(String[] args) {
        int i = 0;
        for (int count = 10; count <= 21; count++) {
            System.out.println("Java is great!!!");
            System.out.println("How many times:" + (++i));
        }
    }
}
