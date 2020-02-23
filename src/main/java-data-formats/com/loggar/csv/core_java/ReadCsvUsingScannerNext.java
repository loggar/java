package com.loggar.csv.core_java;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadCsvUsingScannerNext {
    public static void main(String[] args) {
        // create scanner instance
        try (
                Scanner scanner = new Scanner(
                        Paths.get("./dist/csv/users.1.csv")
                                .toFile()
                )
        ) {

            // CSV file delimiter
            String DELIMITER = ",";

            // set comma as delimiter
            scanner.useDelimiter(DELIMITER);

            // read all fields
            while (scanner.hasNext()) {
                System.out.print(scanner.next() + " ");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
