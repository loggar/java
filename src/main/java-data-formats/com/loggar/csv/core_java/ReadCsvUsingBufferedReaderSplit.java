package com.loggar.csv.core_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadCsvUsingBufferedReaderSplit {
    public static void main(String[] args) {
        // create a reader
        try (BufferedReader br = Files.newBufferedReader(Paths.get("./dist/csv/users.1.csv"))) {

            // CSV file delimiter
            String DELIMITER = ",";

            // read the file line by line
            String line;
            while ((line = br.readLine()) != null) {

                // convert line into columns
                String[] columns = line.split(DELIMITER);

                // print all columns
                System.out.println("User[" + String.join(", ", columns) + "]");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
