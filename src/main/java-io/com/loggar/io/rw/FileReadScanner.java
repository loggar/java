package com.loggar.io.rw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class FileReadScanner {
    @Test
    public void test1() {
        File file = new File("./dist/io/scanner.1.txt");
        try {
            @SuppressWarnings("resource") Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
