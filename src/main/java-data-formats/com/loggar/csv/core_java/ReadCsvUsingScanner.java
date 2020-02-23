package com.loggar.csv.core_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadCsvUsingScanner {
    public static void main(String[] args) {
        try {
            // CSV file delimiter
            String DELIMITER = ",";

            // create a reader
            BufferedReader br = Files.newBufferedReader(Paths.get("./dist/csv/users.1.csv"));

            // read the file line by line
            String line;
            while ((line = br.readLine()) != null) {
                // convert line into tokens
                String[] tokens = line.split(DELIMITER);

                // TODO: do something here with the data

                // print all tokens
                for (String token : tokens) {
                    System.out.println(token);
                }
            }

            // close the reader
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
