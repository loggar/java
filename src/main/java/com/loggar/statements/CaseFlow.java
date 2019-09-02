package com.loggar.statements;

public class CaseFlow {
    public static void main(String[] args) {
        int x = 10;

        switch (x) {
        case 10:
            System.out.println("here 1");
            x += 15;
        case 12:
            System.out.println("here 2");
            x -= 5;
            break;
        default:
            System.out.println("here 3");
            x *= 3;
        }
        
        System.out.println(x);
    }
}
