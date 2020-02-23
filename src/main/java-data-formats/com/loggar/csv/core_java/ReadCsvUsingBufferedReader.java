package com.loggar.csv.core_java;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadCsvUsingBufferedReader {
    public static void main(String[] args) {
        try {
            // create scanner instance
            Scanner scanner = new Scanner(
                    Paths.get("./dist/csv/users.1.csv")
                            .toFile()
            );

            // set comma as delimiter
            scanner.useDelimiter(",");

            // read all fields
            while (scanner.hasNext()) {
                System.out.print(scanner.next() + " ");
            }

            // close the scanner
            scanner.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
