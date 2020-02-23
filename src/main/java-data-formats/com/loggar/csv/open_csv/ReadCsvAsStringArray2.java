package com.loggar.csv.open_csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVReader;

public class ReadCsvAsStringArray2 {
    public static void main(String[] args) {
        // create a csv reader
        try (Reader reader = Files.newBufferedReader(Paths.get("./dist/csv/users.1.csv")); CSVReader csvReader = new CSVReader(reader)) {

            // read one record at a time
            String[] record;
            while ((record = csvReader.readNext()) != null) {
                System.out.println("User[" + String.join(", ", record) + "]");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
